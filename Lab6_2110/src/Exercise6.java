// Omar Elsayed B00993452

import java.util.*;

public class Exercise6 {
    public static int squares(int n){
        if(n==0){ // base case 1
            return 0;
        }

        if (n==1){ // base case 2
            return 1;
        }

        return n*n + squares(n-1); // add n^2 to the sum of squares from 1 to n-1 (n^2 == n*n)

    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        int result = squares(n);
        System.out.println("Sum of squares from 1 to " + n + " is " + result);
    }

}