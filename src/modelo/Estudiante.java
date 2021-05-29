package modelo;

import bd.MiConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan Pacheco R.
 * @version 0.1
 *
 */
public class Estudiante {

    public void inUpDelEstudiante(char operation, Integer id, String nombre,
            String apellido, String sexo, String nacimiento,
            String telefono, String direccion) {

        Connection con = MiConexion.getConnection();
        PreparedStatement ps;

        if (operation == 'i') { // i = Insertar o Agregar estudiante
            try {
                ps = con.prepareStatement("INSERT INTO estudiante(nombre, apellido, sexo, nacimiento, telefono, direccion) VALUES (?,?,?,?,?,?)");
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, sexo);
                ps.setString(4, nacimiento);
                ps.setString(5, telefono);
                ps.setString(6, direccion);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente");

                }

            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'e') { // e = Editar o Actualizar estudiante
            try {
                ps = con.prepareStatement("UPDATE `estudiante` SET `nombre` = ?, `apellido` = ?, `sexo` = ?, `nacimiento` = ?, `telefono` = ?, `direccion`= ? WHERE `id` = ?");
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, sexo);
                ps.setString(4, nacimiento);
                ps.setString(5, telefono);
                ps.setString(6, direccion);
                ps.setInt(7, id);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");

                }

            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'b') { // b = Borrar o elimina estudiante
            
            int SiONo = JOptionPane.showConfirmDialog(null, "Las notas asociadas a este estudiante también serán borradas. ¿Quieres seguir?","Eliminar estudiante",JOptionPane.OK_CANCEL_OPTION, 0);
            
            if (SiONo == 0) {
                try {
                    ps = con.prepareStatement("DELETE FROM `estudiante` WHERE `id` = ?");
                    ps.setInt(1, id);
                    if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "Datos de estudiante eliminados exitosamente");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void llenarJTEstudiante(JTable table, String valueToSearch){
        Connection con = MiConexion.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("SELECT * FROM `estudiante` WHERE CONCAT(`nombre`, `apellido`, `telefono`, `direccion`) LIKE ?");
            ps.setString(1, "%"+valueToSearch+"%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object[7];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                
                model.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
