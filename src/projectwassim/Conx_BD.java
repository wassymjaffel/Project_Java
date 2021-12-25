package projectwassim;
import java.sql.*;
public class Conx_BD {
    
    Connection con;
    
    public Conx_BD(){
    	 String user="root";
    	 String pass="";
    	 String url = "jdbc:mysql://localhost:3306/projectjava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
    	
      try{
          Class.forName("com.mysql.cj.jdbc.Driver"); 
      }catch(ClassNotFoundException e){
          
          System.err.println(e); 
      }
      try{
          

          con=DriverManager.getConnection(url,user,pass);
          
      }catch(SQLException e){
          System.err.println(e);
      }
    }
    public Connection obtenirconnexion(){
        return con;
    }
    
}
