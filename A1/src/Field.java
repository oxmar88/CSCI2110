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
        return "xPos: " + xPos + ", yPos: " + yPos + ", width: " + width + ", height: " + height;
    }

}
