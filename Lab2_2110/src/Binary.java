import java.util.*;

/*
Binary Number Generation
This class tests the code for Exercise3. It calls a method that accepts a positive integer n
and generates binary numbers between 0 and 2^n -1. The main method prints information about
running time.
*/

public class Binary {
    public static void main (String[]args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = scanner.nextInt();

        long startTime = System.currentTimeMillis();
        generateBinary(num);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("The execution time to generate binary numbers from 0 to " + (Math.pow(2, num)-1)+ " is "
                            + executionTime + " ms");

    }

    public static void generateBinary(int n){
        for (int i = 0; i < Math.pow(2, n); i++) {
            Integer.toBinaryString(i);
        }
    }
}
