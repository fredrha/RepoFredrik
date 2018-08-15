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
   
   public MyClock() throws InterruptedException{
       clockEngine = new ClockEngine(0,0,0);
       clockView = new ClockView(800, 600);
       
      startClock();
   }

   private void startClock()throws InterruptedException{
       clockEngine.pritnTimepassed();
       int i = 0;
        while(i <3600){
           clockEngine.tick(); 
           clockView.update(clockEngine.getSecPointerAngle(), clockEngine.getMinPointerAngle());
           i++;
           Thread.sleep(1000);
        }
       clockEngine.pritnTimepassed();
   }
   
    public static void main(String[] args) throws InterruptedException  {
        SelectClockView selectClockView = new SelectClockView();
    }      
}