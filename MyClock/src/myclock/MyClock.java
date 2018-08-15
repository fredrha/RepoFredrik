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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        System.out.println(LocalDateTime.now());
     
        JFrame mainFrame = new JFrame();
        mainFrame = new JFrame("MyClock");
        mainFrame.setPreferredSize(new Dimension(200,200));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setLayout(new GridLayout(3,1));
        
        JLabel textPanel = new JLabel();
        textPanel.setText("Select timezone");
        mainFrame.add(textPanel);
        
        String[] choices = { "-3","-2", "-1","GMT","+1","+2"};

        JComboBox<String> timeZones = new JComboBox<String>(choices);

        timeZones.setVisible(true);
        mainFrame.add(timeZones);
        
        JButton startClockButton = new JButton("Start clock");
        startClockButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MyClock myClock = new MyClock();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        mainFrame.add(startClockButton);
        mainFrame.pack();
    }
}
