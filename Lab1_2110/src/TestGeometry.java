import java.util.Scanner;

public class TestGeometry {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        // Reading a circle
        System.out.print("Enter circle center (x,y) and radius: ");
        double circleX = sc.nextDouble();
        double circleY = sc.nextDouble();
        double radius = sc.nextDouble();
        Circle c = new Circle(circleX,circleY,radius);

        // Reading a point
        System.out.print("Enter a point (x,y): ");
        double pointX = sc.nextDouble();
        double pointY = sc.nextDouble();
        Point p = new Point(pointX,pointY);

        // Reading a rectangle (top-left x, y, width, height)
        System.out.print("Enter a rectangle (xpos ypos width height): ");
        double rectangleX = sc.nextDouble();
        double rectangleY = sc.nextDouble();
        double rectangleW = sc.nextDouble();
        double rectangleH = sc.nextDouble();
        Rectangle r = new Rectangle(rectangleX,rectangleY,rectangleW,rectangleH);
        System.out.println();

        // Displaying results
        System.out.println(c);
        System.out.println("Point "+ p + " contained in circle? " + c.contains(p));
        System.out.println(r);
        System.out.println("Rectangle contained in circle? " + c.contains(r));

        sc.close();
    }
}
