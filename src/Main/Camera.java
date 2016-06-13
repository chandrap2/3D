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
        float[] angles = {(float) (Camera.xAngle / Math.PI * 180), (float) (Camera.yAngle / Math.PI * 180), (float) (Camera.zAngle / Math.PI * 180)};
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
        Camera.xAngle += rotateX / 180 * Math.PI;
        Camera.yAngle += rotateY / 180 * Math.PI;
        Camera.zAngle += rotateZ / 180 * Math.PI;
    }
    
    // Demo method
    public static void moveInCameraDirection(float distance, byte xOrZ)
    {
       float sine = (float) (distance * Math.sin(yAngle));
       float cosine = (float) (distance * Math.cos(yAngle));
       
       switch (xOrZ)
       {
           case 0:  Camera.x += cosine;
                    Camera.z += sine;
                    break;
           case 1:  Camera.z += cosine;
                    Camera.x += -sine;
                    break;
       }
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
        Camera.xAngle = (float) (xAngle / 180 * Math.PI);
        Camera.yAngle = (float) (yAngle / 180 * Math.PI);
        Camera.zAngle = (float) (zAngle / 180 * Math.PI);
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
//        float first;
        float[] finalPosition = new float[3];
        
//        first = (float) ((y - Camera.y) * Math.sin(zAngle / 180 * Math.PI) + (x - Camera.x) * Math.cos(zAngle / 180 * Math.PI));
//        finalPosition[0] = (float) ((z - Camera.z) * Math.sin(yAngle / 180 * Math.PI) + first * Math.cos(yAngle / 180 * Math.PI));
//        
//        first = (float) ((y - Camera.y) * Math.cos(xAngle / 180 * Math.PI) - (z - Camera.z) * Math.sin(xAngle / 180 * Math.PI));
//        finalPosition[1] = (float) (first * Math.cos(zAngle / 180 * Math.PI) - (x - Camera.x) * Math.sin(zAngle / 180 * Math.PI));
//        
//        first = (float) ((z - Camera.z) * Math.cos(yAngle / 180 * Math.PI) - (x - Camera.x) * Math.sin(yAngle / 180 * Math.PI));
//        finalPosition[2] = (float) ((y - Camera.y) * Math.sin(yAngle / 180 * Math.PI) + first * Math.cos(yAngle / 180 * Math.PI));
        
        finalPosition[0] = (float) ((z - Camera.z) * Math.sin(yAngle) + (x - Camera.x) * Math.cos(yAngle));
        finalPosition[1] = y;
        finalPosition[2] = (float) ((z - Camera.z) * Math.cos(yAngle) - (x - Camera.x) * Math.sin(yAngle));
        
        return finalPosition;
    }
}
