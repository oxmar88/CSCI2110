// Omar Elsayed B00993452
import java.util.*;

public class Exercise5 {

    public static void writeVertical(int n){
        if( n< 10){ // any number not divisbile by 10 is any num (0-9) which is a single number (base case)
            System.out.println(n); // print it out since its a single number
            return;
        }

        writeVertical(n / 10); // to extract the number without last digit
        System.out.println(n % 10); // print remainder / last digit of the number

    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();

        System.out.println("The number entered printed vertically: ");

        writeVertical(n);
    }
}
