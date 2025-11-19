// Omar Elsayed B00993452

import java.util.Scanner;

public class Exercise3 {
    public static void countDown(int n){
        if (n <= 0) { // changed == to <= to ensure we dont get negative numbers that can break the function
            System.out.print("BlastOff!");
            return;
        }

        System.out.print(n + " ");
        countDown(n-2); // to skip by 2 to keep it either odd or even depending on user input
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        countDown(n);
    }
}
