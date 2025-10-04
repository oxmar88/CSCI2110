/*
 *Author: Omar Elsayed (B00993452)
 * Course: CSCI 2110 - Data Structures
 * Assignment: Assignment 1 - Soccer Simulation
 * Date: October 4, 2025
 *
 * Description:
 * The Ball class stores the ball’s position on the field.
 * It provides getter/setter methods and a method to print its coordinates.
 * */
public class Ball {
    private double bx,by;

    public Ball() {
    }

    public void setBx(double bx){
        this.bx = bx;
    }

    public void setBy(double by){
        this.by = by;
    }

    public double getBx(){
        return bx;
    }

    public double getBy(){
        return by;
    }

    public String toString(){
        return "Bx: " + bx + " By: " + by;
    }

    public void printBallPos(){ //created this method to be able to round the positions without altering the toString method
        System.out.print("Ball is at:  ");
        System.out.printf("(" + "%.2f" , bx);
        System.out.print(",");
        System.out.printf("%.2f" , by );
        System.out.print(")");
    }

}
