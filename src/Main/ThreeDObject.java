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
public class ThreeDObject {
    protected float[] positionCoordinates = new float[3];
    
    public ThreeDObject(float x, float y, float z)
    {
        positionCoordinates[0] = x;
        positionCoordinates[1] = y;
        positionCoordinates[2] = z;
    }
}
