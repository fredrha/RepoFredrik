/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author fh922310
 */
public class Clock extends Thread{
    
   private ClockView clockView;
   
    private static int seconds, minutes, hours;
    private static double secPointerAngle, minPointerAngle,hourPointerAngle;
    private String timeZone;
    private ZonedDateTime zonedDateTime;
    private LocalTime localTime;
   
   public Clock(String timeZone){
       this.timeZone = timeZone;
       zonedDateTime = ZonedDateTime.now(ZoneId.of(timeZone));
       localTime = zonedDateTime.toLocalTime();
       clockView = new ClockView(800, 600);
       
   }

   @Override
    public void run(){
        zonedDateTime = ZonedDateTime.now(ZoneId.of(timeZone));
        localTime = zonedDateTime.toLocalTime();
        int sec = localTime.getSecond();
        int min = localTime.getMinute();
        int hour = localTime.getHour();
        double secAngle = calcSecPointerAngle(sec);
        double minAngle = calcMinPointerAngle(min);
        double hourAngle = calcHourPointerAngle(hour);
        update(secAngle, minAngle, hourAngle);
    }

    void update(double secPointerAngle, double minPointerAngle, double hourPointerAngle) {
        clockView.update(secPointerAngle, minPointerAngle, hourPointerAngle);
    }

        private double calcSecPointerAngle(int seconds){
        double startAngle = -Math.PI/2;
        this.secPointerAngle = startAngle + ((2*Math.PI)/60)*seconds;
        return secPointerAngle;
    }
    private double calcMinPointerAngle(int minutes){
        double startAngle = -Math.PI/2;
        this.minPointerAngle = startAngle + ((2*Math.PI)/60)*minutes;
        return minPointerAngle;
    }
    private double calcHourPointerAngle(int hours) {
        double startAngle = -Math.PI/2;
        this.hourPointerAngle = startAngle + ((2*Math.PI)/60)*hours;
        return hourPointerAngle;
        }
    
}
