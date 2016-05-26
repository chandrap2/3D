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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.*;

public class MySketch extends PApplet
{
    ArrayList<Point> points = new ArrayList<Point>();
    File file = new File("RhombicDodecahedron-coords.txt");
    String filePattern = "\\s*[\\p{Punct}&&[--.]]*\\s*[\\D][\\W]";
    
    int i = 0;
    
//    Point p1 = new Point(300, 300, 500, "p1");
//    Point p2 = new Point(-300, 300, 500, "p2");
//    Point p3 = new Point(300, -300, 500, "p3");
//    Point p4 = new Point(-300, -300, 500, "p4");
//
//    Point p5 = new Point(300, 300, 1100, "p5");
//    Point p6 = new Point(-300, 300, 1100, "p6");
//    Point p7 = new Point(300, -300, 1100, "p7");
//    Point p8 = new Point(-300, -300, 1100, "p8");
//    
//    Edge edge1 = new Edge(p1, p2, "e1");
//    Edge edge2 = new Edge(p2, p4, "p2");
//    Edge edge3 = new Edge(p4, p3, "e3");
//    Edge edge4 = new Edge(p3, p1, "e4");
//    
//    Edge edge5 = new Edge(p5, p6, "e5");
//    Edge edge6 = new Edge(p6, p8, "e6");
//    Edge edge7 = new Edge(p8, p7, "e7");
//    Edge edge8 = new Edge(p7, p5, "e8");
//    
//    Edge edge9 = new Edge(p1, p5, "e9");
//    Edge edge10 = new Edge(p2, p6, "e10");
//    Edge edge11 = new Edge(p3, p7, "e11");
//    Edge edge12 = new Edge(p4, p8, "e12");
    
    public void settings()
    {
        size(Camera.SCREEN_WIDTH, Camera.SCREEN_LENGTH);
    }
    
    public void setup()
    {
        try
        {
            Scanner sc = new Scanner(file).useDelimiter(filePattern);
            /*/
            System.out.println(sc.nextInt());
            System.out.println(sc.nextInt());
            System.out.println(sc.nextInt());
            System.out.println(sc.nextInt());
            System.out.println(sc.nextInt());
            System.out.println(sc.nextInt());
            /*/
            while (sc.hasNext())
            {
                i++;
                points.add(new Point((float) sc.nextInt(), (float) sc.nextInt(), (float) sc.nextInt(), Integer.toString(i)));
//                System.out.println(sc.next());
//                System.out.println(sc.next());
                System.out.println(points.get(i - 1).getX());
            }
            System.out.println("");
            points.trimToSize();
            /**/
        }
        
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(MySketch.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        ArrayList<Point> points = new ArrayList<Point>();
        stroke(255);
        fill(255);
        rectMode(CENTER);
    }
    
    public void draw()
    {
//        System.out.println("1:" + Camera.getZ());
//        System.out.println("2:" + Camera.getAngle());   
        background(0);
        
        if (keyPressed)
        {
            if (key == 'w')
            {
                Camera.translateCameraFrameZ(15);
            }

            if (key == 's')
            {
                Camera.translateCameraFrameZ(-15);
            }
            
            if (key == 'd')
            {
                Camera.translateCameraFrameX(15);
            }

            if (key == 'a')
            {
                Camera.translateCameraFrameX(-15);
            }
            
            if (keyCode == LEFT)
            {
                Camera.rotate(2);
            }

            if (keyCode == RIGHT)
            {
                Camera.rotate(-2);
            }   
        }
        
//        System.out.println(frameRate);
        /*        
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
        */        
//        Point(300, 300, 500, "p1").display();
        
//        points.get(0).display(this);
        for (int j = 0; j < i; j++)
        {
            System.out.println(points.get(j).getName() + ": " + points.get(j).getX());
        }
      
        System.out.println();
        
        line(Camera.SCREEN_WIDTH - 200, Camera.SCREEN_LENGTH - 100, Camera.SCREEN_WIDTH - 200, Camera.SCREEN_LENGTH - 200);
        stroke(0, 255, 0);
        line(Camera.SCREEN_WIDTH - 200, Camera.SCREEN_LENGTH - 100, Camera.SCREEN_WIDTH - 200 - (float) Math.sin(Camera.getAngle() / 180 * Math.PI) * 50, Camera.SCREEN_LENGTH - 100 - (float) Math.cos(Camera.getAngle() / 180 * Math.PI) * 50);
        stroke(255);
    }
}
