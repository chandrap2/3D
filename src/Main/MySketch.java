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
    Point p1 = new Point(300, 300, 0);
    Point p2 = new Point(-300, 300, 0);
    Point p3 = new Point(300, -300, 0);
    Point p4 = new Point(-300, -300, 0);

    Point p5 = new Point(300, 300, 600);
    Point p6 = new Point(-300, 300, 600);
    Point p7 = new Point(300, -300, 600);
    Point p8 = new Point(-300, -300, 600);
    
    Edge edge1 = new Edge(p1, p2);
    Edge edge2 = new Edge(p2, p4);
    Edge edge3 = new Edge(p4, p3);
    Edge edge4 = new Edge(p3, p1);
    
    Edge edge5 = new Edge(p5, p6);
    Edge edge6 = new Edge(p6, p8);
    Edge edge7 = new Edge(p8, p7);
    Edge edge8 = new Edge(p7, p5);
    
    Edge edge9 = new Edge(p1, p5);
    Edge edge10 = new Edge(p2, p6);
    Edge edge11 = new Edge(p3, p7);
    Edge edge12 = new Edge(p4, p8);
    
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
        System.out.println("1:" + Camera.getZ());
        System.out.println("2:" + Camera.getAngle());
        
        background(0);
//        
//        if (keyPressed)
//        {
//            if (keyCode == UP)
//            {
//                Camera.translateCameraFrameZ(2);
//            }
//
//            if (keyCode == DOWN)
//            {
//                Camera.translateCameraFrameZ(-2);
//            }
//
//            if (keyCode == LEFT)
//            {
//                Camera.rotate(-3);
//            }
//
//            if (keyCode == RIGHT)
//            {
//                Camera.rotate(3);
//            }   
//        }
//        
        p1.display(this);
        p2.display(this);
        p3.display(this);
        p4.display(this);
        
        p5.display(this);
        p6.display(this);
        p7.display(this);
        p8.display(this);
        
        edge1.display(this);
        edge2.display(this);
        edge3.display(this);
        edge4.display(this);
 
        edge5.display(this);
        edge6.display(this);
        edge7.display(this);
        edge8.display(this);
 
        edge9.display(this);
        edge10.display(this);
        edge11.display(this);
        edge12.display(this);
    }
}
