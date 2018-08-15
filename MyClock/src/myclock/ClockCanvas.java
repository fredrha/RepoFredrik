/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclock;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author fh922310
 */
public class ClockCanvas extends Canvas{

    private double secPointerX, secPointerY;
    private double minPointerX, minPointerY;
    private double hourPointerX, hourPointerY;
    private double SecPointerAngle = -Math.PI/2;
    private double minPointerAngle = -Math.PI/2;
    private double hourPointerAngle = -Math.PI/2;
    
    private int clockMidX;
    private int clockMidY;
    private int ovalatX;
    private int ovalatY;
    
    private int width; //both are 400 right now
    private int height;
    
    public ClockCanvas(int x, int y, int width, int height){
        this.ovalatX = x;
        this.ovalatY = y;
        this.width = width;
        this.height = height;
        this.clockMidX = x+width/2;
        this.clockMidY = y+height/2;
        this.secPointerX =  x+width/2;
        this.secPointerY = y;
        this.minPointerX = x+width/2;
        this.minPointerY = y+height/2;
        this.hourPointerX = x+width/2;
        this.hourPointerY = y + height/4;
   }
    
    public void paint(Graphics g){
        drawClock(g, ovalatX, ovalatY, width, height);
    }
    
    private void drawClock(Graphics g, int x, int y, int width, int height){
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
        g.setFont(new Font("Sans senrif", Font.BOLD, 30) );
        g.drawString("12", clockMidX-15, y+30);
        g.drawString("3", x+width-30, y+height/2+15);
        g.drawString("6", clockMidX-10, y+height-10);
        g.drawString("9", x+15, y+height/2+15);
      
        g.drawLine(clockMidX, clockMidY, (int)secPointerX, (int)secPointerY);
        g.drawLine(clockMidX, clockMidY, (int)minPointerX, (int) minPointerY);
         g.drawLine(clockMidX, clockMidY, (int)hourPointerX, (int) hourPointerY);

    }

    public void updateSecPointerAngle(double secPointerAngle){
        this.SecPointerAngle = secPointerAngle;
        this.secPointerX = clockMidX + 200 * Math.cos(secPointerAngle);
        this.secPointerY = clockMidY + 200 * Math.sin(secPointerAngle);
    }
    
    public void updateMinPointerAngle(double minPointerAngle){
        this.minPointerAngle = minPointerAngle;
        this.minPointerX = clockMidX + 100 * Math.cos(minPointerAngle);
        this.minPointerY = clockMidY + 100 * Math.sin(minPointerAngle);
    }
    public void updateHourPointerAngle(double hourPointerAngle){
        this.hourPointerAngle = hourPointerAngle;
        this.hourPointerX = clockMidX + 75 * Math.cos(hourPointerAngle);
        this.hourPointerY = clockMidY + 75 * Math.sin(hourPointerAngle);
    }
    
}
