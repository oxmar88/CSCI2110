// Name: Omar Elsayed
// Banner ID: B00993452
// Lab 1 – CSCI 2110 Fall 2025
public class Point {
    private double px, py;

    public Point(double px, double py){
        this.px = px;
        this.py = py;
    }

    public void setPx( double x ){
        this.px = x;
    }

    public void setPy( double y ){
        this.py = y;
    }

    public double getPx(){
        return px;
    }

    public double getPy(){
        return py;
    }

    public String toString(){
        return "(" + px + ", " + py + ")";
    }
}
