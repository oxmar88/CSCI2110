// Name: Omar Elsayed
// Banner ID: B00993452
// Lab 1 – CSCI 2110 Fall 2025
import java.util.Scanner;

public class ComplexTest {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter complex number 1 (real imag) : ");
        double a1 = sc.nextDouble();
        double b1 = sc.nextDouble();
        Complex z1 = new Complex(a1,b1);

        System.out.print("Enter complex number 2 (real imag) : ");
        double a2 = sc.nextDouble();
        double b2= sc.nextDouble();
        Complex z2 = new Complex(a2,b2);

        System.out.println();
        System.out.println("Number 1 is " + z1);
        System.out.println(z1 + (z1.isReal() ? " is a pure real number" : " is NOT a pure real number"));
        System.out.println(z1 + (z1.isImaginary() ? " is a pure imaginary number" : " is NOT a pure imaginary real number"));

        System.out.println();
        System.out.println("Number 2 is " + z2);
        System.out.println(z2 + (z2.isReal() ? " is a pure real number" : " is NOT a pure real number"));
        System.out.println(z2 + (z2.isImaginary() ? " is a pure imaginary number" : " is NOT a pure imaginary real number"));

        System.out.println();
        System.out.println("The magnitude of " + z1  + " is " + z1.magnitude());
        System.out.println("The magnitude of " + z2  + " is " + z2.magnitude());
        System.out.println(z1 + " + " + z2 + " is " + z1.add(z2));
        System.out.println(z1 + " - " + z2 + " is " + z1.sub(z2));
        System.out.println(z1 + " * " + z2 + " is " + z1.multiply(z2));

        sc.close();
    }
}
