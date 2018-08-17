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
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
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
    private ScheduledThreadPoolExecutor eventPool;
 
    
    public SelectClockView(){
        super();
        setVisible(true);
        setLayout(new GridLayout(3,1));
        setPreferredSize(new Dimension(200,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        eventPool = new ScheduledThreadPoolExecutor(5);
        addComponents();
        
        add(startClockButton);
        pack();
    }
    
    private void addComponents() {
        this.textPanel = new JLabel();
        textPanel.setText("Select timezone");
        add(textPanel);
        
        String[] choices = { "Europe/London","Europe/Stockholm", "Europe/Helsinki","Europe/Moscow","Asia/Tokyo"};
        timeZones = new JComboBox<String>(choices);
        timeZones.setVisible(true);
        add(timeZones);
        
        this.startClockButton = new JButton("Start clock");
        startClockButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String timezone = (String)timeZones.getSelectedItem();
                Clock clock = new Clock(timezone);
                eventPool.scheduleAtFixedRate(clock, 0, 1, TimeUnit.SECONDS);
                clock.start();
                
                System.out.println(Thread.activeCount());
            } 
        });
    }
    
    
}
