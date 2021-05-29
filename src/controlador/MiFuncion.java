package controlador;

import bd.MiConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lloni
 * @version 0.1
 * 
 */
public class MiFuncion {
    
    public static int contarData(String tableName) {
        
        int total = 0;
        Connection con = MiConexion.getConnection();
        Statement st;
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS 'total' FROM "+tableName);
            
            while(rs.next()){
                total = rs.getInt(1);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(MiFuncion.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return total;
    }
    
}
