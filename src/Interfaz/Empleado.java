/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Alertas.Sesion;
import Paneles.AgregarEmpleado;
import Paneles.CambiaPanel;
import Paneles.ConsultaEmpleado;
import Paneles.EliminarEmpleado;
import Paneles.ModificarEmpleado;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Gibran Ramses
 */
public class Empleado extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Empleado() {
        initComponents();
        new CambiaPanel(PanelPrincipal, new ConsultaEmpleado());
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
        rSButtonMetro2 = new rsbuttom.RSButtonMetro();
        jLabel1 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        minBtn = new javax.swing.JPanel();
        minTxt = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtUsuarioEm = new javax.swing.JLabel();
        BotonBu = new rsbuttom.RSButtonMetro();
        BotonMo = new rsbuttom.RSButtonMetro();
        BotonAg = new rsbuttom.RSButtonMetro();
        BotonEl = new rsbuttom.RSButtonMetro();
        BotonSa = new rsbuttom.RSButtonMetro();
        BotonIn = new rsbuttom.RSButtonMetro();
        PanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(67, 141, 184));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonMetro2.setBackground(new java.awt.Color(67, 141, 184));
        rSButtonMetro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MENU/menu.png"))); // NOI18N
        rSButtonMetro2.setColorHover(new java.awt.Color(67, 141, 184));
        rSButtonMetro2.setColorNormal(new java.awt.Color(67, 141, 184));
        rSButtonMetro2.setColorPressed(new java.awt.Color(67, 141, 184));
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonMetro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Doctolandia - Empleado");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 430, 30));

        exitBtn.setBackground(new java.awt.Color(67, 141, 184));

        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(255, 255, 255));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exitBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exitBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 10, -1, -1));

        minBtn.setBackground(new java.awt.Color(67, 141, 184));

        minTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        minTxt.setForeground(new java.awt.Color(255, 255, 255));
        minTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minTxt.setText("---");
        minTxt.setToolTipText("");
        minTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        minTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        minTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout minBtnLayout = new javax.swing.GroupLayout(minBtn);
        minBtn.setLayout(minBtnLayout);
        minBtnLayout.setHorizontalGroup(
            minBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, minBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(minTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        minBtnLayout.setVerticalGroup(
            minBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, minBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(minTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(minBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 10, -1, -1));

        PanelMenu.setBackground(new java.awt.Color(67, 141, 184));
        PanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(67, 141, 184));

        txtUsuarioEm.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtUsuarioEm.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuarioEm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MENU/USER.png"))); // NOI18N
        txtUsuarioEm.setText("Administrador");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsuarioEm, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsuarioEm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        BotonBu.setBackground(new java.awt.Color(67, 141, 184));
        BotonBu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VENTANAS/CONSULTA.png"))); // NOI18N
        BotonBu.setText("Buscar");
        BotonBu.setColorNormal(new java.awt.Color(67, 141, 184));
        BotonBu.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        BotonBu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonBu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BotonBu.setIconTextGap(25);
        BotonBu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuActionPerformed(evt);
            }
        });
        PanelMenu.add(BotonBu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 240, 43));

        BotonMo.setBackground(new java.awt.Color(67, 141, 184));
        BotonMo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VENTANAS/MODIFICAR.png"))); // NOI18N
        BotonMo.setText("Modificar");
        BotonMo.setToolTipText("");
        BotonMo.setColorNormal(new java.awt.Color(67, 141, 184));
        BotonMo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        BotonMo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonMo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BotonMo.setIconTextGap(25);
        BotonMo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMoActionPerformed(evt);
            }
        });
        PanelMenu.add(BotonMo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 239, 44));

        BotonAg.setBackground(new java.awt.Color(67, 141, 184));
        BotonAg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VENTANAS/AGREGAR.png"))); // NOI18N
        BotonAg.setText("Agregar");
        BotonAg.setColorNormal(new java.awt.Color(67, 141, 184));
        BotonAg.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        BotonAg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonAg.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BotonAg.setIconTextGap(25);
        BotonAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgActionPerformed(evt);
            }
        });
        PanelMenu.add(BotonAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 239, 46));

        BotonEl.setBackground(new java.awt.Color(67, 141, 184));
        BotonEl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VENTANAS/ELIMINAR.png"))); // NOI18N
        BotonEl.setText("Eliminar");
        BotonEl.setColorNormal(new java.awt.Color(67, 141, 184));
        BotonEl.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        BotonEl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonEl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BotonEl.setIconTextGap(25);
        BotonEl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonElActionPerformed(evt);
            }
        });
        PanelMenu.add(BotonEl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 239, 44));

        BotonSa.setBackground(new java.awt.Color(67, 141, 184));
        BotonSa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MENU/EXIT.png"))); // NOI18N
        BotonSa.setText("Salir");
        BotonSa.setColorHover(new java.awt.Color(153, 0, 0));
        BotonSa.setColorNormal(new java.awt.Color(67, 141, 184));
        BotonSa.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        BotonSa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSaActionPerformed(evt);
            }
        });
        PanelMenu.add(BotonSa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 239, 43));

        BotonIn.setBackground(new java.awt.Color(67, 141, 184));
        BotonIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MENU/INICIO.png"))); // NOI18N
        BotonIn.setText("Inicio");
        BotonIn.setColorNormal(new java.awt.Color(67, 141, 184));
        BotonIn.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        BotonIn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonIn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BotonIn.setIconTextGap(25);
        BotonIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInActionPerformed(evt);
            }
        });
        PanelMenu.add(BotonIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 89, 240, 43));

        PanelPrincipal.setBackground(new java.awt.Color(169, 195, 212));
        PanelPrincipal.setLayout(new javax.swing.BoxLayout(PanelPrincipal, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1538, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        // TODO add your handling code here:
        int posicion = this.PanelMenu.getX();
        if(posicion > -1){
            Animacion.Animacion.mover_izquierda(0,  -264, 2, 2,PanelMenu);
            
        }else{
            Animacion.Animacion.mover_derecha( -264,0,2,2,PanelMenu);
        }
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void BotonInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInActionPerformed
        // TODO add your handling code here:4
         Menu newframe= new Menu();
         newframe.setVisible(true);
         newframe.txtUsuario.setText(txtUsuarioEm.getText());
         this.dispose();
    }//GEN-LAST:event_BotonInActionPerformed

    private void BotonSaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSaActionPerformed
        // TODO add your handling code here:
        Sesion a = new Sesion(null, true);
        a.ms.setText("Menu");
        a.setVisible(true);
        if (a.r.getText().equals("si")) {
            Login newframe= new Login();
            newframe.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BotonSaActionPerformed

    private void BotonAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(PanelPrincipal, new AgregarEmpleado());
    }//GEN-LAST:event_BotonAgActionPerformed

    private void BotonBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(PanelPrincipal, new ConsultaEmpleado());
    }//GEN-LAST:event_BotonBuActionPerformed

    private void BotonMoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMoActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(PanelPrincipal, new ModificarEmpleado());
    }//GEN-LAST:event_BotonMoActionPerformed

    private void BotonElActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonElActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(PanelPrincipal, new EliminarEmpleado());
    }//GEN-LAST:event_BotonElActionPerformed

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        Sesion a = new Sesion(null, true);
        a.ms.setText("Menu");
        a.setVisible(true);
        if (a.r.getText().equals("si")) {
            Login newframe= new Login();
            newframe.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(new Color(67,141,184));
        exitTxt.setForeground(Color.WHITE);
    }//GEN-LAST:event_exitTxtMouseExited

    private void minTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseClicked
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minTxtMouseClicked

    private void minTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseEntered
        minBtn.setBackground(Color.gray);
        minTxt.setForeground(Color.white);
    }//GEN-LAST:event_minTxtMouseEntered

    private void minTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseExited
        minBtn.setBackground(new Color(67,141,184));
        minTxt.setForeground(Color.WHITE);
    }//GEN-LAST:event_minTxtMouseExited

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
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro BotonAg;
    private rsbuttom.RSButtonMetro BotonBu;
    private rsbuttom.RSButtonMetro BotonEl;
    private rsbuttom.RSButtonMetro BotonIn;
    private rsbuttom.RSButtonMetro BotonMo;
    private rsbuttom.RSButtonMetro BotonSa;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel minBtn;
    private javax.swing.JLabel minTxt;
    private rsbuttom.RSButtonMetro rSButtonMetro2;
    public javax.swing.JLabel txtUsuarioEm;
    // End of variables declaration//GEN-END:variables
}
