/*
Omar Elsayed (B00993452)
Prime Solution
This class tests the code for Exercise1. It calls a method to
calculate the nth prime and prints information about running time.
*/

import java.util.*;

public class Prime {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            long num = sc.nextLong();
            if (num == 0){
                break;
            }

            long startTime, endTime, executionTime;
            startTime = System.currentTimeMillis();

            long prime = nthPrime(num); // calling our method to find the nth prime number accordingly

            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            System.out.println(num + " " + prime + " " + executionTime);
        }

    }

    public static long nthPrime(long p) {
        int primeCounter = 0;
        for(int i = 2 ; ;i++){ // infinite for loop to keep counting up our prime number (can be stopped with break statement)
            boolean isPrime = true; // set initially to true as 2 is a prime number

            // checking if our number i is prime or not if so increment our counter
            for(int j = 2; j < i; j++){
                if(i%j ==0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime == true){
                primeCounter++;
            }

            /*
            * when our counter gets to p (desired prime it prints it out and stops counting u)
            */

            if(primeCounter == p){
                return i; // returning the value of the desired prime number
            }
        }

    }

}
