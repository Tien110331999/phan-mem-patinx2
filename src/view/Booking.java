/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import database.connectDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author giuse
 */
public class Booking extends javax.swing.JFrame {
    
    public String manv="";
    public String sttgiay="";
    public String ngaythue="";
    public int giothue=0;
    public int phutthue=0;
    public int giotra=0;
    public int phuttra=0;
    public long tinhtien=0;
    public int madat=0;
    public long tiencoc1=0;
    public Trangchu Tc;
    
    public connectDatabase conn= new connectDatabase();
    
    public Booking() {
        initComponents();
    }
    
    public Booking(Trangchu TC,String MANV,String STTGIAY,String SODAY, int MADAT,int hour, int minute, long tiengiay, long tiencoc) {
        initComponents();
        String pattern = "###,###,###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        Tc=TC;
        manv=MANV;
        sttgiay=STTGIAY;
        jsttgiay.setText(STTGIAY);
        jtiencoc.setText(decimalFormat.format(tiencoc));
        tiencoc1=tiencoc;
        jsogiay.setText(SODAY);
        if(MADAT==0){
            jBooking1.setVisible(false);
            jBooking3.setVisible(false);
            SimpleDateFormat sdf = new  SimpleDateFormat("HH");
            SimpleDateFormat sdf1 = new  SimpleDateFormat("mm");
            SimpleDateFormat sdf2 = new  SimpleDateFormat("yyyyMMdd");
            Date now= new Date();
            String giothue1= sdf.format(now);
            String phutthue1= sdf1.format(now);
            ngaythue=sdf2.format(now);
            jgiodatgiay.setText(giothue1+":"+phutthue1);
            giothue=Integer.parseInt(giothue1);
            phutthue=Integer.parseInt(phutthue1);  
        }else{
            madat=MADAT;
            jBooking.setVisible(false);
            String gioithue2=Tc.doigio(hour,minute);
            jgiodatgiay.setText(gioithue2);
            jmadatgiay.setText(String.valueOf(madat));
            SimpleDateFormat sdf = new  SimpleDateFormat("HH");
            SimpleDateFormat sdf1 = new  SimpleDateFormat("mm");
            Date now= new Date();
            String giotra1= sdf.format(now);
            String phuttra1= sdf1.format(now);
            jgiotra.setText(giotra1+":"+phuttra1);
            giotra=Integer.parseInt(giotra1);
            phuttra=Integer.parseInt(phuttra1);
            tinhtien=tongtien(tinhgio(hour,minute,giotra,phuttra));
            jtongtien.setText(decimalFormat.format(tinhtien-tiencoc));
            
        }
        
    }


    public int tinhgio(int a,int b, int c, int d){   
        return (c-a)*60+(d-b);
    }
    
    public long tongtien(int tinhgio){
        if(tinhgio<=60){
        return tiencoc1;}else{
        return ((((tinhgio-60)/15)+1)*5000)+tiencoc1;}
    }
    
    
    




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jgiodatgiay = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jgiotra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtongtien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jmadatgiay = new javax.swing.JTextField();
        jBooking = new javax.swing.JButton();
        jBooking1 = new javax.swing.JButton();
        jBooking2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jsttgiay = new javax.swing.JTextField();
        jBooking3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtiencoc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jsogiay = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("THÔNG TIN ĐẶT GIÀY");

        jgiodatgiay.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Giờ Đặt         :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Giờ Trả          :");

        jgiotra.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Trả Thêm     :");

        jtongtien.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Mã Đặt          :");

        jmadatgiay.setEditable(false);

        jBooking.setBackground(new java.awt.Color(0, 255, 255));
        jBooking.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBooking.setText("ĐẶT");
        jBooking.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 1, true));
        jBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBookingActionPerformed(evt);
            }
        });

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

        jBooking3.setBackground(new java.awt.Color(204, 255, 204));
        jBooking3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBooking3.setText("TRẢ");
        jBooking3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 1, true));
        jBooking3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBooking3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Tiền Cọc       :");

        jtiencoc.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Số Giày        :");

        jsogiay.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBooking1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(jBooking3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBooking2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jgiodatgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsttgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmadatgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jsogiay, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jgiotra, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(247, 247, 247))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jsogiay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jsttgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jgiodatgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jgiotra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jtongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jmadatgiay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBooking1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBooking2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBooking3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Thông Tin Đặt Giày");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBooking2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBooking2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jBooking2ActionPerformed

    private void jBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBookingActionPerformed
        conn.ExcuteQueryUpdateDB("Insert into DAT_GIAY (STTGIAY,NGAYDAT,GIOTHUE,PHUTTHUE,GIOTRA,PHUTTRA,TIENTHUE,MANV) VALUES('"+sttgiay+"','"+ngaythue+"',"+giothue+","+phutthue+",0,0,0,'"+manv+"');");
        String MADAT="";
        ResultSet rs = conn.ExcuteQueryGetTable("SELECT * FROM DAT_GIAY ORDER BY MADAT DESC LIMIT 1");
                try {
            while(rs.next()){
                MADAT=rs.getString("MADAT");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.ExcuteQueryUpdateDB("UPDATE GIAY set TINHTRANG = "+MADAT+" where STTGIAY = "+sttgiay+";");
        this.setVisible(false);
        Tc.setVisible(false);
        new Trangchu(manv).setVisible(true);
    }//GEN-LAST:event_jBookingActionPerformed

    private void jBooking3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBooking3ActionPerformed
        conn.ExcuteQueryUpdateDB("UPDATE DAT_GIAY set GIOTRA = "+giotra+", PHUTTRA = "+phuttra+", TIENTHUE = "+tinhtien+", MANV1='"+manv+"' where MADAT = "+madat+";");
        conn.ExcuteQueryUpdateDB("UPDATE GIAY set TINHTRANG = 0 where STTGIAY = "+sttgiay+";");
        this.setVisible(false);
        Tc.setVisible(false);
        new Trangchu(manv).setVisible(true);
    }//GEN-LAST:event_jBooking3ActionPerformed

    private void jBooking1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBooking1ActionPerformed
        this.setVisible(false);
        new Change(Tc,sttgiay,madat,manv).setVisible(true);
    }//GEN-LAST:event_jBooking1ActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Booking().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBooking;
    private javax.swing.JButton jBooking1;
    private javax.swing.JButton jBooking2;
    private javax.swing.JButton jBooking3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jgiodatgiay;
    private javax.swing.JTextField jgiotra;
    private javax.swing.JTextField jmadatgiay;
    private javax.swing.JTextField jsogiay;
    private javax.swing.JTextField jsttgiay;
    private javax.swing.JTextField jtiencoc;
    private javax.swing.JTextField jtongtien;
    // End of variables declaration//GEN-END:variables




}
