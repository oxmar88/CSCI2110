/*
 *Author: Omar Elsayed (B00993452)
 * Course: CSCI 2110 - Data Structures
 * Assignment: Assignment 1 - Soccer Simulation
 * Date: October 4, 2025
 *
 * Description:
 * The Field class defines the boundaries of the playing field.
 * I also additionally added getter methods for the field’s position and size for easier use.
 */

public class Field {
    private double xPos, yPos,width,height;

    public Field(double xPos, double yPos, double width, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    // added getters to be able to access them without making the instance variables public in class
    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String toString(){
        return "[x=" + xPos + ",y=" + yPos + ",w=" + width + ",h=" + height +"]";
    }

}
