/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author chand_000
 */

import processing.core.*;

public class MySketch extends PApplet
{
    Point point = new Point();
    Point point2 = new Point(300, 200, 0);
    
    public void settings()
    {
        size(1920, 1080);
    }
    
    public void setup()
    {
        stroke(255);
        fill(255);
        rectMode(CENTER);
    }
    
    public void draw()
    {
        background(0);
        point.display(this);
        point2.display(this);
        
        if (keyPressed)
        {
            if (keyCode == UP || keyCode == DOWN)
            {
                Camera.translateY(keyCode == UP ? 3 : -3);
            }
            
            if (keyCode == RIGHT || keyCode == LEFT)
            {
                Camera.translateX(keyCode == RIGHT ? 3 : -3);
            }
        }
        
        if (mousePressed && mouseButton == LEFT) Camera.translateZ(3);
        if (mousePressed && mouseButton == RIGHT) Camera.translateZ(-3);
    }
}
