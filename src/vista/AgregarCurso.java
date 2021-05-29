package vista;

import controlador.MiFuncion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;

/**
 *
 * @author Jonathan Pacheco R.
 * @version 0.1
 *
 */
public class AgregarCurso extends javax.swing.JFrame {

    Curso cur = new Curso();
    
    public AgregarCurso() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtf_nombre_curso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        spn_creditos = new javax.swing.JSpinner();
        btn_agregar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 24)); // NOI18N
        jLabel1.setText("Agregar curso");

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 0, 13)); // NOI18N
        jLabel2.setText("Nombre del curso::");

        txtf_nombre_curso.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        txtf_nombre_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf_nombre_cursoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Myriad Pro", 0, 13)); // NOI18N
        jLabel8.setText("Créditos:");

        spn_creditos.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        spn_creditos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        btn_agregar.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btn_agregar.setText("AGREGAR");
        btn_agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 102)));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_cancelar.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addComponent(spn_creditos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtf_nombre_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtf_nombre_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spn_creditos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtf_nombre_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf_nombre_cursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtf_nombre_cursoActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        
        if (!cur.cursoExiste(txtf_nombre_curso.getText())) {
            String etiqueta = txtf_nombre_curso.getText();
            int creditos = Integer.valueOf(spn_creditos.getValue().toString());
            cur.inUpDelCurso('i', null, etiqueta, creditos);
            FormularioPrincipal.lbl_cant_cur.setText("Cantidad de cursos: "+Integer.toString(MiFuncion.contarData("curso")));
            GestionarCurso.tbl_cursos.setModel(new DefaultTableModel(null, new Object[]{"Identificador","Nombre","Créditos"}));
            cur.llenarJTCurso(GestionarCurso.tbl_cursos);

        } else {
            JOptionPane.showMessageDialog(null, "Ya existe el curso");
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        this.dispose();
//        if (txtf_id_est.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "Selecciona a un estudiante primero");
//        } else {
//            int id = Integer.valueOf(txtf_id_est.getText());
//            est.inUpDelEstudiante('b', id, null, null, null, null, null, null);
//            est.llenarJTEstudiante(tbl_estudiantes, "");
//            tbl_estudiantes.setModel(new DefaultTableModel(null, new Object[]{"Identificador", "Nombre(s)", "Apellido(s)", "Sexo", "Fecha nac.", "Teléfono", "Dirección"}));
//            est.llenarJTEstudiante(tbl_estudiantes, txtf_buscar.getText());
//            FormularioPrincipal.lbl_cant_est.setText("Cantidad de estudiantes: "+Integer.toString(MiFuncion.contarData("estudiante")));
//
//            txtf_id_est.setText("");
//            txtf_nombre.setText("");
//            txtf_apellido.setText("");
//            txtf_telefono.setText("");
//            txta_direccion.setText("");
//            rbtn_fem.setSelected(false);
//            rbtn_mas.setSelected(false);
//            dch_nacimiento.setDate(null);
//
//        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spn_creditos;
    private javax.swing.JTextField txtf_nombre_curso;
    // End of variables declaration//GEN-END:variables
}