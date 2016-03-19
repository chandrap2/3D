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

public class Point
{
    private float x, y, z;
    private float screenX, screenY;
    private float perspectiveRatio;
    private float pointSizePerspective;
    
    private static final float FOCAL_LENGTH = 200;
    private static final float POINT_SIZE = 25;
    private static final float ORIGIN_X = 960;
    private static final float ORIGIN_Y = 540;
    
    public Point(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Point()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    
    public static float getFocalLength()
    {
        return FOCAL_LENGTH;
    }
    
    public void display(PApplet applet)
    {
        screenX = pointToScreen()[0];
        screenY = pointToScreen()[1];
        pointSizePerspective = pointToScreen()[2];
        applet.rect(screenX, screenY, pointSizePerspective, pointSizePerspective);
    }
    
    public void rotateX(float radius, float angle, float x, float y, float z)
    {
        this.x = x;
        this.y = (float) Math.sin(angle) * radius + y;
        this.z = (float) Math.cos(angle) * radius + z;
    }    
    
    public void rotateY(float radius, float angle, float x, float y, float z)
    {
        this.x = (float) Math.cos(angle) * radius + x;
        this.y = y;
        this.z = (float) Math.sin(angle) * radius + z;
    }
    
    public void rotateZ(float radius, float angle, float x, float y, float z)
    {
        this.x = (float) Math.cos(angle) * radius + x;
        this.y = (float) Math.sin(angle) * radius + y;
        this.z = z;
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
        perspectiveRatio = FOCAL_LENGTH / (FOCAL_LENGTH + (Camera.z - this.z));
        
        coordinates[0] = (this.x - Camera.x) * perspectiveRatio + ORIGIN_X;
        coordinates[1] = ORIGIN_Y - (this.y - Camera.y) * perspectiveRatio;
        coordinates[2] = POINT_SIZE * perspectiveRatio;
        
        return coordinates;
    }
}
