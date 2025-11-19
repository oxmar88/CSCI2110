// Omar Elsayed B00993452

import java.util.*;

public class Exercise2 {

    public static void countDown(int n){
        if (n == 0) { // when countdown reaches zero break out and unwind counter
            System.out.print("BlastOff!");
            return;
        }

        System.out.print(n + " "); // if its not zero print current count down number
        countDown(n-1); // call recursivley counting down
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        countDown(n);
    }

}
