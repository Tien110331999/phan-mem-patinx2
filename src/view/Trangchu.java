/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
import database.connectDatabase;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.time.LocalDate;
import java.util.Locale;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author giuse
 */
public final class Trangchu extends javax.swing.JFrame {

    
        public abstract class JgiayAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt){
            JButton button= (JButton) evt.getSource();
            String STTGIAY= button.getText();
            int giothue=0;
            int phutthue=0;
            long tienthue=0;
            long tiencoc=0;
            String sogiay="";
                    int MADAT=0;
                    MADAT=Madat[tim_i(STTGIAY)];
                    ResultSet rs1 = conn.ExcuteQueryGetTable("Select * from GIAY where STTGIAY='"+STTGIAY+"'");
                    try {
                    while(rs1.next()){
                        tienthue = rs1.getInt("TIENTHUE");
                        tiencoc = rs1.getInt("TIENCOC");
                        sogiay = rs1.getString("SODAY");
                    }
                    rs1.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
                    }
            if(MADAT==0){
                
            }else{
                ResultSet rs = conn.ExcuteQueryGetTable("Select * from DAT_GIAY where MADAT='"+MADAT+"'");
                try {
                    while(rs.next()){
                        giothue = rs.getInt("GIOTHUE");
                        phutthue = rs.getInt("PHUTTHUE");
                    }
                    rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            new Booking(Trangchu.this,MANV,STTGIAY,sogiay,MADAT,giothue,phutthue,tienthue,tiencoc).setVisible(true);
            
        }
    }


//    public Order od;
    public String HOTEN_NV;
    public String MANV;
    public connectDatabase conn = new  connectDatabase ();
    public JButton Jgiay[] = new JButton[120];
    public String sttgiay[] = new String[120];
    public int Madat[] = new int[120];
    public int Tinhtrang[] = new int[120];
    public String Maloaiphong[] = new String[120];
    public int Sogiaythue;
    public int Sogiaytrong;
    public JgiayAction ActionGiay = new JgiayAction() {};
    
    public Trangchu () {
    initComponents();
        JButton giay[]={jGiay111, jGiay112, jGiay113, jGiay114, jGiay115, jGiay116, jGiay117, jGiay118,  
                        jGiay121, jGiay122, jGiay123, jGiay124, jGiay125, jGiay126, jGiay127, jGiay128,
                        jGiay131, jGiay132, jGiay133, jGiay134, jGiay135, jGiay136, jGiay137, jGiay138,
                        jGiay141, jGiay142, jGiay143, jGiay144, jGiay145, jGiay146, jGiay147, jGiay148, 
                        jGiay151, jGiay152, jGiay153, jGiay154, jGiay155, jGiay156, jGiay157, jGiay158, 
                        jGiay211, jGiay212, jGiay213, jGiay214, jGiay215, jGiay216, jGiay217, jGiay218,  
                        jGiay221, jGiay222, jGiay223, jGiay224, jGiay225, jGiay226, jGiay227, jGiay228,
                        jGiay231, jGiay232, jGiay233, jGiay234, jGiay235, jGiay236, jGiay237, jGiay238,
                        jGiay241, jGiay242, jGiay243, jGiay244, jGiay245, jGiay246, jGiay247, jGiay248, 
                        jGiay251, jGiay252, jGiay253, jGiay254, jGiay255, jGiay256, jGiay257, jGiay258, 
                        jGiay311, jGiay312, jGiay313, jGiay314, jGiay315, jGiay316, jGiay317, jGiay318,  
                        jGiay321, jGiay322, jGiay323, jGiay324, jGiay325, jGiay326, jGiay327, jGiay328,
                        jGiay331, jGiay332, jGiay333, jGiay334, jGiay335, jGiay336, jGiay337, jGiay338,
                        jGiay341, jGiay342, jGiay343, jGiay344, jGiay345, jGiay346, jGiay347, jGiay348, 
                        jGiay351, jGiay352, jGiay353, jGiay354, jGiay355, jGiay356, jGiay357, jGiay358};
        System.arraycopy(giay, 0, Jgiay, 0, 120);

        SetTinhTrangGiayDefault();
        action();
        SimpleDateFormat sdf = new  SimpleDateFormat("dd-MM-yyyy");
        Date now= new Date();
        String st= sdf.format(now);
        jLabel35.setText(st);
        initClock();
        
    }
    public Trangchu ( String MA){
        initComponents();
        MANV=MA;
        String CHUCVU= null;
        ResultSet rs = conn.ExcuteQueryGetTable("Select * from NHAN_VIEN where MANV='"+MA+"'");
        
                try {
            while(rs.next()){
                HOTEN_NV=rs.getString("HOTEN");
                CHUCVU=rs.getString("CHUCVU");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        if( !"QUANLY".equals(CHUCVU)){
            Thong_ke_2.setVisible(false);
        }else{
           Thong_ke_2.setVisible(true);
           ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from NHAN_VIEN");
           DefaultComboBoxModel box1 = new DefaultComboBoxModel();
           try {
            while (rs1.next()){
                String MALP = rs1.getString("MANV");
                box1.addElement(MALP);
            }
            box1.addElement("Tất cả");
            ComboBoxTinhtrangphong.setModel(box1);
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        LabelUser.setText(HOTEN_NV);
        JButton giay[]={jGiay111, jGiay112, jGiay113, jGiay114, jGiay115, jGiay116, jGiay117, jGiay118,  
                        jGiay121, jGiay122, jGiay123, jGiay124, jGiay125, jGiay126, jGiay127, jGiay128,
                        jGiay131, jGiay132, jGiay133, jGiay134, jGiay135, jGiay136, jGiay137, jGiay138,
                        jGiay141, jGiay142, jGiay143, jGiay144, jGiay145, jGiay146, jGiay147, jGiay148, 
                        jGiay151, jGiay152, jGiay153, jGiay154, jGiay155, jGiay156, jGiay157, jGiay158, 
                        jGiay211, jGiay212, jGiay213, jGiay214, jGiay215, jGiay216, jGiay217, jGiay218,  
                        jGiay221, jGiay222, jGiay223, jGiay224, jGiay225, jGiay226, jGiay227, jGiay228,
                        jGiay231, jGiay232, jGiay233, jGiay234, jGiay235, jGiay236, jGiay237, jGiay238,
                        jGiay241, jGiay242, jGiay243, jGiay244, jGiay245, jGiay246, jGiay247, jGiay248, 
                        jGiay251, jGiay252, jGiay253, jGiay254, jGiay255, jGiay256, jGiay257, jGiay258, 
                        jGiay311, jGiay312, jGiay313, jGiay314, jGiay315, jGiay316, jGiay317, jGiay318,  
                        jGiay321, jGiay322, jGiay323, jGiay324, jGiay325, jGiay326, jGiay327, jGiay328,
                        jGiay331, jGiay332, jGiay333, jGiay334, jGiay335, jGiay336, jGiay337, jGiay338,
                        jGiay341, jGiay342, jGiay343, jGiay344, jGiay345, jGiay346, jGiay347, jGiay348, 
                        jGiay351, jGiay352, jGiay353, jGiay354, jGiay355, jGiay356, jGiay357, jGiay358};
        System.arraycopy(giay, 0, Jgiay, 0, 120);

        SetTinhTrangGiayDefault();
        action();
        SimpleDateFormat sdf = new  SimpleDateFormat("dd-MM-yyyy");
        Date now= new Date();
        String st= sdf.format(now);
        jLabel35.setText(st);
        initClock();
        jnhap.setMnemonic(KeyEvent.VK_ENTER);
    }
    
    private void initClock(){
        Clock th = new Clock(jLabel36);
        th.start();
    }
    
    public void action(){
        for(int i=0; i<120;i++){
            if (Tinhtrang[i]==-1){
                
            }else{
                Jgiay[i].addActionListener(ActionGiay);
               } 
        }
    }
    
    
    

    
    public void SetTinhTrangGiayDefault(){
        Arrays.fill(Tinhtrang,0);
        Arrays.fill(Madat,0);
        int GIAYTHUE=0;
        int GIAYTRONG=0;
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int i=0;
        ResultSet rs = conn.ExcuteQueryGetTable("Select * from GIAY");
        try {
            while(rs.next()){
                int TINHTRANG = rs.getInt("TINHTRANG");
                sttgiay[i]=rs.getString("STTGIAY");
                Tinhtrang[i]=TINHTRANG;
                if(TINHTRANG==0){
                    doitrong(i);
                    GIAYTRONG=GIAYTRONG+1;
                }else{
                    doithue(i);
                    GIAYTHUE=GIAYTHUE+1;
                    Madat[i]=TINHTRANG;
                }
                i++;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Sogiaythue=GIAYTHUE;
        Sogiaytrong=GIAYTRONG;
        Giaythue.setText(String.valueOf(Sogiaythue));
        Giaytrong.setText(String.valueOf(Sogiaytrong));
    }
    
    public String doigio(int a,int b){
        if(a>=0&&a<10){
            if(b>=0&&b<10){
                return "0"+a+":0"+b;
            }else{
                return "0"+a+":"+b;
            }
            }else{
            if(b>=0&&b<10){
                return a+":0"+b;
            }else{
                return a+":"+b;
            }
            }
    
    }
    
    public void doitrong(int i){
        Jgiay[i].setOpaque(true);
        Jgiay[i].setBorderPainted(false);
        Jgiay[i].setBackground(new Color(0,204,102));
    }
    
    public void doithue(int i){
        Jgiay[i].setOpaque(true);
        Jgiay[i].setBorderPainted(false);
        Jgiay[i].setBackground(new Color(255,0,0)); 
    }
    
    public int tim_i(String STTGIAY){
        for (int i=0;i<120;i++)
            {
                if(sttgiay[i].equals(STTGIAY)){
                    return i;
                }
            }
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel33 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        LabelUser = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        Giaythue = new javax.swing.JTextField();
        Giaytrong = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jnhap = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        QL_giay = new javax.swing.JPanel();
        jGiay151 = new javax.swing.JButton();
        jGiay152 = new javax.swing.JButton();
        jGiay153 = new javax.swing.JButton();
        jGiay154 = new javax.swing.JButton();
        jGiay155 = new javax.swing.JButton();
        jGiay156 = new javax.swing.JButton();
        jGiay157 = new javax.swing.JButton();
        jGiay158 = new javax.swing.JButton();
        jGiay141 = new javax.swing.JButton();
        jGiay142 = new javax.swing.JButton();
        jGiay143 = new javax.swing.JButton();
        jGiay144 = new javax.swing.JButton();
        jGiay145 = new javax.swing.JButton();
        jGiay146 = new javax.swing.JButton();
        jGiay147 = new javax.swing.JButton();
        jGiay148 = new javax.swing.JButton();
        jGiay131 = new javax.swing.JButton();
        jGiay132 = new javax.swing.JButton();
        jGiay133 = new javax.swing.JButton();
        jGiay134 = new javax.swing.JButton();
        jGiay135 = new javax.swing.JButton();
        jGiay136 = new javax.swing.JButton();
        jGiay137 = new javax.swing.JButton();
        jGiay138 = new javax.swing.JButton();
        jGiay121 = new javax.swing.JButton();
        jGiay122 = new javax.swing.JButton();
        jGiay123 = new javax.swing.JButton();
        jGiay124 = new javax.swing.JButton();
        jGiay125 = new javax.swing.JButton();
        jGiay126 = new javax.swing.JButton();
        jGiay127 = new javax.swing.JButton();
        jGiay128 = new javax.swing.JButton();
        jGiay111 = new javax.swing.JButton();
        jGiay112 = new javax.swing.JButton();
        jGiay113 = new javax.swing.JButton();
        jGiay114 = new javax.swing.JButton();
        jGiay115 = new javax.swing.JButton();
        jGiay116 = new javax.swing.JButton();
        jGiay117 = new javax.swing.JButton();
        jGiay118 = new javax.swing.JButton();
        jGiay251 = new javax.swing.JButton();
        jGiay252 = new javax.swing.JButton();
        jGiay253 = new javax.swing.JButton();
        jGiay254 = new javax.swing.JButton();
        jGiay255 = new javax.swing.JButton();
        jGiay256 = new javax.swing.JButton();
        jGiay257 = new javax.swing.JButton();
        jGiay258 = new javax.swing.JButton();
        jGiay241 = new javax.swing.JButton();
        jGiay231 = new javax.swing.JButton();
        jGiay221 = new javax.swing.JButton();
        jGiay211 = new javax.swing.JButton();
        jGiay212 = new javax.swing.JButton();
        jGiay222 = new javax.swing.JButton();
        jGiay232 = new javax.swing.JButton();
        jGiay242 = new javax.swing.JButton();
        jGiay213 = new javax.swing.JButton();
        jGiay223 = new javax.swing.JButton();
        jGiay233 = new javax.swing.JButton();
        jGiay243 = new javax.swing.JButton();
        jGiay214 = new javax.swing.JButton();
        jGiay224 = new javax.swing.JButton();
        jGiay234 = new javax.swing.JButton();
        jGiay244 = new javax.swing.JButton();
        jGiay215 = new javax.swing.JButton();
        jGiay225 = new javax.swing.JButton();
        jGiay235 = new javax.swing.JButton();
        jGiay245 = new javax.swing.JButton();
        jGiay216 = new javax.swing.JButton();
        jGiay226 = new javax.swing.JButton();
        jGiay236 = new javax.swing.JButton();
        jGiay246 = new javax.swing.JButton();
        jGiay217 = new javax.swing.JButton();
        jGiay227 = new javax.swing.JButton();
        jGiay237 = new javax.swing.JButton();
        jGiay247 = new javax.swing.JButton();
        jGiay218 = new javax.swing.JButton();
        jGiay228 = new javax.swing.JButton();
        jGiay238 = new javax.swing.JButton();
        jGiay248 = new javax.swing.JButton();
        jGiay351 = new javax.swing.JButton();
        jGiay341 = new javax.swing.JButton();
        jGiay331 = new javax.swing.JButton();
        jGiay321 = new javax.swing.JButton();
        jGiay311 = new javax.swing.JButton();
        jGiay312 = new javax.swing.JButton();
        jGiay322 = new javax.swing.JButton();
        jGiay332 = new javax.swing.JButton();
        jGiay342 = new javax.swing.JButton();
        jGiay352 = new javax.swing.JButton();
        jGiay353 = new javax.swing.JButton();
        jGiay343 = new javax.swing.JButton();
        jGiay333 = new javax.swing.JButton();
        jGiay323 = new javax.swing.JButton();
        jGiay313 = new javax.swing.JButton();
        jGiay354 = new javax.swing.JButton();
        jGiay344 = new javax.swing.JButton();
        jGiay334 = new javax.swing.JButton();
        jGiay324 = new javax.swing.JButton();
        jGiay314 = new javax.swing.JButton();
        jGiay355 = new javax.swing.JButton();
        jGiay345 = new javax.swing.JButton();
        jGiay335 = new javax.swing.JButton();
        jGiay325 = new javax.swing.JButton();
        jGiay315 = new javax.swing.JButton();
        jGiay356 = new javax.swing.JButton();
        jGiay346 = new javax.swing.JButton();
        jGiay336 = new javax.swing.JButton();
        jGiay326 = new javax.swing.JButton();
        jGiay316 = new javax.swing.JButton();
        jGiay357 = new javax.swing.JButton();
        jGiay347 = new javax.swing.JButton();
        jGiay337 = new javax.swing.JButton();
        jGiay327 = new javax.swing.JButton();
        jGiay317 = new javax.swing.JButton();
        jGiay358 = new javax.swing.JButton();
        jGiay348 = new javax.swing.JButton();
        jGiay338 = new javax.swing.JButton();
        jGiay328 = new javax.swing.JButton();
        jGiay318 = new javax.swing.JButton();
        Thong_ke_1 = new javax.swing.JPanel();
        Thong_ke_2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabletracuu = new javax.swing.JTable();
        ComboBoxTinhtrangphong = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtongtientracuu = new javax.swing.JTextField();
        jtungay = new com.toedter.calendar.JDateChooser();
        jdenngay = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jTennhanvien = new javax.swing.JTextField();
        Logout = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        Okelogout = new javax.swing.JButton();
        jButton101 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel33.setBackground(new java.awt.Color(153, 153, 153));
        jPanel33.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel33KeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Ngày    :");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setText("Giờ       :");

        LabelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.png"))); // NOI18N
        LabelUser.setText("Hi: Admin");
        LabelUser.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                LabelUserAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel48.setBackground(new java.awt.Color(204, 204, 204));
        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giày", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel72.setBackground(new java.awt.Color(102, 204, 0));
        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel72.setText("Còn trống:");
        jLabel72.setOpaque(true);

        jLabel73.setBackground(new java.awt.Color(255, 0, 0));
        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel73.setText("Đang thuê:");
        jLabel73.setOpaque(true);

        Giaythue.setEditable(false);
        Giaythue.setText("0");

        Giaytrong.setEditable(false);
        Giaytrong.setText("0");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel73)
                .addGap(18, 18, 18)
                .addComponent(Giaythue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(jLabel72)
                .addGap(31, 31, 31)
                .addComponent(Giaytrong, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(Giaythue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Giaytrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText(" 12 -06-2019");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("09:00");

        jnhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jnhap.setText("Nhập");
        jnhap.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 1, true));
        jnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelUser)
                            .addComponent(jnhap)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane1KeyPressed(evt);
            }
        });

        jGiay151.setBackground(new java.awt.Color(204, 255, 255));
        jGiay151.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay151.setText("151");
        jGiay151.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay152.setBackground(new java.awt.Color(204, 255, 255));
        jGiay152.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay152.setText("152");
        jGiay152.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay153.setBackground(new java.awt.Color(204, 255, 255));
        jGiay153.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay153.setText("153");
        jGiay153.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay154.setBackground(new java.awt.Color(204, 255, 255));
        jGiay154.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay154.setText("154");
        jGiay154.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay155.setBackground(new java.awt.Color(204, 255, 255));
        jGiay155.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay155.setText("155");
        jGiay155.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay156.setBackground(new java.awt.Color(204, 255, 255));
        jGiay156.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay156.setText("156");
        jGiay156.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay157.setBackground(new java.awt.Color(204, 255, 255));
        jGiay157.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay157.setText("157");
        jGiay157.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay158.setBackground(new java.awt.Color(204, 255, 255));
        jGiay158.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay158.setText("158");
        jGiay158.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay141.setBackground(new java.awt.Color(204, 255, 255));
        jGiay141.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay141.setText("141");
        jGiay141.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay142.setBackground(new java.awt.Color(204, 255, 255));
        jGiay142.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay142.setText("142");
        jGiay142.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay143.setBackground(new java.awt.Color(204, 255, 255));
        jGiay143.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay143.setText("143");
        jGiay143.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay144.setBackground(new java.awt.Color(204, 255, 255));
        jGiay144.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay144.setText("144");
        jGiay144.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay145.setBackground(new java.awt.Color(204, 255, 255));
        jGiay145.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay145.setText("145");
        jGiay145.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay146.setBackground(new java.awt.Color(204, 255, 255));
        jGiay146.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay146.setText("146");
        jGiay146.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay147.setBackground(new java.awt.Color(204, 255, 255));
        jGiay147.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay147.setText("147");
        jGiay147.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay148.setBackground(new java.awt.Color(204, 255, 255));
        jGiay148.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay148.setText("148");
        jGiay148.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay131.setBackground(new java.awt.Color(204, 255, 255));
        jGiay131.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay131.setText("131");
        jGiay131.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay132.setBackground(new java.awt.Color(204, 255, 255));
        jGiay132.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay132.setText("132");
        jGiay132.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay133.setBackground(new java.awt.Color(204, 255, 255));
        jGiay133.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay133.setText("133");
        jGiay133.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay134.setBackground(new java.awt.Color(204, 255, 255));
        jGiay134.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay134.setText("134");
        jGiay134.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay135.setBackground(new java.awt.Color(204, 255, 255));
        jGiay135.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay135.setText("135");
        jGiay135.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay136.setBackground(new java.awt.Color(204, 255, 255));
        jGiay136.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay136.setText("136");
        jGiay136.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay137.setBackground(new java.awt.Color(204, 255, 255));
        jGiay137.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay137.setText("137");
        jGiay137.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay138.setBackground(new java.awt.Color(204, 255, 255));
        jGiay138.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay138.setText("138");
        jGiay138.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay121.setBackground(new java.awt.Color(204, 255, 255));
        jGiay121.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay121.setText("121");
        jGiay121.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay122.setBackground(new java.awt.Color(204, 255, 255));
        jGiay122.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay122.setText("122");
        jGiay122.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay123.setBackground(new java.awt.Color(204, 255, 255));
        jGiay123.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay123.setText("123");
        jGiay123.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay124.setBackground(new java.awt.Color(204, 255, 255));
        jGiay124.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay124.setText("124");
        jGiay124.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay125.setBackground(new java.awt.Color(204, 255, 255));
        jGiay125.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay125.setText("125");
        jGiay125.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay126.setBackground(new java.awt.Color(204, 255, 255));
        jGiay126.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay126.setText("126");
        jGiay126.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay127.setBackground(new java.awt.Color(204, 255, 255));
        jGiay127.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay127.setText("127");
        jGiay127.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay128.setBackground(new java.awt.Color(204, 255, 255));
        jGiay128.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay128.setText("128");
        jGiay128.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay111.setBackground(new java.awt.Color(204, 255, 255));
        jGiay111.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay111.setText("111");
        jGiay111.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay112.setBackground(new java.awt.Color(204, 255, 255));
        jGiay112.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay112.setText("112");
        jGiay112.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay113.setBackground(new java.awt.Color(204, 255, 255));
        jGiay113.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay113.setText("113");
        jGiay113.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay114.setBackground(new java.awt.Color(204, 255, 255));
        jGiay114.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay114.setText("114");
        jGiay114.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay115.setBackground(new java.awt.Color(204, 255, 255));
        jGiay115.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay115.setText("115");
        jGiay115.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay116.setBackground(new java.awt.Color(204, 255, 255));
        jGiay116.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay116.setText("116");
        jGiay116.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay117.setBackground(new java.awt.Color(204, 255, 255));
        jGiay117.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay117.setText("117");
        jGiay117.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay118.setBackground(new java.awt.Color(204, 255, 255));
        jGiay118.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay118.setText("118");
        jGiay118.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay251.setBackground(new java.awt.Color(204, 255, 255));
        jGiay251.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay251.setText("251");
        jGiay251.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay252.setBackground(new java.awt.Color(204, 255, 255));
        jGiay252.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay252.setText("252");
        jGiay252.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay253.setBackground(new java.awt.Color(204, 255, 255));
        jGiay253.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay253.setText("253");
        jGiay253.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay254.setBackground(new java.awt.Color(204, 255, 255));
        jGiay254.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay254.setText("254");
        jGiay254.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay255.setBackground(new java.awt.Color(204, 255, 255));
        jGiay255.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay255.setText("255");
        jGiay255.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay256.setBackground(new java.awt.Color(204, 255, 255));
        jGiay256.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay256.setText("256");
        jGiay256.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay257.setBackground(new java.awt.Color(204, 255, 255));
        jGiay257.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay257.setText("257");
        jGiay257.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay258.setBackground(new java.awt.Color(204, 255, 255));
        jGiay258.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay258.setText("258");
        jGiay258.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay241.setBackground(new java.awt.Color(204, 255, 255));
        jGiay241.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay241.setText("241");
        jGiay241.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay231.setBackground(new java.awt.Color(204, 255, 255));
        jGiay231.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay231.setText("231");
        jGiay231.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay221.setBackground(new java.awt.Color(204, 255, 255));
        jGiay221.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay221.setText("221");
        jGiay221.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay211.setBackground(new java.awt.Color(204, 255, 255));
        jGiay211.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay211.setText("211");
        jGiay211.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay212.setBackground(new java.awt.Color(204, 255, 255));
        jGiay212.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay212.setText("212");
        jGiay212.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay222.setBackground(new java.awt.Color(204, 255, 255));
        jGiay222.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay222.setText("222");
        jGiay222.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay232.setBackground(new java.awt.Color(204, 255, 255));
        jGiay232.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay232.setText("232");
        jGiay232.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay242.setBackground(new java.awt.Color(204, 255, 255));
        jGiay242.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay242.setText("242");
        jGiay242.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay213.setBackground(new java.awt.Color(204, 255, 255));
        jGiay213.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay213.setText("213");
        jGiay213.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay223.setBackground(new java.awt.Color(204, 255, 255));
        jGiay223.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay223.setText("223");
        jGiay223.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay233.setBackground(new java.awt.Color(204, 255, 255));
        jGiay233.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay233.setText("233");
        jGiay233.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay243.setBackground(new java.awt.Color(204, 255, 255));
        jGiay243.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay243.setText("243");
        jGiay243.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay214.setBackground(new java.awt.Color(204, 255, 255));
        jGiay214.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay214.setText("214");
        jGiay214.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay224.setBackground(new java.awt.Color(204, 255, 255));
        jGiay224.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay224.setText("224");
        jGiay224.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay234.setBackground(new java.awt.Color(204, 255, 255));
        jGiay234.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay234.setText("234");
        jGiay234.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay244.setBackground(new java.awt.Color(204, 255, 255));
        jGiay244.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay244.setText("244");
        jGiay244.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay215.setBackground(new java.awt.Color(204, 255, 255));
        jGiay215.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay215.setText("215");
        jGiay215.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay225.setBackground(new java.awt.Color(204, 255, 255));
        jGiay225.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay225.setText("225");
        jGiay225.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay235.setBackground(new java.awt.Color(204, 255, 255));
        jGiay235.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay235.setText("235");
        jGiay235.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay245.setBackground(new java.awt.Color(204, 255, 255));
        jGiay245.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay245.setText("245");
        jGiay245.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay216.setBackground(new java.awt.Color(204, 255, 255));
        jGiay216.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay216.setText("216");
        jGiay216.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay226.setBackground(new java.awt.Color(204, 255, 255));
        jGiay226.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay226.setText("226");
        jGiay226.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay236.setBackground(new java.awt.Color(204, 255, 255));
        jGiay236.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay236.setText("236");
        jGiay236.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay246.setBackground(new java.awt.Color(204, 255, 255));
        jGiay246.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay246.setText("246");
        jGiay246.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay217.setBackground(new java.awt.Color(204, 255, 255));
        jGiay217.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay217.setText("217");
        jGiay217.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay227.setBackground(new java.awt.Color(204, 255, 255));
        jGiay227.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay227.setText("227");
        jGiay227.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay237.setBackground(new java.awt.Color(204, 255, 255));
        jGiay237.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay237.setText("237");
        jGiay237.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay247.setBackground(new java.awt.Color(204, 255, 255));
        jGiay247.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay247.setText("247");
        jGiay247.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay218.setBackground(new java.awt.Color(204, 255, 255));
        jGiay218.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay218.setText("218");
        jGiay218.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay228.setBackground(new java.awt.Color(204, 255, 255));
        jGiay228.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay228.setText("228");
        jGiay228.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay238.setBackground(new java.awt.Color(204, 255, 255));
        jGiay238.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay238.setText("238");
        jGiay238.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay248.setBackground(new java.awt.Color(204, 255, 255));
        jGiay248.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay248.setText("248");
        jGiay248.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay351.setBackground(new java.awt.Color(204, 255, 255));
        jGiay351.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay351.setText("351");
        jGiay351.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay341.setBackground(new java.awt.Color(204, 255, 255));
        jGiay341.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay341.setText("341");
        jGiay341.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay331.setBackground(new java.awt.Color(204, 255, 255));
        jGiay331.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay331.setText("331");
        jGiay331.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay321.setBackground(new java.awt.Color(204, 255, 255));
        jGiay321.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay321.setText("321");
        jGiay321.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay311.setBackground(new java.awt.Color(204, 255, 255));
        jGiay311.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay311.setText("311");
        jGiay311.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay312.setBackground(new java.awt.Color(204, 255, 255));
        jGiay312.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay312.setText("312");
        jGiay312.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay322.setBackground(new java.awt.Color(204, 255, 255));
        jGiay322.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay322.setText("322");
        jGiay322.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay332.setBackground(new java.awt.Color(204, 255, 255));
        jGiay332.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay332.setText("332");
        jGiay332.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay342.setBackground(new java.awt.Color(204, 255, 255));
        jGiay342.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay342.setText("342");
        jGiay342.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay352.setBackground(new java.awt.Color(204, 255, 255));
        jGiay352.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay352.setText("352");
        jGiay352.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay353.setBackground(new java.awt.Color(204, 255, 255));
        jGiay353.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay353.setText("353");
        jGiay353.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay343.setBackground(new java.awt.Color(204, 255, 255));
        jGiay343.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay343.setText("343");
        jGiay343.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay333.setBackground(new java.awt.Color(204, 255, 255));
        jGiay333.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay333.setText("333");
        jGiay333.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay323.setBackground(new java.awt.Color(204, 255, 255));
        jGiay323.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay323.setText("323");
        jGiay323.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay313.setBackground(new java.awt.Color(204, 255, 255));
        jGiay313.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay313.setText("313");
        jGiay313.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay354.setBackground(new java.awt.Color(204, 255, 255));
        jGiay354.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay354.setText("354");
        jGiay354.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay344.setBackground(new java.awt.Color(204, 255, 255));
        jGiay344.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay344.setText("344");
        jGiay344.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay334.setBackground(new java.awt.Color(204, 255, 255));
        jGiay334.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay334.setText("334");
        jGiay334.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay324.setBackground(new java.awt.Color(204, 255, 255));
        jGiay324.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay324.setText("324");
        jGiay324.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay314.setBackground(new java.awt.Color(204, 255, 255));
        jGiay314.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay314.setText("314");
        jGiay314.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay355.setBackground(new java.awt.Color(204, 255, 255));
        jGiay355.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay355.setText("355");
        jGiay355.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay345.setBackground(new java.awt.Color(204, 255, 255));
        jGiay345.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay345.setText("345");
        jGiay345.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay335.setBackground(new java.awt.Color(204, 255, 255));
        jGiay335.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay335.setText("335");
        jGiay335.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay325.setBackground(new java.awt.Color(204, 255, 255));
        jGiay325.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay325.setText("325");
        jGiay325.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay315.setBackground(new java.awt.Color(204, 255, 255));
        jGiay315.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay315.setText("315");
        jGiay315.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay356.setBackground(new java.awt.Color(204, 255, 255));
        jGiay356.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay356.setText("356");
        jGiay356.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay346.setBackground(new java.awt.Color(204, 255, 255));
        jGiay346.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay346.setText("346");
        jGiay346.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay336.setBackground(new java.awt.Color(204, 255, 255));
        jGiay336.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay336.setText("336");
        jGiay336.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay326.setBackground(new java.awt.Color(204, 255, 255));
        jGiay326.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay326.setText("326");
        jGiay326.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay316.setBackground(new java.awt.Color(204, 255, 255));
        jGiay316.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay316.setText("316");
        jGiay316.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay357.setBackground(new java.awt.Color(204, 255, 255));
        jGiay357.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay357.setText("357");
        jGiay357.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay347.setBackground(new java.awt.Color(204, 255, 255));
        jGiay347.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay347.setText("347");
        jGiay347.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay337.setBackground(new java.awt.Color(204, 255, 255));
        jGiay337.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay337.setText("337");
        jGiay337.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay327.setBackground(new java.awt.Color(204, 255, 255));
        jGiay327.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay327.setText("327");
        jGiay327.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay317.setBackground(new java.awt.Color(204, 255, 255));
        jGiay317.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay317.setText("317");
        jGiay317.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay358.setBackground(new java.awt.Color(204, 255, 255));
        jGiay358.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay358.setText("358");
        jGiay358.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay348.setBackground(new java.awt.Color(204, 255, 255));
        jGiay348.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay348.setText("348");
        jGiay348.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay338.setBackground(new java.awt.Color(204, 255, 255));
        jGiay338.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay338.setText("338");
        jGiay338.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay328.setBackground(new java.awt.Color(204, 255, 255));
        jGiay328.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay328.setText("328");
        jGiay328.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        jGiay318.setBackground(new java.awt.Color(204, 255, 255));
        jGiay318.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jGiay318.setText("318");
        jGiay318.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 1, true));

        javax.swing.GroupLayout QL_giayLayout = new javax.swing.GroupLayout(QL_giay);
        QL_giay.setLayout(QL_giayLayout);
        QL_giayLayout.setHorizontalGroup(
            QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_giayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGiay351, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay341, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay331, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay321, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay311, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGiay352, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay342, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay332, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay322, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay312, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGiay353, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay343, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay333, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay323, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay313, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGiay354, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay344, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay334, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay324, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay314, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGiay355, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay345, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay335, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay325, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay315, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGiay356, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay346, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay336, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay326, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay316, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGiay357, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay347, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay337, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay327, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay317, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGiay358, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay348, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay338, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay328, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay318, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addComponent(jGiay111, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay112, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay113, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jGiay256, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay246, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay236, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay226, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay216, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay114, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jGiay255, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay245, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay235, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay225, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay215, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(QL_giayLayout.createSequentialGroup()
                                    .addComponent(jGiay131, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jGiay132, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jGiay133, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(jGiay134, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(QL_giayLayout.createSequentialGroup()
                                    .addComponent(jGiay141, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jGiay142, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jGiay143, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jGiay144, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addComponent(jGiay151, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay152, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay153, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay154, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addComponent(jGiay121, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay122, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay123, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay124, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addComponent(jGiay155, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay156, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay157, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay158, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay115, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jGiay254, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay244, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay234, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay224, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay214, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay116, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jGiay253, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay243, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay233, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay223, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay213, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay117, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jGiay252, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay242, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay232, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay222, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay212, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay118, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jGiay251, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay241, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay231, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay221, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGiay211, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addComponent(jGiay125, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay126, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay127, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGiay128, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay135, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jGiay145, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay136, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jGiay146, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay137, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jGiay147, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay138, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jGiay148, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jGiay248, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jGiay238, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jGiay228, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jGiay218, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jGiay258, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jGiay217, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay227, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGiay257, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jGiay247, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jGiay237, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        QL_giayLayout.setVerticalGroup(
            QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_giayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGiay151, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay152, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay153, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay154, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay155, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay156, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay157, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay158, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGiay141, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay142, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay143, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay144, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay145, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay146, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay147, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay148, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGiay131, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay132, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay134, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay133, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay135, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay136, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay138, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay137, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGiay121, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay122, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay123, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay124, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay125, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay126, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay127, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGiay128, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGiay111, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGiay112, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addComponent(jGiay258, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGiay248, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jGiay238, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jGiay237, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jGiay228, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jGiay227, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jGiay218, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jGiay217, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addComponent(jGiay257, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGiay247, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay113, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jGiay246, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGiay236, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGiay226, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGiay216, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jGiay256, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay114, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QL_giayLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jGiay245, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGiay235, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGiay225, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGiay215, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jGiay255, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay115, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jGiay254, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay244, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay234, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay224, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay214, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay116, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jGiay253, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay243, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay233, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay223, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay213, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay117, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jGiay252, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay242, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay232, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay222, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay212, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay118, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jGiay251, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay241, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay231, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay221, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay211, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(QL_giayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay351, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay341, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay331, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay321, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGiay311, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay352, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay342, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay332, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay322, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGiay312, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay353, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay343, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay333, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay323, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGiay313, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay354, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay344, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay334, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay324, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGiay314, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay355, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay345, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay335, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay325, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGiay315, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay356, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay346, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay336, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay326, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGiay316, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay357, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jGiay347, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay337, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay327, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGiay317, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QL_giayLayout.createSequentialGroup()
                        .addComponent(jGiay358, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay348, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay338, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGiay328, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jGiay318, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Quản lý giày       ", new javax.swing.ImageIcon(getClass().getResource("/images/home.png")), QL_giay); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("THỐNG KÊ DOANH THU");

        Tabletracuu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tabletracuu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ngày Thuê", "Giờ Thuê", "Giờ Trả", "Giày", "Tiền Thuê", "P_R", "P_P"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabletracuu);
        if (Tabletracuu.getColumnModel().getColumnCount() > 0) {
            Tabletracuu.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tabletracuu.getColumnModel().getColumn(5).setPreferredWidth(150);
            Tabletracuu.getColumnModel().getColumn(6).setPreferredWidth(30);
            Tabletracuu.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        ComboBoxTinhtrangphong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ComboBoxTinhtrangphong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn trống", "Đã cọc", "Đang thuê" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Nhân Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Từ Ngày   : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Đến Ngày   :");

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("TRA CỨU");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Tổng Cộng          :");

        jtongtientracuu.setEditable(false);
        jtongtientracuu.setBackground(new java.awt.Color(255, 255, 255));
        jtongtientracuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtongtientracuu.setForeground(new java.awt.Color(153, 0, 0));

        jtungay.setDateFormatString("dd/MM/yyyy");

        jdenngay.setDateFormatString("dd/MM/yyyy");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nhân Viên : ");

        jTennhanvien.setEditable(false);
        jTennhanvien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout Thong_ke_2Layout = new javax.swing.GroupLayout(Thong_ke_2);
        Thong_ke_2.setLayout(Thong_ke_2Layout);
        Thong_ke_2Layout.setHorizontalGroup(
            Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Thong_ke_2Layout.createSequentialGroup()
                .addGroup(Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Thong_ke_2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Thong_ke_2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtongtientracuu, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(Thong_ke_2Layout.createSequentialGroup()
                        .addGroup(Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Thong_ke_2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Thong_ke_2Layout.createSequentialGroup()
                                        .addGap(301, 301, 301)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Thong_ke_2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTennhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(Thong_ke_2Layout.createSequentialGroup()
                                                .addComponent(jtungay, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jdenngay, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel10)
                                                .addGap(36, 36, 36)
                                                .addComponent(ComboBoxTinhtrangphong, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(145, 145, 145)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(Thong_ke_2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Thong_ke_2Layout.setVerticalGroup(
            Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Thong_ke_2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ComboBoxTinhtrangphong)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdenngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Thong_ke_2Layout.createSequentialGroup()
                        .addGroup(Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15)
                .addGroup(Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Thong_ke_2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(Thong_ke_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtongtientracuu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTennhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout Thong_ke_1Layout = new javax.swing.GroupLayout(Thong_ke_1);
        Thong_ke_1.setLayout(Thong_ke_1Layout);
        Thong_ke_1Layout.setHorizontalGroup(
            Thong_ke_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Thong_ke_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Thong_ke_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Thong_ke_1Layout.setVerticalGroup(
            Thong_ke_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Thong_ke_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Thong_ke_2, javax.swing.GroupLayout.PREFERRED_SIZE, 623, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thống kê doanh thu", new javax.swing.ImageIcon(getClass().getResource("/images/invoice.png")), Thong_ke_1); // NOI18N

        jPanel42.setBackground(new java.awt.Color(204, 204, 204));
        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOGOUT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        Okelogout.setText("OK");
        Okelogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkelogoutActionPerformed(evt);
            }
        });

        jButton101.setText("Cance");

        jLabel41.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Bạn muốn đăng xuất khỏi phần mềm ?");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(Okelogout, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Okelogout)
                    .addComponent(jButton101))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout LogoutLayout = new javax.swing.GroupLayout(Logout);
        Logout.setLayout(LogoutLayout);
        LogoutLayout.setHorizontalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(386, Short.MAX_VALUE))
        );
        LogoutLayout.setVerticalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Logout                      ", new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")), Logout); // NOI18N

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("NSimSun", 3, 14)); // NOI18N
        jLabel58.setText("PATINX2");

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/patin-ICON.png"))); // NOI18N
        jLabel60.setToolTipText("");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel58)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LabelUserAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_LabelUserAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelUserAncestorAdded

    private void OkelogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkelogoutActionPerformed
        
        this.setVisible(false);
        new Login().setVisible(true); 
        // TODO add your handling code here:
    }//GEN-LAST:event_OkelogoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String pattern = "###,###,###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        SimpleDateFormat sdf4 = new  SimpleDateFormat("yyyy-MM-dd");
        DefaultTableModel table1 = (DefaultTableModel) Tabletracuu.getModel();
        table1.setRowCount(0);
        jTennhanvien.setText("");
        Date tungay = jtungay.getDate();
        Date denngay = jdenngay.getDate();
        String stungay = sdf4.format(tungay);
        String sdenngay = sdf4.format(denngay);
        long tongtien=0;
        long sum1=0;
        long sum2=0;
        long sumtong=0;
        String manvchon = ComboBoxTinhtrangphong.getSelectedItem().toString();
        if(manvchon.equals("Tất cả")){
        ResultSet rs4 = conn.ExcuteQueryGetTable("Select  *  from DAT_GIAY  where NGAYDAT >='"+stungay+"' and NGAYDAT <= '"+sdenngay+"';");
        ResultSet rs5 = conn.ExcuteQueryGetTable("Select  SUM(TIENTHUE) TONGTIEN from DAT_GIAY where NGAYDAT >='"+stungay+"' and NGAYDAT <= '"+sdenngay+"';");
        int row=1;
           try {
            while (rs4.next()){
                String giothue=doigio(rs4.getInt("GIOTHUE"),rs4.getInt("PHUTTHUE"));
                String giotra=doigio(rs4.getInt("GIOTRA"),rs4.getInt("PHUTTRA"));
                String P_R=rs4.getString("MANV");
                String P_P=rs4.getString("MANV1");
                table1.addRow(new Object[]{row, rs4.getDate("NGAYDAT"),giothue,giotra,
                                            rs4.getString("STTGIAY"),decimalFormat.format(rs4.getInt("TIENTHUE")),P_R,P_P});
                row=row+1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs5.next()){
                jtongtientracuu.setText(decimalFormat.format(rs5.getInt("TONGTIEN")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }else{
            ResultSet rs3 = conn.ExcuteQueryGetTable("Select * from NHAN_VIEN where MANV='"+manvchon+"';");
        
                try {
                while(rs3.next()){
                jTennhanvien.setText(rs3.getString("HOTEN"));
                }
            rs3.close();
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs4 = conn.ExcuteQueryGetTable("Select  *  from DAT_GIAY  where ( MANV = '"+manvchon+"' OR MANV1 = '"+manvchon+"' ) and NGAYDAT >='"+stungay+"' and NGAYDAT <= '"+sdenngay+"';");
        ResultSet rs5 = conn.ExcuteQueryGetTable("Select  SUM(TIENCOC) SUM1 from DAT_GIAY, GIAY where GIAY.STTGIAY = DAT_GIAY.STTGIAY and MANV = '"+manvchon+"'  and NGAYDAT >='"+stungay+"' and NGAYDAT <= '"+sdenngay+"';");
        ResultSet rs6 = conn.ExcuteQueryGetTable("Select  SUM(TIENCOC) SUM2 from DAT_GIAY, GIAY where GIAY.STTGIAY = DAT_GIAY.STTGIAY and MANV1 = '"+manvchon+"'  and NGAYDAT >='"+stungay+"' and NGAYDAT <= '"+sdenngay+"';");
        ResultSet rs7 = conn.ExcuteQueryGetTable("Select  SUM(TIENTHUE) TONGTIEN from DAT_GIAY where MANV1 = '"+manvchon+"'  and NGAYDAT >='"+stungay+"' and NGAYDAT <= '"+sdenngay+"';");
        int row=1;
           try {
            while (rs4.next()){
                String giothue=doigio(rs4.getInt("GIOTHUE"),rs4.getInt("PHUTTHUE"));
                String giotra=doigio(rs4.getInt("GIOTRA"),rs4.getInt("PHUTTRA"));
                String P_R="";
                String P_P="";
                if(rs4.getString("MANV").equals(manvchon)){
                    P_R="X";
                }
                if(rs4.getString("MANV1").equals(manvchon)){
                    P_P="X";
                }
                table1.addRow(new Object[]{row, rs4.getDate("NGAYDAT"),giothue,giotra,
                                            rs4.getString("STTGIAY"),decimalFormat.format(rs4.getInt("TIENTHUE")),P_R,P_P});
                row=row+1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs5.next()){
                sum1=rs5.getInt("SUM1");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs6.next()){
                sum2=rs6.getInt("SUM2");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs7.next()){
                sumtong=rs7.getInt("TONGTIEN");
                tongtien=sum1 + sumtong - sum2;
                jtongtientracuu.setText(decimalFormat.format(tongtien));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
        
    }//GEN-LAST:event_jTabbedPane1KeyPressed

    private void jPanel33KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel33KeyPressed
        
    }//GEN-LAST:event_jPanel33KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void jnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnhapActionPerformed
        new Otat(Trangchu.this,MANV).setVisible(true);
    }//GEN-LAST:event_jnhapActionPerformed

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
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trangchu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxTinhtrangphong;
    private javax.swing.JTextField Giaythue;
    private javax.swing.JTextField Giaytrong;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JPanel Logout;
    private javax.swing.JButton Okelogout;
    private javax.swing.JPanel QL_giay;
    private javax.swing.JTable Tabletracuu;
    private javax.swing.JPanel Thong_ke_1;
    private javax.swing.JPanel Thong_ke_2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jGiay111;
    private javax.swing.JButton jGiay112;
    private javax.swing.JButton jGiay113;
    private javax.swing.JButton jGiay114;
    private javax.swing.JButton jGiay115;
    private javax.swing.JButton jGiay116;
    private javax.swing.JButton jGiay117;
    private javax.swing.JButton jGiay118;
    private javax.swing.JButton jGiay121;
    private javax.swing.JButton jGiay122;
    private javax.swing.JButton jGiay123;
    private javax.swing.JButton jGiay124;
    private javax.swing.JButton jGiay125;
    private javax.swing.JButton jGiay126;
    private javax.swing.JButton jGiay127;
    private javax.swing.JButton jGiay128;
    private javax.swing.JButton jGiay131;
    private javax.swing.JButton jGiay132;
    private javax.swing.JButton jGiay133;
    private javax.swing.JButton jGiay134;
    private javax.swing.JButton jGiay135;
    private javax.swing.JButton jGiay136;
    private javax.swing.JButton jGiay137;
    private javax.swing.JButton jGiay138;
    private javax.swing.JButton jGiay141;
    private javax.swing.JButton jGiay142;
    private javax.swing.JButton jGiay143;
    private javax.swing.JButton jGiay144;
    private javax.swing.JButton jGiay145;
    private javax.swing.JButton jGiay146;
    private javax.swing.JButton jGiay147;
    private javax.swing.JButton jGiay148;
    private javax.swing.JButton jGiay151;
    private javax.swing.JButton jGiay152;
    private javax.swing.JButton jGiay153;
    private javax.swing.JButton jGiay154;
    private javax.swing.JButton jGiay155;
    private javax.swing.JButton jGiay156;
    private javax.swing.JButton jGiay157;
    private javax.swing.JButton jGiay158;
    private javax.swing.JButton jGiay211;
    private javax.swing.JButton jGiay212;
    private javax.swing.JButton jGiay213;
    private javax.swing.JButton jGiay214;
    private javax.swing.JButton jGiay215;
    private javax.swing.JButton jGiay216;
    private javax.swing.JButton jGiay217;
    private javax.swing.JButton jGiay218;
    private javax.swing.JButton jGiay221;
    private javax.swing.JButton jGiay222;
    private javax.swing.JButton jGiay223;
    private javax.swing.JButton jGiay224;
    private javax.swing.JButton jGiay225;
    private javax.swing.JButton jGiay226;
    private javax.swing.JButton jGiay227;
    private javax.swing.JButton jGiay228;
    private javax.swing.JButton jGiay231;
    private javax.swing.JButton jGiay232;
    private javax.swing.JButton jGiay233;
    private javax.swing.JButton jGiay234;
    private javax.swing.JButton jGiay235;
    private javax.swing.JButton jGiay236;
    private javax.swing.JButton jGiay237;
    private javax.swing.JButton jGiay238;
    private javax.swing.JButton jGiay241;
    private javax.swing.JButton jGiay242;
    private javax.swing.JButton jGiay243;
    private javax.swing.JButton jGiay244;
    private javax.swing.JButton jGiay245;
    private javax.swing.JButton jGiay246;
    private javax.swing.JButton jGiay247;
    private javax.swing.JButton jGiay248;
    private javax.swing.JButton jGiay251;
    private javax.swing.JButton jGiay252;
    private javax.swing.JButton jGiay253;
    private javax.swing.JButton jGiay254;
    private javax.swing.JButton jGiay255;
    private javax.swing.JButton jGiay256;
    private javax.swing.JButton jGiay257;
    private javax.swing.JButton jGiay258;
    private javax.swing.JButton jGiay311;
    private javax.swing.JButton jGiay312;
    private javax.swing.JButton jGiay313;
    private javax.swing.JButton jGiay314;
    private javax.swing.JButton jGiay315;
    private javax.swing.JButton jGiay316;
    private javax.swing.JButton jGiay317;
    private javax.swing.JButton jGiay318;
    private javax.swing.JButton jGiay321;
    private javax.swing.JButton jGiay322;
    private javax.swing.JButton jGiay323;
    private javax.swing.JButton jGiay324;
    private javax.swing.JButton jGiay325;
    private javax.swing.JButton jGiay326;
    private javax.swing.JButton jGiay327;
    private javax.swing.JButton jGiay328;
    private javax.swing.JButton jGiay331;
    private javax.swing.JButton jGiay332;
    private javax.swing.JButton jGiay333;
    private javax.swing.JButton jGiay334;
    private javax.swing.JButton jGiay335;
    private javax.swing.JButton jGiay336;
    private javax.swing.JButton jGiay337;
    private javax.swing.JButton jGiay338;
    private javax.swing.JButton jGiay341;
    private javax.swing.JButton jGiay342;
    private javax.swing.JButton jGiay343;
    private javax.swing.JButton jGiay344;
    private javax.swing.JButton jGiay345;
    private javax.swing.JButton jGiay346;
    private javax.swing.JButton jGiay347;
    private javax.swing.JButton jGiay348;
    private javax.swing.JButton jGiay351;
    private javax.swing.JButton jGiay352;
    private javax.swing.JButton jGiay353;
    private javax.swing.JButton jGiay354;
    private javax.swing.JButton jGiay355;
    private javax.swing.JButton jGiay356;
    private javax.swing.JButton jGiay357;
    private javax.swing.JButton jGiay358;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTennhanvien;
    private com.toedter.calendar.JDateChooser jdenngay;
    private javax.swing.JButton jnhap;
    private javax.swing.JTextField jtongtientracuu;
    private com.toedter.calendar.JDateChooser jtungay;
    // End of variables declaration//GEN-END:variables
}
