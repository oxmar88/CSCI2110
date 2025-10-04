public class Circle {
    private double xpos,ypos,radius;

    public Circle (double xpos, double ypos, double radius){
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
    }

    public double getXpos(){
        return xpos;
    }

    public double getYpos(){
        return ypos;
    }

    public double getRadius(){
        return radius;
    }

    public void setCenter(double x , double y){
        this.xpos = x;
        this.ypos = y;
    }

    public void setRadius(double r){
        this.radius = r;
    }

    public boolean contains(Point p){
        // the distance forumla from maths is distance= sqrt((px−xpos)^2+(py−ypos)^2)
        double xDistance = Math.pow(p.getPx() - xpos,2);
        double yDistance = Math.pow(p.getPy() - ypos,2); // used W3 shcools as a refesher for java Math class methods

        double distance = Math.sqrt(xDistance + yDistance);

        if(distance <= radius){
            return true;
        }
        return false;
    }

    public boolean contains (Rectangle r){
       // finding all 4 corners of the rectangle for easier reusability then using previous contains method as hinted
       Point topLeft = new Point(r.getXpos(),r.getYpos());
       Point topRight = new Point(r.getXpos()+r.getWidth(),r.getYpos());
       Point bottomLeft = new Point(r.getXpos(), r.getYpos() + r.getHeight());
       Point bottomRight = new Point(r.getXpos()+r.getWidth(),r.getYpos() + r.getHeight());

       if (contains(topLeft) && contains(topRight) && contains(bottomLeft) && contains(bottomRight)){
           return true;
       }
       return false;
    }

    // extra toString method for outputting circle
    public String toString(){
        return "Circle[center=(" + xpos + ", " + ypos + "), radius=" + radius + "]";
    }
}
