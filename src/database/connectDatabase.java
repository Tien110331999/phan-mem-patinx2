/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.lang.System.Logger.Level;
import java.lang.System.Logger;
import java.sql.*;
/**
/**
 *
 * @author Cha-Tin
 */
public class connectDatabase {
    Connection conn;
    public connectDatabase(){
        String url = "jdbc:mysql://localhost:3306/patinx2";
        var user ="root";
        var password="";
        try {

            conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
//                System.out.println("Kết nối CSDL SQL Server thành công!");
            }
        } catch (SQLException ex){
//            System.out.println("Failed To Connect To Server Successfully");
        }
    }
    //Thực thi câu lệnh SELECT
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL){
        try {
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return null;
    }
    //Thực thi INSERT, DELETE, UPDATE
    public void ExcuteQueryUpdateDB(String cauTruyVanSQL){
       
        try {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(cauTruyVanSQL);
                stmt.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
          
    }
}
