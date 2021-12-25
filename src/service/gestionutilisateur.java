package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.utilisateur;
import projectwassim.Conx_BD;

//CRUD utilisateur
public class gestionutilisateur {
	List<utilisateur> listutilisateur = new ArrayList<utilisateur>();
    Conx_BD connbase = new Conx_BD();
    Connection conn = connbase.obtenirconnexion();
    
	public gestionutilisateur() {
		super();
	}
	
	
	
	// Select utilisateur from data base 
		public void Selectutilisateur(){
			 String sql = "SELECT * FROM utilisateur";
			  PreparedStatement statement;
		       try 
		       {
		        statement = conn.prepareStatement(sql);
		        ResultSet result = statement.executeQuery(sql);
		        
		int count = 0;

		while (result.next()){
		   String id = result.getString("id");
		   int idint = Integer.parseInt(id);
		   String nom = result.getString("nom");
		   String pseudo= result.getString("pseudo");
		   String motdepasse= result.getString("motdepasse");
		   String telephone= result.getString("telephone");
		   String role= result.getString("role");
		   String statue= result.getString("statue");
		   int statueint = Integer.parseInt(statue);
		   String output = "utilisateur #%d: %s - %s - %s - %s - %s";
		   utilisateur utila = new utilisateur(idint,nom,pseudo,motdepasse,telephone,role,statueint);
		System.out.println(String.format(output, ++count, utila.getId(),  utila.getNom(),  utila.getPseudo(),  utila.getMotdepasse(),  utila.getTelephone(),  utila.getRole()));
		   
		}

	      
		       } catch (SQLException ex) {
		           System.out.println("Une erreur est survenue ! "); 
		           
		        }
		     }
		
		
		
		// DELETE utilisateur from data base
		public boolean Deleteutilisateur(utilisateur utilisateur){
	        String sql = "DELETE FROM utilisateur WHERE id=?";

	PreparedStatement statement;
	      try 
	      {
	          
	  statement = conn.prepareStatement(sql);
	statement.setString(1, Integer.toString(utilisateur.getId()));

	statement.executeUpdate();

	System.out.println( utilisateur.getId() +"-"+ utilisateur.getNom() +"Deleted succefully");
	} catch (SQLException ex) {
	         
	         return false;
	      }
	      return false;
	    }
	    
		
		
		

		//Insert user to data base
		   public boolean Insertutilisateur(utilisateur utilisateur){
			    String sql = "INSERT INTO utilisateur (id, nom, pseudo,motdepasse,telephone,role,statue) VALUES (?, ?, ?,?,?,?,?)";
			    PreparedStatement statement;
			        try 
			        {
			        statement = conn.prepareStatement(sql);
			        statement.setString(1, null);
			        statement.setString(2, utilisateur.getNom());
			        statement.setString(3, utilisateur.getPseudo());
			        statement.setString(4, utilisateur.getMotdepasse());
			        statement.setString(5, utilisateur.getTelephone());
			        statement.setString(6, utilisateur.getRole());
			        statement.setString(7, Integer.toString(1));
			         
			        int rowsInserted = statement.executeUpdate();
			        
			            if(rowsInserted > 0) {
			            	System.out.println(  utilisateur.getNom() +"utilisateur inserted succefully");
			            return true ;
			            }else{
			            return false;
			            }
			        } catch (SQLException ex) {
			         
			            return false;
			        }
			        
			        
		   }
			
		   
		   
		   //Update utilisateur in Data base
		   public boolean Updateutilisateur(utilisateur utilisateur){
		          String sql = "UPDATE utilisateur SET nom=? , pseudo =?,motdepasse=?,telephone=?,role=?,statue=? WHERE id=?";
		 
		PreparedStatement statement;
		        try 
		        {
		    statement = conn.prepareStatement(sql);
		statement.setString(1,utilisateur.getNom());
		statement.setString(2,utilisateur.getPseudo());
		statement.setString(3,utilisateur.getMotdepasse());
		statement.setString(4,utilisateur.getTelephone());
		statement.setString(5,utilisateur.getRole());
		statement.setString(6, Integer.toString(utilisateur.getStatue()));
		statement.setString(7, Integer.toString(utilisateur.getId()));
		
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			System.out.println(utilisateur.getNom() +"utilisateur updated succefully");
		    return true;
		}
		 } catch (SQLException ex) {
		           
		           return false;
		        }
		        return false;
		      }
		
		
		
	}
			        
			    
			        


