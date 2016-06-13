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
//    ArrayList<Point> points = new ArrayList<Point>();
//    File file = new File("RhombicDodecahedron-coords.txt");
//    String filePattern = "\\s*,+\\s*|\\s+";
//    
//    int i = 0;
    
    Point p1 = new Point(300, 300, 500, "p1");
    Point p2 = new Point(-300, 300, 500, "p2");
    Point p3 = new Point(300, -300, 500, "p3");
    Point p4 = new Point(-300, -300, 500, "p4");

    Point p5 = new Point(300, 300, 1100, "p5");
    Point p6 = new Point(-300, 300, 1100, "p6");
    Point p7 = new Point(300, -300, 1100, "p7");
    Point p8 = new Point(-300, -300, 1100, "p8");
    
    Edge edge1 = new Edge(p1, p2, "e1");
    Edge edge2 = new Edge(p2, p4, "p2");
    Edge edge3 = new Edge(p4, p3, "e3");
    Edge edge4 = new Edge(p3, p1, "e4");
    
    Edge edge5 = new Edge(p5, p6, "e5");
    Edge edge6 = new Edge(p6, p8, "e6");
    Edge edge7 = new Edge(p8, p7, "e7");
    Edge edge8 = new Edge(p7, p5, "e8");
    
    Edge edge9 = new Edge(p1, p5, "e9");
    Edge edge10 = new Edge(p2, p6, "e10");
    Edge edge11 = new Edge(p3, p7, "e11");
    Edge edge12 = new Edge(p4, p8, "e12");
    
    public void settings()
    {
        size(Camera.SCREEN_WIDTH, Camera.SCREEN_LENGTH);
    }
    
    public void setup()
    {
//        try
//        {
//            Scanner sc = new Scanner(file).useDelimiter(filePattern);
//            while (sc.hasNext())
//            {
//                i++;
//                points.add(new Point((float) sc.nextDouble(), (float) sc.nextDouble(), (float) sc.nextDouble(), Integer.toString(i)));
//            }
//            points.trimToSize();
//        }
//        
//        catch (FileNotFoundException ex)
//        {
//            Logger.getLogger(MySketch.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        stroke(255);
        fill(255);
        rectMode(CENTER);
    }
    
    public void draw()
    {
        background(0);
        
        if (keyPressed)
        {
            if (key == 'w')
            {
                Camera.moveInCameraDirection(20, (byte) 1);
            }
            
            if (key == 's')
            {
                Camera.moveInCameraDirection(-20, (byte) 1);
            }
            
            if (key == 'd')
            {
                Camera.moveInCameraDirection(20, (byte) 0);
            }
            
            if (key == 'a')
            {
                Camera.moveInCameraDirection(-20, (byte) 0);
            }
                        
            if (keyCode == LEFT)
            {
                Camera.rotateCameraLocal(0, 2, 0);
            }

            if (keyCode == RIGHT)
            {
                Camera.rotateCameraLocal(0, -2, 0);
            }   
            
//            if (keyCode == UP)
//            {
//                Camera.rotateCameraLocal(2, 0, 0);
//            }
//
//            if (keyCode == DOWN)
//            {
//                Camera.rotateCameraLocal(-2, 0, 0);
//            }
       }
        
//        /*        
        System.out.println(frameRate);
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
        
//        System.out.println(Camera.returnPositionCameraFrame(p1.getX(), p1.getY(), p1.getZ())[2]);
//        System.out.println(Camera.returnPositionCameraFrame(p3.getX(), p3.getY(), p3.getZ())[2]);
//        System.out.println();

//        */        
        
//        for (int j = 0; j < i; j++)
//        {
//            points.get(j).display(this);
//        }
        
        line(Camera.SCREEN_WIDTH - 200, Camera.SCREEN_LENGTH - 100, Camera.SCREEN_WIDTH - 200, Camera.SCREEN_LENGTH - 200);
        stroke(0, 255, 0);
        line(Camera.SCREEN_WIDTH - 200, Camera.SCREEN_LENGTH - 100, Camera.SCREEN_WIDTH - 200 - (float) Math.sin(Camera.getAngles()[1]/ 180 * Math.PI) * 50, Camera.SCREEN_LENGTH - 100 - (float) Math.cos(Camera.getAngles()[1] / 180 * Math.PI) * 50);
        stroke(255);
    }
}
