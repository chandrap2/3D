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
    public static float FOCAL_LENGTH = 500;
    
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_LENGTH = 1000;
    
    public static float x = 0;
    public static float y = 0;
    public static float z = 0;
    
    public static float xAngle = 0;
    public static float yAngle = 0;
    public static float zAngle = 0;
    
    // Getters
    public static float[] getPos()
    {
        float[] position = {Camera.x, Camera.y, Camera.z};
        return position;
    }
    
    public static float[] getAngles()
    {
        float[] angles = {Camera.xAngle, Camera.yAngle, Camera.zAngle};
        return angles;
    }
    
    // Relative transformations
    public static void translate(float translateX, float translateY, float translateZ)
    {
        Camera.x += translateX;
        Camera.y += translateY;
        Camera.z += translateZ;
    }
    
    public static void rotateCameraLocal(float rotateX, float rotateY, float rotateZ)
    {
        Camera.xAngle += rotateX;
        Camera.yAngle += rotateY;
        Camera.zAngle += rotateZ;
    }
    
    // Absolute transformations
    public static void setPos(float x, float y, float z)
    {
        Camera.x = x;
        Camera.y = y;
        Camera.z = z;
    }
    
    public static void setAngles(float xAngle, float yAngle, float zAngle)
    {
        Camera.xAngle = xAngle;
        Camera.yAngle = yAngle;
        Camera.zAngle = zAngle;
    }
    
    // Project onto picture plane
    public static float[] project(float x, float y, float z)
    {
        float[] positionCameraFrame = returnPositionCameraFrame(x, y, z);
        float[] screenCoordinates = new float[2];
        
        screenCoordinates[0] = positionCameraFrame[0] * FOCAL_LENGTH / positionCameraFrame[2] + (float) SCREEN_WIDTH / 2;
        screenCoordinates[1] = (float) SCREEN_LENGTH / 2 - positionCameraFrame[1] * FOCAL_LENGTH / positionCameraFrame[2];        
        
        return screenCoordinates;
    }
    
    // Position of a point in the camrea frame
    public static float[] returnPositionCameraFrame(float x, float y, float z)
    {
        float first;
        float[] finalPosition = new float[3];
        
        first = (float) ((y - Camera.y) * Math.sin(zAngle / 180 * Math.PI) + (x - Camera.x) * Math.cos(zAngle / 180 * Math.PI));
        finalPosition[0] = (float) ((z - Camera.z) * Math.sin(yAngle / 180 * Math.PI) + first * Math.cos(yAngle / 180 * Math.PI));
        
        first = (float) ((y - Camera.y) * Math.cos(xAngle / 180 * Math.PI) - (z - Camera.z) * Math.sin(xAngle / 180 * Math.PI));
        finalPosition[1] = (float) (first * Math.cos(zAngle / 180 * Math.PI) - (x - Camera.x) * Math.sin(zAngle / 180 * Math.PI));
        
        first = (float) ((z - Camera.z) * Math.cos(yAngle / 180 * Math.PI) - (x - Camera.x) * Math.sin(yAngle / 180 * Math.PI));
        finalPosition[2] = (float) ((y - Camera.y) * Math.sin(yAngle / 180 * Math.PI) + first * Math.cos(yAngle / 180 * Math.PI));
        
        return finalPosition;
    }
}
