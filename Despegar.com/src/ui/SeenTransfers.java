/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import data.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class SeenTransfers extends javax.swing.JFrame {

    public SeenTransfers() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PriceT = new javax.swing.JLabel();
        ChulitoT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        aaaaa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BagT = new javax.swing.JLabel();
        PeopleT = new javax.swing.JLabel();
        DPlaceT = new javax.swing.JLabel();
        APlaceT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel49.setFont(new java.awt.Font("Gautami", 1, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("TRANSFERS");
        jPanel1.add(jLabel49);
        jLabel49.setBounds(70, 10, 380, 80);

        jLabel48.setBackground(new java.awt.Color(153, 0, 153));
        jLabel48.setOpaque(true);
        jPanel1.add(jLabel48);
        jLabel48.setBounds(0, 0, 540, 80);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Price: $");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 250, 63, 45);

        PriceT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(PriceT);
        PriceT.setBounds(100, 250, 208, 45);

        ChulitoT.setBackground(new java.awt.Color(255, 255, 255));
        ChulitoT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/comprobado (1).png"))); // NOI18N
        ChulitoT.setBorder(null);
        ChulitoT.setBorderPainted(false);
        ChulitoT.setContentAreaFilled(false);
        ChulitoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChulitoTActionPerformed(evt);
            }
        });
        jPanel1.add(ChulitoT);
        ChulitoT.setBounds(350, 260, 40, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar_1.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(390, 260, 40, 30);

        jLabel1.setText("Bag capacity:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 120, 100, 14);

        jLabel4.setText("People capacity:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 150, 100, 14);

        aaaaa.setText("Departure place:");
        jPanel1.add(aaaaa);
        aaaaa.setBounds(30, 180, 140, 14);

        jLabel6.setText("Arrival place:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 210, 120, 14);

        BagT.setText("    ");
        jPanel1.add(BagT);
        BagT.setBounds(100, 120, 80, 14);

        PeopleT.setText("      ");
        jPanel1.add(PeopleT);
        PeopleT.setBounds(150, 150, 70, 14);

        DPlaceT.setText("   ");
        jPanel1.add(DPlaceT);
        DPlaceT.setBounds(120, 180, 120, 14);

        APlaceT.setText("    ");
        jPanel1.add(APlaceT);
        APlaceT.setBounds(100, 210, 150, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        this.setLocationRelativeTo(null);
        BagT.setText(GUI.PassTransfers[0]);
        PeopleT.setText(GUI.PassTransfers[1]);
        DPlaceT.setText(GUI.PassTransfers[2]);
        APlaceT.setText(GUI.PassTransfers[3]);
        PriceT.setText(GUI.PassTransfers[4]);
        
        
    }//GEN-LAST:event_formComponentShown

    private void ChulitoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChulitoTActionPerformed
        // TODO add your handling code here:
        GUI.AuxT.put(GUI.AuxT.size(), GUI.PassTransfers);
        GUI.Aux.put(0, GUI.AuxT);
        GUI.Services.put(login.User, GUI.Aux);
        FileOutputStream fileStream = null;
        try{
            fileStream = new FileOutputStream("Service.obj");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            for(HashMap It : GUI.Services.values()){
                os.writeObject(It);
            }
            os.close();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        this.dispose();
        GUI.main(new String[1]);
    }//GEN-LAST:event_ChulitoTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        GUI.main(new String[1]);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SeenTransfers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeenTransfers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeenTransfers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeenTransfers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeenTransfers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel APlaceT;
    private javax.swing.JLabel BagT;
    private javax.swing.JButton ChulitoT;
    private javax.swing.JLabel DPlaceT;
    private javax.swing.JLabel PeopleT;
    private javax.swing.JLabel PriceT;
    private javax.swing.JLabel aaaaa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
