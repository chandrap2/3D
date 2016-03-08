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

public class Point {
    private float x, y, z;
    private float screenX, screenY;
    private float perspectiveRatio;
    private float pointSizePerspective;
    
    private static final float FOCAL_LENGTH = 200;
    private static final float POINT_SIZE = 15;
    private static final float ORIGIN_X = 960;
    private static final float ORIGIN_Y = 540;
    
    public Point(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void display(PApplet applet)
    {
        screenX = pointToScreen()[0];
        screenY = pointToScreen()[1];
        pointSizePerspective = pointToScreen()[2];
        applet.rect(screenX, screenY, pointSizePerspective, pointSizePerspective);
    }
    
    public void rotateX()
    {
        
    }
    
    public void rotateY()
    {
        
    }
    
    public void rotateZ()
    {
        
    }
    
    public void translateX(float xTranslate)
    {
        this.x += xTranslate;
    }
    
    public void translateY(float yTranslate)
    {
        this.y += yTranslate;
    }
    
    public void translateZ(float zTranslate)
    {
        this.z += zTranslate;
    }
    
    private float[] pointToScreen()
    {
        float[] coordinates = new float[3];
        perspectiveRatio = FOCAL_LENGTH / (FOCAL_LENGTH + z);
        
        coordinates[0] = x * perspectiveRatio + ORIGIN_X;
        coordinates[1] = ORIGIN_Y - y * perspectiveRatio;
        coordinates[2] = POINT_SIZE * perspectiveRatio;
        
        return coordinates;
    }
}