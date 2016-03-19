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
}
