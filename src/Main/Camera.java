/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author s-pandianc
 */
public class Camera
{
    public static float x = 0;
    public static float y = 0;
    public static float z = 0;
    
    public static float angle = 0;
    
//    private static final float FOCAL_LENGTH = 100;
   public static float FOCAL_LENGTH = 500;
//    private static final float[] ORIGIN = {};
    
    public static float getX()
    {
        return Camera.x;
    }
    
    public static float getY()
    {
        return Camera.y;
    }
    
    public static float getZ()
    {
        return Camera.z;
    }
    
    public static float getAngle()
    {
        return Camera.angle;
    }
    
    public static void translateX(float translateX)
    {
        Camera.x += translateX;
    }
    
    public static void translateY(float translateY)
    {
        Camera.y += translateY;
    }
    
    public static void translateZ(float translateZ)
    {
        Camera.z += translateZ;
    }
    
    public static void translateCameraFrameX(float translateX)
    {
        Camera.x += (float) Math.cos(angle / 180 * Math.PI) * translateX;
        Camera.z += (float) Math.sin(angle / 180 * Math.PI) * translateX;
    }
    
//    public static void translateCameraFrameY(float translateY)
//    {
//        Camera.y += translateY;
//    }
    
    public static void translateCameraFrameZ(float translateZ)
    {
        Camera.x += (float) Math.cos((.5 * Math.PI) + angle / 180 * Math.PI) * translateZ;
        Camera.z += (float) Math.sin((.5 * Math.PI) + angle / 180 * Math.PI) * translateZ;
    }
    
    public static void rotate(float angle)
    {
        Camera.angle += angle;
    }
    
    public static void setX(float x)
    {
        Camera.x = x;
    }
    
    public static void setY(float y)
    {
        Camera.y = y;
    }
    
    public static void setZ(float z)
    {
        Camera.z = z;
    }
    
    public static void setAngle(float angle)
    {
        Camera.angle = angle;
    }
    
    public static float[] getPos()
    {
        float[] position = {Camera.getX(), Camera.getY(), Camera.getZ()};
        return position;
    }
    
    public static float[] project(float x, float y, float z)
    {
        float[] positionCameraFrame = positionCameraFrame(x, y, z);
        float[] screenCoordinates = new float[2];
        
        screenCoordinates[0] = positionCameraFrame[0] * FOCAL_LENGTH / positionCameraFrame[2] + 960;
        screenCoordinates[1] = 540 - positionCameraFrame[1] * FOCAL_LENGTH / positionCameraFrame[2];
        
        return screenCoordinates;
    }
    
    public static float[] positionCameraFrame(float x, float y, float z)
    {
        float[] position = new float[3];
        
        position[0] = (float) ((z - Camera.z) * Math.sin(angle / 180 * Math.PI) + (x - Camera.x) * Math.cos(angle / 180 * Math.PI));
        position[1] = y;
        position[2] = (float) ((z - Camera.z) * Math.cos(angle / 180 * Math.PI) - (x - Camera.x) * Math.sin(angle / 180 * Math.PI));
        
        return position;
    }
}
