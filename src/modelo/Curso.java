package modelo;

import bd.MiConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan Pacheco R.
 * @version 0.1
 *
 */

public class Curso {
    
        public void inUpDelCurso(char operation, Integer id, String etiqueta, Integer creditos) {

        Connection con = MiConexion.getConnection();
        PreparedStatement ps;

        if (operation == 'i') { // i = Insertar o Agregar estudiante
            try {
                ps = con.prepareStatement("INSERT INTO `curso` (`etiqueta`, `creditos`) VALUES (?,?)");
                ps.setString(1, etiqueta);
                ps.setInt(2, creditos);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Curso agregado exitosamente");

                }

            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'e') { // e = Editar o Actualizar estudiante
            try {
                ps = con.prepareStatement("UPDATE `curso` SET `etiqueta` = ?, `creditos` = ? WHERE `id` = ?");
                ps.setString(1, etiqueta);
                ps.setInt(2, creditos);
                ps.setInt(3, id);

                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (operation == 'b') { // b = Borrar o elimina estudiante
            
            int SiONo = JOptionPane.showConfirmDialog(null, "Las notas asociadas a este curso también serán borradas. ¿Quieres seguir?","Eliminar curso",JOptionPane.OK_CANCEL_OPTION, 0);
            
            if (SiONo == 0) {
                try {
                    ps = con.prepareStatement("DELETE FROM `curso` WHERE `id` = ?");
                    ps.setInt(1, id);
                    if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(null, "Datos de curso eliminados exitosamente");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
        
    public boolean cursoExiste(String nombreCurso) {
        
        boolean existe = false;
        Connection con = MiConexion.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("SELECT * FROM `curso` WHERE `etiqueta` LIKE ?");
            ps.setString(1, nombreCurso);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                existe = true;
            } 
                    
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return existe;
    }
    
    public void llenarJTCurso(JTable table){
        Connection con = MiConexion.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("SELECT * FROM `curso`");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()){
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3);
                model.addRow(row);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getIdCurso(String etiquetaCurso) {

        int idCurso = 0;        
        Connection con = MiConexion.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("SELECT * FROM `curso` WHERE `etiqueta` LIKE ?");
            ps.setString(1, etiquetaCurso);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                idCurso = rs.getInt("Id");
            }               
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return idCurso;   
    }
    
    public void llenarComboCurso(JComboBox combo){
        Connection con = MiConexion.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("SELECT * FROM `curso`");
            ResultSet rs = ps.executeQuery();

            
            while(rs.next()){
                combo.addItem(rs.getString(2));
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
