/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclock;

import javax.swing.JFrame;

/**
 *
 * @author fh922310
 */
public class ClockView{
    
    private ClockCanvas canvas;
    private JFrame window;
    
    public ClockView(int width, int height){
        window = new JFrame("GraphicsDemo1");
        window.setSize(width,height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new ClockCanvas(200,50, 400, 400);
        window.add(canvas);
        window.setVisible(true);
    }

    void update(double secPointerAngle, double minPointerAngle, double hourPointerAngle) {
        canvas.updateSecPointerAngle(secPointerAngle);
        canvas.updateMinPointerAngle(minPointerAngle);
        canvas.updateHourPointerAngle(hourPointerAngle);
        canvas.update(canvas.getGraphics());
        window.repaint();
    }
    
}
