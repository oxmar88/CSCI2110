// Omar Elsayed
// B00993452

import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (n): ");
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

        System.out.print("Selection sort of list where n (size) = " + n + " took " + executionTime + " ms");
    }

    public static int[] sort(int[] array){
        int n = array.length;
        for(int i = 0; i<= n-1; i++){
            int minIndex = i; // assigning current index has the smallest element
            for(int j = i+1 ; j<= n-1 ; j++){ // inner loops finds index of smallest element in unsorted list
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[i]; // swapping the found smallest element with the first unsorted element
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}
