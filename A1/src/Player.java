/*
 *Author: Omar Elsayed (B00993452)
 * Course: CSCI 2110 - Data Structures
 * Assignment: Assignment 1 - Soccer Simulation
 * Date: October 4, 2025
 *
 * Description:
 *The Player class represents a soccer player that can kick a ball within a field.
 *The kick method calculates the new ball position and determines if it was reflected/ if its within the field bounds.
 */

public class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public String toString() {
        return "Player " + name;
    }

    public boolean kick (Field f, Ball b, double d, double r) {
        boolean reflected = false;

        // using getter methods to get x and y coordinates of ball passed in the kick method
        double x = b.getBx();
        double y = b.getBy();

        double radians = Math.toRadians(r);

        double nx = x + d * Math.cos(radians);
        double ny = y + d * Math.sin(radians);

        // storing the boundaries of our field in values for re-usibility

        double lowerX = f.getXPos();
        double lowerY = f.getYPos();
        double upperX = f.getXPos() + f.getWidth();
        double upperY = f.getYPos() + f.getHeight();

        if (nx >= lowerX && nx <= upperX && ny >= lowerY && ny <= upperY) {
            // this means if the ball is within our field
            b.setBx(nx);
            b.setBy(ny);
        }else if ((nx < lowerX || nx > upperX) && (ny >= lowerY && ny <= upperY))  {
            // X is out of bounds and Y is still within
            reflected = true;
            b.setBx(x);
            b.setBy(ny);
        }else if ((ny < lowerY || ny > upperY) && (nx >= lowerX && nx <= upperX)) {
            // Y is out of bounds and X is still within
            reflected = true;
            b.setBx(nx);
            b.setBy(y);
        }else {
            // if it hits out of bounds for both x and y it returns to same position
            reflected = true;
            b.setBx(x);
            b.setBy(y);
        }
        return reflected;
    }

}
