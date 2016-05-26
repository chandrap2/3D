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

public class Point extends ThreeDObject implements BasicMethods
{
    public Point()
    {
        super(0, 0, 0, "l");
    }
    
    public Point(float x, float y, float z, String name)
    {
        super(x, y, z, name);
        
        this.positionCoordinates[0] *= 100;        
        this.positionCoordinates[1] *= 100;        
        this.positionCoordinates[2] *= 100;        
    }
    
    public void display(PApplet applet)
    {
//        if (Camera.positionCameraFrame(this.getX(), this.getY(), this.getZ())[2] >= Camera.FOCAL_LENGTH)
        {
            float x = this.getX();
            float y = this.getY();
            float z = this.getZ();

            float screenX = Camera.project(x, y, z)[0];
            float screenY = Camera.project(x, y, z)[1];

            applet.rect(screenX, screenY, 5, 5);
        }
//        else
//        {
//            System.out.println(name);
//        }
    }
    
    public float getX()
    {
        return positionCoordinates[0];
    }
    
    public float getY()
    {
        return positionCoordinates[1];
    }
    
    public float getZ()
    {
        return positionCoordinates[2];
    }
    
    public float[] getPos()
    {
        return this.positionCoordinates;
    }
    
    public void translate(float translateX, float translateY, float translateZ)
    {
        positionCoordinates[0] += translateX;
        positionCoordinates[1] += translateY;
        positionCoordinates[2] += translateZ;
    }
    
    public void set(float newX, float newY, float newZ)
    {
        positionCoordinates[0] = newX;
        positionCoordinates[1] = newY;
        positionCoordinates[2] = newZ;
    }
}
