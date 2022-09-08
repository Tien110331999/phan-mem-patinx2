/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import database.connectDatabase;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Change extends javax.swing.JFrame {
    
    public String sttgiay="";
    public int madat=0;
    public connectDatabase conn= new connectDatabase();
    public String manv;
    public Trangchu Tc;
    /**
     * Creates new form Change
     */
    public Change() {
        initComponents();
    }
    
    public Change(Trangchu TC,String STTGIAY, int MADAT, String MANV) {
        initComponents();
        this.jdoisttgiay.requestFocus();
        Tc=TC;
        sttgiay=STTGIAY;
        madat=MADAT;
        manv = MANV;
        jsttgiay.setText(STTGIAY);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdoisttgiay = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBooking1 = new javax.swing.JButton();
        jBooking2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jsttgiay = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("THÔNG TIN ĐẶT GIÀY");

        jdoisttgiay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdoisttgiayActionPerformed(evt);
            }
        });
        jdoisttgiay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdoisttgiayKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Đổi thành");

        jBooking1.setBackground(new java.awt.Color(153, 153, 255));
        jBooking1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBooking1.setText("ĐỔI");
        jBooking1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 1, true));
        jBooking1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBooking1ActionPerformed(evt);
            }
        });

        jBooking2.setBackground(new java.awt.Color(255, 102, 102));
        jBooking2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBooking2.setText("HỦY");
        jBooking2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 1, true));
        jBooking2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBooking2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Mã Giày        :");

        jsttgiay.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(247, 247, 247))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBooking1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBooking2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdoisttgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsttgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jsttgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jdoisttgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBooking1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBooking2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBooking2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBooking2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jBooking2ActionPerformed

    private void jBooking1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBooking1ActionPerformed
        String STTGIAYDOI = jdoisttgiay.getText();
        int madatgiay=0;
        ResultSet rs = conn.ExcuteQueryGetTable("Select * from GIAY where STTGIAY='"+STTGIAYDOI+"'");
        
                try {
            while(rs.next()){
                madatgiay=rs.getInt("TINHTRANG");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(madatgiay==0){
            conn.ExcuteQueryUpdateDB("UPDATE GIAY set TINHTRANG = 0 where STTGIAY = '"+sttgiay+"';");
            conn.ExcuteQueryUpdateDB("UPDATE GIAY set TINHTRANG = "+madat+" where STTGIAY = '"+STTGIAYDOI+"';");
            conn.ExcuteQueryUpdateDB("UPDATE DAT_GIAY set STTGIAY = '"+STTGIAYDOI+"' where MADAT = "+madat+";");
            this.setVisible(false);
            Tc.setVisible(false);
            new Trangchu(manv).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane,"Giày đã được thuê, xin chọn lại giày khác.");
            jdoisttgiay.setText("");
        }
        
    }//GEN-LAST:event_jBooking1ActionPerformed

    private void jdoisttgiayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdoisttgiayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdoisttgiayActionPerformed

    private void jdoisttgiayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdoisttgiayKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            jBooking1.doClick();
        }
    }//GEN-LAST:event_jdoisttgiayKeyPressed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBooking1;
    private javax.swing.JButton jBooking2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jdoisttgiay;
    private javax.swing.JTextField jsttgiay;
    // End of variables declaration//GEN-END:variables
}
