/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import processing.core.PApplet;

/**
 *
 * @author s-pandianc
 */
public interface BasicMethods {
    public void display(PApplet applet);
    
    public float getX();
    public float getY();
    public float getZ();
    public float[] getPos();
    
    public void translate(float translateX, float translateY, float translateZ);
    public void set(float newX, float newY, float newZ);
}
