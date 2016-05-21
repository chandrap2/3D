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
public class Edge implements BasicMethods {
    private String name;
    private Point p1;
    private Point p2;
    
    public Edge(Point p1, Point p2, String name)
    {
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void display(PApplet applet) {
//        if ((Camera.positionCameraFrame(p1.getX(), p1.getY(), p1.getZ())[2] >= Camera.FOCAL_LENGTH) && (Camera.positionCameraFrame(p2.getX(), p2.getY(), p2.getZ())[2] >= Camera.FOCAL_LENGTH))
        {    
            float[] pointOneScreenCoor = Camera.project(p1.getX(), p1.getY(), p1.getZ());
            float[] pointTwoScreenCoor = Camera.project(p2.getX(), p2.getY(), p2.getZ());

            applet.line(pointOneScreenCoor[0], pointOneScreenCoor[1], pointTwoScreenCoor[0], pointTwoScreenCoor[1]);
        }
//        else
//        {
//            System.out.println(name);
//        }
    }
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public float getX() {
        return (p1.getX() + p2.getX()) / 2;
    }

    @Override
    public float getY() {
        return (p1.getY() + p2.getY()) / 2;
    }

    @Override
    public float getZ() {
        return (p1.getZ() + p2.getZ()) / 2;
    }

    @Override
    public float[] getPos() {
        float[] position = {this.getX(), this.getY(), this.getZ()};
        return position;
    }

    @Override
    public void translate(float translateX, float translateY, float translateZ) {
        p1.translate(translateX, translateY, translateZ);
        p2.translate(translateX, translateY, translateZ);
    }

    @Override
    public void set(float newX, float newY, float newZ) {
        p1.set(newX, newY, newZ);
        p2.set(newX, newY, newZ);
    }
}
