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
    Point point1 = new Point(350, 350, 350);
    
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
        point1.display(this);
    }
}
