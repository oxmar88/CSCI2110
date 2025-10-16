import java.util.*;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number a number (n): ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        Random randomNum = new Random();
        for (int i =0; i <n ; i++){
            array[i] = randomNum.nextInt(0,n); // filling our array with random numbers as tasked (range: 0 to n - 1)
        }

        long startTime = System.currentTimeMillis();
        sort(array);
        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        System.out.print("Bubble sort of list where n (size) = " + n + " took " + executionTime + " ms");
    }

    public static int[] sort (int[] array){

        for (int k = 1 ; k < array.length ; k++){
            for (int i = 0 ; i < (array.length - k); i++){
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
}