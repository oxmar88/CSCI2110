import java.util.*;

public class CousinOfCollatzSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        long n = scanner.nextLong();

        while(n!= 0){
            long startTime = System.currentTimeMillis();
            long[] result = longestCousinCollatzSequence(n);
            long endTime = System.currentTimeMillis();

            long executionTime = endTime - startTime;

            System.out.println(n + " " + result[0] + " " + result[1] + " " + executionTime);

            n = scanner.nextLong(); // reading in the next number until 0 is entered
        }
    }

    public static long[] longestCousinCollatzSequence(long n){
        long longestLen = 0; //intialzing these values to give the longest length and start num before running algorithm
        long longestStart = 0;

        for(long i = 1; i <= n ; i++){ // start i at 1 as the collatz is for postive integers and starts at 1
            long currentStart = i;
            long length = 1;

            while (currentStart != 1){ // so when the number has not reached one / the end of the sequence

                if (currentStart % 2 == 0){ // if the number is even then num = num / 2
                    currentStart = currentStart / 2;

                }else if(currentStart %4 == 1){ // if odd and num mod 4 == 1 then num = num * 7 + 1
                    currentStart = currentStart * 7 + 1;

                }else{ // if odd and num mod 4 == 3 then num = num * 7 -1
                    currentStart = currentStart * 7 - 1;
                }
                length++;
            }

            if (length > longestLen){ // updating current number in sequence and new longest length if its applicable
                longestLen = length;
                longestStart = i;
            }
        }

        // since you cannot return 2 things in a method in java without a record I created an array with the two items I want returned
        long[] result = new long[2];
        result[0] = longestStart;
        result[1] = longestLen;
        return result;
    }

}