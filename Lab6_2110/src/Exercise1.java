// Omar Elsayed B00993452

import java.util.*;

public class Exercise1 {

    public static int factorial(int n) {
        if (n == 0) {
            return 1; // base case
        }

        return n * factorial(n - 1); // glue case n* as n! = n * n(n-1)....
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1; // as fib of 1 = 1
        }

        return fib(n - 1) + fib(n - 2); //sum of previous two numbers
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * power(x,n-1); // as n^x == n * n^(x-1)
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Factorial of a number");
        System.out.print("Enter a positive integer: ");

        int n = scanner.nextInt();

        System.out.println("The factorial of " + n + " is " + factorial(n));
        System.out.println();

        System.out.println("Fibonacci numbers");
        System.out.println("The first 20 numbers in the Fibonacci series are");

        for (int i = 0; i < 20; i++) {
            System.out.print(fib(i));
            if (i < 19) { // to place commas after every result except last one as tasked
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println();


        System.out.println("Power of a number");
        System.out.print("Enter a positive integer x: ");
        int x = scanner.nextInt();
        System.out.print("Enter another positive integer: ");
        int p = scanner.nextInt();
        System.out.println(x + " to the power of " + p + " is " + power(x, p));
    }
}



