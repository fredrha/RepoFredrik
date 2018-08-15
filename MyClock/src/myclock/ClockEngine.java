/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fh922310
 */
public class ClockEngine {
    
    private static int seconds, minutes, hours;
    private static double secPointerAngle, minPointerAngle,hourPointerAngle;

    public ClockEngine(int seconds, int minutes, int hours){
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        printTimepassed();
        calcSecPointerAngle(seconds);
        calcMinPointerAngle(minutes);
        calHourPointAngle(hours);
    }
    
    public void tick(){
        seconds++;
        calcSecPointerAngle(seconds); 
        if(seconds%60 == 0 && seconds !=0){
            minutes++;
            calcMinPointerAngle(minutes);
            seconds = 0;
        }
        if(minutes%60 == 0 && minutes != 0){
              hours++;  
              
                }
    }
    public void printTimepassed(){
        System.out.println(seconds);
        System.out.println(minutes);
        System.out.println(hours);
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
    private double calHourPointAngle(int hours) {
        double startAngle = -Math.PI/2;
        this.hourPointerAngle = startAngle + ((2*Math.PI)/60)*hours;
        return hourPointerAngle;
        }
    public double getSecPointerAngle(){
        return secPointerAngle;
    }
    public double getMinPointerAngle(){
        return minPointerAngle;
    }
    public double getHourPointAngle() {
        return hourPointerAngle;
    }
    
    void startClock() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
    
}
