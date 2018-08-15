/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclock;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author fh922310
 */
public class SelectClockView extends JFrame{
    
    private JLabel textPanel;
    private JButton startClockButton;
    private JComboBox<String> timeZones;
    private static MyClock parent;
    
    public SelectClockView(){
        super();
        setVisible(true);
        setLayout(new GridLayout(3,1));
        setPreferredSize(new Dimension(200,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.textPanel = new JLabel();
        textPanel.setText("Select timezone");
        add(textPanel);
        
        String[] choices = { "Europe/London","Europe/Stockholm", "Europe/Helsinki","Europe/Moscow","Asia/Beijing","Asia/Tokyo"};
        timeZones = new JComboBox<String>(choices);
        timeZones.setVisible(true);
        add(timeZones);
        
        this.startClockButton = new JButton("Start clock");
        startClockButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MyClock myClock = MyClock.getInstance();
                    LocalTime localTime = getSelectedTimeZone();
                    int sec =  localTime.getSecond();
                    int min = localTime.getMinute();
                    int hour = localTime.getHour();
                    myClock.initClock(sec, min, hour);                   
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });
        add(startClockButton);
        pack();
    }
    
    private LocalTime getSelectedTimeZone(){
        String timezone = (String)timeZones.getSelectedItem();
        if(timezone == null){
            System.out.println("No timezone selected");
        }
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(timezone));
        LocalTime localTime = zonedDateTime.toLocalTime();
        System.out.println(localTime);
        
        return localTime;
    }
}
