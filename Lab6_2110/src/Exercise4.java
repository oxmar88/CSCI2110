// Omar Elsayed B00993452

import java.util.*;

public class Exercise4 {

    public static void multiples(int n, int m){
        if (m==0){ // as 0 has no multiples (base case)
            return;
        }

        multiples(n, m - 1); // to print out multiples in ascending order

        if (m > 1) { // to print out comma except last number
            System.out.print(", ");
        }

        System.out.print((n * m)); // printing multiples
    }

    public static void main (String args[]){
        Scanner scanner = new Scanner (System.in);

        System.out.print("Enter integer n: ");
        int n = scanner.nextInt();

        System.out.print("Enter integer m: ");
        int m = scanner.nextInt();

        System.out.println("First " + m + " multiples of the number " + n + ":");
        multiples(n,m);
    }
}
