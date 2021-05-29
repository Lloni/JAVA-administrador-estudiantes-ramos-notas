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

public class Nota {
    
    public void inUpDelNota(char operation, Integer idEs, Integer idCu, Double nota, String coment) {

        Connection con = MiConexion.getConnection();
        PreparedStatement ps;

        if (operation == 'i') { // i = Insertar o Agregar estudiante
            try {
                ps = con.prepareStatement("INSERT INTO `nota` (`id_estudiante`, `id_curso`, `nota_estudiante`, `comentario`) VALUES (?,?,?,?)");
                ps.setInt(1, idEs);
                ps.setInt(2, idCu);
                ps.setDouble(3, nota);
                ps.setString(4, coment);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Nota agregada exitosamente");

                }

            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'e') { // e = Editar o Actualizar estudiante
            try {
                ps = con.prepareStatement("UPDATE `nota` SET `nota_estudiante` = ?, `comentario` = ? WHERE `id_estudiante` = ? AND `id_curso` = ?");
                ps.setDouble(1, nota);
                ps.setString(2, coment);
                ps.setInt(3, idEs);
                ps.setInt(4, idCu);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'b') { // b = Borrar o elimina estudiante
            try {
                ps = con.prepareStatement("DELETE FROM `nota` WHERE `id_estudiante` = ? AND `id_curso` = ?");
                ps.setInt(1, idEs);
                ps.setInt(2, idCu);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Nota eliminada exitosamente");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void llenarJTNota(JTable table){
        Connection con = MiConexion.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("SELECT * FROM `nota`");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object[4];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getDouble(3);
                row[3] = rs.getString(4);
                model.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
