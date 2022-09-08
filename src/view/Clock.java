/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author giuse
 */
public class Clock extends Thread{
    private JLabel lb1;
    
    public Clock(JLabel lb1){
        this.lb1 = lb1;
    }
    
    @Override
    public void run(){
        SimpleDateFormat sdf = new  SimpleDateFormat("HH:mm");
        while(true){
            Date now= new Date();
            String st= sdf.format(now);
            lb1.setText(st);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
    
}
