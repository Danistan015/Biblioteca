/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorPrestamoDevolucion;
import Modelo.PrestamoDevolucion;
import Modelo.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.Pdf;

/**
 *
 * @author sotog
 */
public class VistaReporPrestamo extends javax.swing.JFrame {

    Usuario usuario;
    ControladorPrestamoDevolucion controlador;
    Pdf pdf;
    ArrayList<PrestamoDevolucion> lista;

    /**
     * Creates new form VistaReporPrestamo
     */
    public VistaReporPrestamo(Usuario usuario) {
        initComponents();
        setLocationRelativeTo(this);
        this.usuario = usuario;
        controlador = new ControladorPrestamoDevolucion();
        pdf = new Pdf();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnReporteGeneral = new javax.swing.JButton();
        btnReporteUsuario = new javax.swing.JButton();
        btnReporteFechas = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(4, 13, 18));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(24, 61, 61));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/bookshelf-in-library-vector.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(147, 177, 166));
        jLabel1.setText("Reportes de los prestamos:");

        btnReporteGeneral.setBackground(new java.awt.Color(24, 61, 61));
        btnReporteGeneral.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnReporteGeneral.setForeground(new java.awt.Color(147, 177, 166));
        btnReporteGeneral.setText("Generar reporte general");
        btnReporteGeneral.setActionCommand("Inicio");
        btnReporteGeneral.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnReporteGeneralMouseMoved(evt);
            }
        });
        btnReporteGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteGeneralActionPerformed(evt);
            }
        });

        btnReporteUsuario.setBackground(new java.awt.Color(24, 61, 61));
        btnReporteUsuario.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnReporteUsuario.setForeground(new java.awt.Color(147, 177, 166));
        btnReporteUsuario.setText("Generar reporte del usuario");
        btnReporteUsuario.setActionCommand("Inicio");
        btnReporteUsuario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnReporteUsuarioMouseMoved(evt);
            }
        });
        btnReporteUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteUsuarioActionPerformed(evt);
            }
        });

        btnReporteFechas.setBackground(new java.awt.Color(24, 61, 61));
        btnReporteFechas.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnReporteFechas.setForeground(new java.awt.Color(147, 177, 166));
        btnReporteFechas.setText("Generar reporte entre un rango de fechas");
        btnReporteFechas.setActionCommand("Inicio");
        btnReporteFechas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnReporteFechasMouseMoved(evt);
            }
        });
        btnReporteFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteFechasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReporteUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReporteGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReporteFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(btnReporteGeneral)
                .addGap(18, 18, 18)
                .addComponent(btnReporteUsuario)
                .addGap(18, 18, 18)
                .addComponent(btnReporteFechas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Más");

        jMenuItem2.setText("Volver");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteGeneralMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteGeneralMouseMoved
        // TODO add your handling code here:
        btnReporteGeneral.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnReporteGeneralMouseMoved

    private void btnReporteGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteGeneralActionPerformed
        try {
            lista = controlador.listaPrestamosDevolucionesGenerales(PrestamoDevolucion.PRESTADO);
            pdf.pdfPrestamoDevolucionGeneral(lista, "Prestamo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al generar el reporte");
        }
    }//GEN-LAST:event_btnReporteGeneralActionPerformed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved

        btnReporteGeneral.setForeground(Color.lightGray);
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new VistaReportes(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnReporteUsuarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteUsuarioMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteUsuarioMouseMoved

    private void btnReporteUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteUsuarioActionPerformed
        // TODO add your handling code here:
        try {
            lista = controlador.listaPrestamosDevolucionesPorUsuario(usuario.getCedula(), PrestamoDevolucion.PRESTADO);
            pdf.pdfPrestamoDevolucionIndividual(lista, "Prestamo",usuario.getCedula());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al generar el reporte");
        }
    }//GEN-LAST:event_btnReporteUsuarioActionPerformed

    private void btnReporteFechasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteFechasMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteFechasMouseMoved

    private void btnReporteFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteFechasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteFechasActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporteFechas;
    private javax.swing.JButton btnReporteGeneral;
    private javax.swing.JButton btnReporteUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
