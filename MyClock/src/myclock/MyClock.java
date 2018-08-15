/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclock;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyClock {
   
   private ClockEngine clockEngine;
   private ClockView clockView;
   private static MyClock myClock = null;
   
   public MyClock(){
       
   }
   public static MyClock getInstance(){
       if(myClock == null){
           myClock = new MyClock();
       }
       return myClock;
   }
   
   public void initClock(int sec, int min, int hour)throws InterruptedException{
       
       clockEngine = new ClockEngine(sec,min,hour);
       clockView = new ClockView(800, 600);
       clockView.update(clockEngine.getSecPointerAngle(), clockEngine.getMinPointerAngle(), clockEngine.getHourPointAngle());
       startClock();
   }

   private void startClock()throws InterruptedException{
       //clockEngine.startClock();
       int i = 0;
        while(i <3600){
           clockEngine.tick(); 
           clockView.update(clockEngine.getSecPointerAngle(), clockEngine.getMinPointerAngle(), clockEngine.getHourPointAngle());
           i++;
           Thread.sleep(100);
        }
   }
   
    public static void main(String[] args) throws InterruptedException  {
        SelectClockView selectClockView = new SelectClockView();
    }      
}