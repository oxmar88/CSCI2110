// Name: Omar Elsayed
// Banner ID: B00993452
// Lab 1 – CSCI 2110 Fall 2025
public class Rectangle {
    private double xpos,ypos,width,height;

    public Rectangle(double xpos, double ypos, double width, double height){
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    public void setXpos(double x){
        this.xpos = x;
    }

    public void setYpos(double y){
        this.ypos = y;
    }

    public void setWidth(double w){
        this.width = w;
    }

    public void setHeight(double h){
        this.height = h;
    }

    public double getXpos(){
        return xpos;
    }

    public double getYpos(){
        return ypos;
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    public String toString(){
        return "Rectangle[xpos=" + xpos + ", ypos=" + ypos + ", width=" + width + ", height=" + height + "]";
    }
}
