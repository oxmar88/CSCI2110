// Omar Elsayed B00993452

import java.util.*;

public class Exercise8 {

    public static int countWays(int n) {

        // exactly at step 0 one valid way stay at the bottom
        if (n == 0) {
            return 1;
        }

        // there is  no valid way to climb
        if (n < 0) {
            return 0;
        }

        // since you can go up either 1,2 or 3 steps at a time so take all 3 into consideration (sum of ways from n-1, n-2a nd  n-3)
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of steps: ");
        int n = scanner.nextInt();

        int ways = countWays(n);

        System.out.println("the Number of ways to climb " + n + " steps: " + ways);
    }
}