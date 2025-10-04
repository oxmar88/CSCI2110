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
