package bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lloni
 */
public class MiConexion {
    
    public static Connection getConnection() {
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gestion_estudiantes","root","");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }   
        return con;
    }
}