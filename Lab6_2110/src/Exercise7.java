// Omar Elsayed B00993452

import java.util.*;

public class Exercise7 {

    public static String reverseString(String str){

        if(str.length() <= 1){ // base case where there is no string or only one character
            return str;
        }

        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1)); // recursive case where last character + reverse of the rest
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String reversed = reverseString(input);
        System.out.println("Reversed string: " + reversed);
    }
}