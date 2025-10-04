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

    public void printBallPos(){ //created this method to be able to round the positions without altering 2 string method
        System.out.print("Ball is at:  ");
        System.out.printf("Bx: " + "%.2f" , bx);
        System.out.printf(" By: " + "%.2f" , by);
    }

}
