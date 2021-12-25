package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.categorie;
import model.produit;
import projectwassim.Conx_BD;
public class gestionproduit {
	Conx_BD connbase = new Conx_BD();
    Connection conn = connbase.obtenirconnexion();
    
    public gestionproduit() {
		super();
	}
    
    
    
    
 // Select produit from data base 
	public void SelectProduit(){
        
        String sql = "SELECT * FROM produit";

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
   String description = result.getString("description");
   String quantite = result.getString("quantite");
   String prix = result.getString("prix");	
   String statut = result.getString("statut");	
   String idcat = result.getString("id_categorie");
   int idcatint = Integer.parseInt(idcat);
   categorie cat = new categorie(idcatint, idcat, idcat, idcat);
   produit prod = new produit(idint,nom,description,quantite,prix,statut,cat);
   String output = "Produit #%d: %s - %s - %s - %s - %s - %s - %s";
   System.out.println(String.format(output, ++count, prod.getId(), prod.getNom(), prod.getDescription(),prod.getQte(),prod.getPrix(),prod.getStatus(),cat));
}

      
      } catch (SQLException ex) {
          System.out.println("Une erreur est survenue ! "); 
          
       }
    }
    
	// DELETE produit from data base
	public boolean DeleteProd(produit prod){
        String sql = "DELETE FROM produit WHERE id=?";

PreparedStatement statement;
      try 
      {
          
  statement = conn.prepareStatement(sql);
statement.setString(1, Integer.toString(prod.getId()));

statement.executeUpdate();

System.out.println( prod.getId()  +"Deleted succefully");
} catch (SQLException ex) {
         
         return false;
      }
      return false;
    }
	
	
	
	
	
	
	//Insert produit to data base
	   public boolean insertproduit(produit prod){
		    String sql = "INSERT INTO produit (id, nom, description,quantite,prix,statut,id_categorie) VALUES (?, ?, ?,?,?, ?, ?)";
		    PreparedStatement statement;
		        try 
		        {
		        statement = conn.prepareStatement(sql);
		        statement.setString(1, null);
		        statement.setString(2, prod.getNom());
		        statement.setString(3, prod.getDescription());
		        statement.setString(4, prod.getQte());
		        statement.setString(5, prod.getPrix());
		        statement.setString(6, prod.getStatus());
		        statement.setString(7, Integer.toString(prod.getId_categorie().getId()));
		         
		        int rowsInserted = statement.executeUpdate();
		        
		            if(rowsInserted > 0) {
		            	System.out.println(  prod.getNom() +"produit inserted succefully");
		            return true ;
		            }else{
		            return false;
		            }
		        } catch (SQLException ex) {
		         
		            return false;
		        }
		       
		        
		    }
	   
	   
	   
	   
	   //Update produit in Data base
	   public boolean UpdateProduit(produit prod){
	          String sql = "UPDATE produit SET nom=? , description =?,quantite=?,prix=?,statut=?,id_categorie=? WHERE id=?";
	 
	PreparedStatement statement;
	        try  
	        {
	    statement = conn.prepareStatement(sql);
	statement.setString(1,prod.getNom());
	statement.setString(2,prod.getDescription());
	statement.setString(3,prod.getQte());
	statement.setString(4,prod.getPrix());
	statement.setString(5,prod.getStatus());
	statement.setString(6,Integer.toString(prod.getId_categorie().getId()));
	statement.setString(7, Integer.toString(prod.getId()));
	 
	int rowsUpdated = statement.executeUpdate();
	if (rowsUpdated > 0) {
		System.out.println(prod.getNom() +" Produit updated succefully");
	    return true;
	}
	 } catch (SQLException ex) {
	           
	           return false;
	        }
	        return false;
	      }
	
    

}
