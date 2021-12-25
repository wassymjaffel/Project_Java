package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.produit;
import model.utilisateur;
import model.categorie;
import model.commande;
import model.product_commande;
import projectwassim.Conx_BD;
public class gestioncommande {

	Conx_BD connbase = new Conx_BD();
    Connection conn = connbase.obtenirconnexion();
	
	public gestioncommande() {
		super();
	}
	
	
	
	// Select Commande from data base 
		public void SelectCommande(){
	        
	        String sql = "SELECT * FROM commande INNER JOIN utilisateur ON commande.id_agent=utilisateur.id INNER JOIN product_commande ON commande.id = product_commande.commande INNER JOIN produit ON product_commande.produit = produit.id";

	        PreparedStatement statement;
	       try 
	       {
	        statement = conn.prepareStatement(sql);
	        ResultSet result = statement.executeQuery(sql);
	        
	int count = 0;

	while (result.next()){
	   //utilisateur
	   String id_agent = result.getString("id_agent");
	   int id_agentint = Integer.parseInt(id_agent);
	   String nom = result.getString("nom");
	   String pseudo= result.getString("pseudo");
	   String motdepasse= result.getString("motdepasse");
	   String telephone= result.getString("telephone");
	   String role= result.getString("role");
	   utilisateur utila = new utilisateur(id_agentint,nom,pseudo,motdepasse,telephone,role,1);
	   //commande
	   String id = result.getString("id");
	   int idCommandeint = Integer.parseInt(id);
	   String total = result.getString("total");
	   String statue = result.getString("statue");
	   commande commande = new commande(idCommandeint, total, statue, utila);
	   //Produit
	   String idproduit = result.getString("produit");
	   int idintprod = Integer.parseInt(idproduit);
	   String nomprod = result.getString("nom");
	   String descriptionprod = result.getString("description");
	   String quantiteprod = result.getString("quantite");
	   String prixprod = result.getString("prix");	
	   String statutprod = result.getString("statut");
	   String idcat = result.getString("id_categorie");
	   int idintcat = Integer.parseInt(idcat);
	   categorie catprod = new categorie(idintcat, idcat, idcat, idcat);
	   produit prod = new produit(idintprod, nomprod, descriptionprod, quantiteprod, prixprod, statutprod, catprod);
	   
	   product_commande commande_prod = new product_commande(commande, prod);
	   
	
	   System.out.println("commandes :"+commande_prod);
	}

	      
	      } catch (SQLException ex) {
	          System.out.println("Une erreur est survenue ! "); 
	          
	       }
	    }
		
		
		
		// DELETE commande from data base
		public boolean DeleteCommande(commande com){
	        String sql = "DELETE FROM commande WHERE id=?";

	PreparedStatement statement;
	      try 
	      {
	          
	  statement = conn.prepareStatement(sql);
	statement.setString(1, Integer.toString(com.getId()));

	statement.executeUpdate();

	System.out.println( com.getId() +" - "+"Deleted succefully");
	} catch (SQLException ex) {
	         
	         return false;
	      }
	      return false;
	    }
		
		
		
           // Insert Commande to Data base
		 public boolean InsertCommande(commande com,produit prod){
			    String sql = "INSERT INTO commande (id, total, statue, id_agent) VALUES (?, ?, ?,?)";
			    PreparedStatement statement = null;
			        try 
			        {
			        statement = conn.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
			        statement.setString(1, null);
			        statement.setString(2, com.getTotal());
			        statement.setString(3, com.getStatue());
			        statement.setString(4, Integer.toString(com.getId_agent().getId()));
			         
			        int rowsInserted = statement.executeUpdate();
			        
			            if(rowsInserted > 0) {
			            	try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
			                    if (generatedKeys.next()) {
			                    	com.setId((int) generatedKeys.getLong(1));
			                    }
			                    else {
			                        throw new SQLException("Creating commande failed, no ID obtained.");
			                    }
			                }
			            	String sql1 = "INSERT INTO product_commande (commande, produit) VALUES (?, ?)";
						    PreparedStatement statement1;
						        try 
						        {
						        statement1 = conn.prepareStatement(sql1);
						        statement1.setString(1, Integer.toString(com.getId()));
						        statement1.setString(2, Integer.toString(prod.getId()));
						        
						         
						        int rowsInserted1 = statement1.executeUpdate();
						        
						            if(rowsInserted1 > 0) {
						        		System.out.println(  com +" - "+ prod  +"Inserted succefully");
						            return true ;
						            }else{
						            return false;
						            }
						        } catch (SQLException ex) {
						         
						            return false;
						        }
			            	
			            	
			            	
			            	
			            	
			     
			            }else{
			            return false;
			            }
			        } catch (SQLException ex) {
			         
			            return false;
			        }
			       
			        
			    }
		
		
		 
		 //Update Commande in Data base
		   public boolean UpdateCommande(commande com, produit prod){
		          String sql = "UPDATE commande SET total =?, statue =?, id_agent =? WHERE id=?";
		 
		PreparedStatement statement;
		        try  
		        {
		    statement = conn.prepareStatement(sql);
		statement.setString(1,com.getTotal());
		statement.setString(2,com.getStatue());
		statement.setString(3,Integer.toString(com.getId_agent().getId()));
		statement.setString(4, Integer.toString(com.getId()));
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			String sql1 = "UPDATE product_commande SET produit =? WHERE commande =?";
			 
			PreparedStatement statement1;
			        try  
			        {
			    statement1 = conn.prepareStatement(sql1);
			
			statement1.setString(1,Integer.toString(prod.getId()));
			statement1.setString(2, Integer.toString(com.getId()));
			 
			int rowsUpdated1 = statement1.executeUpdate();
			
			if (rowsUpdated1 > 0) {
				System.out.println("Commande updated succefully");
			}
			        }catch (Exception e) {
						
					}
			
			
			
			
			
			
		    return true;
		}
		 } catch (SQLException ex) {
		           
		           return false;
		        }
		        return false;
		      }

}
