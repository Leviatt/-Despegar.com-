/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import bussines_logic.main;
import data.Transfer;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import ui.GUI;

public class SeenHotel extends javax.swing.JFrame {

 
    public SeenHotel() {
        initComponents();
    }

    HashMap <String, String []> UserData = new HashMap <>();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        AmDays = new javax.swing.JLabel();
        AmPeople = new javax.swing.JLabel();
        AmRooms = new javax.swing.JLabel();
        AmAddress = new javax.swing.JLabel();
        AmStars = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ChulitoH = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Booking information");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(420, 320));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(493, 304));
        jPanel1.setLayout(null);

        Name.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setText("Are you sure?");
        jPanel1.add(Name);
        Name.setBounds(40, 20, 290, 30);

        jLabel1.setBackground(new java.awt.Color(255, 0, 51));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 492, 68);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Price: $");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(36, 237, 63, 45);

        Price.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jPanel1.add(Price);
        Price.setBounds(105, 237, 208, 45);

        jLabel4.setText("Amount of days:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 110, 80, 14);

        jLabel5.setText("Amount of people:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 130, 89, 14);

        jLabel6.setText("Amount of rooms:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 150, 86, 14);

        jLabel7.setText("Address:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 170, 43, 14);

        jLabel12.setText("Stars:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(40, 190, 29, 14);
        jPanel1.add(AmDays);
        AmDays.setBounds(130, 110, 90, 20);
        jPanel1.add(AmPeople);
        AmPeople.setBounds(140, 130, 100, 20);
        jPanel1.add(AmRooms);
        AmRooms.setBounds(130, 150, 90, 20);
        jPanel1.add(AmAddress);
        AmAddress.setBounds(90, 170, 90, 20);
        jPanel1.add(AmStars);
        AmStars.setBounds(80, 190, 120, 20);

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
        jButton1.setBounds(370, 250, 40, 30);

        ChulitoH.setBackground(new java.awt.Color(255, 255, 255));
        ChulitoH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/comprobado (1).png"))); // NOI18N
        ChulitoH.setBorder(null);
        ChulitoH.setBorderPainted(false);
        ChulitoH.setContentAreaFilled(false);
        ChulitoH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChulitoHActionPerformed(evt);
            }
        });
        jPanel1.add(ChulitoH);
        ChulitoH.setBounds(330, 250, 40, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        this.setLocationRelativeTo(null);
        Price.setText(GUI.PriceH+"");
        AmDays.setText(GUI.PassHotel[0]);
        AmPeople.setText(GUI.PassHotel[1]);
        AmRooms.setText(GUI.PassHotel[2]);
        AmAddress.setText(GUI.PassHotel[3]);
        AmStars.setText(GUI.PassHotel[4]);
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GUI.main(new String[1]);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ChulitoHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChulitoHActionPerformed
        // TODO add your handling code here:
        
        GUI.AuxH.put(GUI.AuxH.size(), GUI.PassHotel);
        GUI.Aux.put(0, GUI.AuxH);
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
    }//GEN-LAST:event_ChulitoHActionPerformed

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
                    if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SeenHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeenHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeenHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeenHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeenHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AmAddress;
    private javax.swing.JLabel AmDays;
    private javax.swing.JLabel AmPeople;
    private javax.swing.JLabel AmRooms;
    private javax.swing.JLabel AmStars;
    private javax.swing.JButton ChulitoH;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Price;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
