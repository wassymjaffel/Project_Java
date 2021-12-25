package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.categorie;
import projectwassim.Conx_BD;
public class gestioncategorie {
	List<categorie> listcat = new ArrayList<categorie>();
    Conx_BD connbase = new Conx_BD();
    Connection conn = connbase.obtenirconnexion();
    
	public void gestionCategorie() {
		
	}
 
    
	
	
	// Select categorie from data base 
	public void SelectCat(){
        
        String sql = "SELECT * FROM categorie";

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
   String statue = result.getString("statut");
   categorie cat = new categorie(idint, nom,description,statue);
   String output = "Catégorie #%d: %s - %s - %s";
   System.out.println(String.format(output, ++count, cat.getId(), cat.getNom(), cat.getDescription(),cat.getStatue()));
}

      
      } catch (SQLException ex) {
          System.out.println("Une erreur est survenue ! "); 
          
       }
    }
    
	// DELETE categorie from data base
	public boolean DeleteCat(categorie cat){
        String sql = "DELETE FROM categorie WHERE id=?";

PreparedStatement statement;
      try 
      {
          
  statement = conn.prepareStatement(sql);
statement.setString(1, Integer.toString(cat.getId()));

statement.executeUpdate();

System.out.println( cat.getId() +"-"+ cat.getNom() +"Deleted succefully");
} catch (SQLException ex) {
         
         return false;
      }
      return false;
    }
    
	
	
	
	
	
	
	//Insert category to data base
	   public boolean InsertCat(categorie cat){
		    String sql = "INSERT INTO categorie (id, nom, description,statut) VALUES (?, ?, ?,?)";
		    PreparedStatement statement;
		        try 
		        {
		        statement = conn.prepareStatement(sql);
		        statement.setString(1, null);
		        statement.setString(2, cat.getNom());
		        statement.setString(3, cat.getDescription());
		        statement.setString(4, cat.getStatue());
		         
		        int rowsInserted = statement.executeUpdate();
		        
		            if(rowsInserted > 0) {
		            	System.out.println(  cat.getNom() +"Categorie inserted succefully");
		            return true ;
		            }else{
		            return false;
		            }
		        } catch (SQLException ex) {
		         
		            return false;
		        }
		       
		        
		    }
	
	
	
	   
	   
	   //Update Categorie in Data base
	   public boolean UpdateCat(categorie cat){
	          String sql = "UPDATE categorie SET nom=? , description =?,statut=? WHERE id=?";
	 
	PreparedStatement statement;
	        try  
	        {
	    statement = conn.prepareStatement(sql);
	statement.setString(1,cat.getNom());
	statement.setString(2,cat.getDescription());
	statement.setString(3,cat.getStatue());
	statement.setString(4, Integer.toString(cat.getId()));
	 
	int rowsUpdated = statement.executeUpdate();
	if (rowsUpdated > 0) {
		System.out.println(cat.getNom() +"Categorie updated succefully");
	    return true;
	}
	 } catch (SQLException ex) {
	           
	           return false;
	        }
	        return false;
	      }
	
	

	
}