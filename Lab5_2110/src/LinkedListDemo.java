// Omar Elsayed B00993452 Lab 5
import java.util.*;

public class LinkedListDemo{
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        System.out.println("Enter Pokemon names, one on each line");
        System.out.println("Enter quit to end");

        while(true){ // take input and place it in out linkedlist until user enters the string "quit"
            String input = scanner.nextLine();
            if( input.equalsIgnoreCase("quit")){
                break;
            }
            list.add(input);
        }

        System.out.println(); // for formatting

        System.out.println("Here is the linked list:");
        list.enumerate();

        System.out.println(); // for formatting
        System.out.println();

        System.out.println("Here is the linked list with even-numbered indices:");
        displayEven(list);

        System.out.println();

        System.out.println("Here is the linked list with odd-numbered indices:");
        displayOdd(list);

        System.out.println();

        System.out.println("Here is the reversed linked list:");
        LinkedList<String> reversedList = reverse(list);
        reversedList.enumerate();
        System.out.println();

        System.out.println();

        removeMiddle(list);
        System.out.println("After removing the middle node:");
        list.enumerate();
        System.out.println();
    }

    /**
     * method created to display all even indexed elements in out linked list
     */
    public static void displayEven(LinkedList<String> list){
        for(int i = 0; i < list.size(); i++){
            if( i % 2 == 0){ // only print those elements at an even index value
                System.out.print(list.getAt(i) + " ");
            }
        }
        System.out.println();
    }

    /**
     * method created to display all odd indexed elements in out linked list
     */
    public static void displayOdd(LinkedList<String> list){
        for (int i = 0; i < list.size(); i++){
            if( i % 2 != 0){ // only print those elements at an odd index value ( not == 0 when you mod 2 them)
                System.out.print(list.getAt(i) + " ");
            }
        }
        System.out.println();
    }

    /**
     * method created to return given linked list in reverse order
     */
    public static LinkedList<String> reverse (LinkedList<String> list){
        LinkedList<String> reversed = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            String element = list.getAt(i);
            reversed.add(element); // adding it the front of our new linked list reversed so elements are no in flipped order
        }
        return reversed;
    }

    /**
     * method created to remove the middle element in out linked list
     */
    public static void removeMiddle(LinkedList<String> list) {
        if (list.size() == 0) {
            return;
        }

        int middle = (list.size()-1) / 2; // to remove lower middle as shown in example in lab documentation
        list.removeAt(middle);
    }

}
