// Omar Elsayed B00993452 lab4

import java.util.*;

public class GenericQueueTest {

    // created method as tasked to display queue in terminal
    private static <T> void display (GenericQueue<T> q){

        // rotating q by size(); deque , print then enqueue back in expected format
        int size = q.size();
        System.out.print("Queue: ");
        for(int i = 0; i < size; i++){
            T temp = q.dequeue();
            System.out.print(temp + " ");
            q.enqueue(temp);
        }

        System.out.println(); // for formatting
    }

    public static void main (String [] args){

        Scanner scanner = new Scanner (System.in);

        GenericQueue<String> qs = new GenericQueue<>();
        GenericQueue<Integer> qi = new GenericQueue<>();

        // STRINGS SECTION

        System.out.println("Enter strings to ENQUEUE (one per line). Blank line to finish:");

        // keep reading strings until user presses Enter on an empty line
        while(true){
            String line = scanner.nextLine();
            if (line.isEmpty()){
                break;
            }
            qs.enqueue(line);
        }

        System.out.println("Queue<String> size: " + qs.size());

        if (qs.isEmpty() == false){
            System.out.println("Peek<String>: " + qs.peek()); // only peek into queue and display element if not empty
            display(qs);
        }

        System.out.println("Enter a String to search with positionOf:");
        String search = scanner.nextLine();
        int position = qs.positionOf(search);
        if (position != -1){ // if elemnt is present in the queue ie : posistion is not -1 then print the index its found
            System.out.println("String " + search + " found in position " + position);
        }else {
            System.out.println("String " + search + " not found");
        }

        System.out.println("Enter a String to remove (first occurrence):");
        String removedString = scanner.nextLine();
        qs.remove(removedString);
        display(qs); // show queue at the end after operations are carried our

        if(qs.isEmpty() == false){ // if the queue is not empty remove 2 items checking after each dequeue
            System.out.println("Dequeuing twice:");
            System.out.println(qs.dequeue());
            if (qs.isEmpty() == false){
                System.out.println(qs.dequeue());
            }
        }
        display(qs);
        System.out.println("Queue<String> empty? " + qs.isEmpty());

        System.out.println(); // for formatting

        // INTEGER SECTION

        System.out.println("Enter integers to ENQUEUE (one per line). Blank line to finish:");

        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            int number = Integer.parseInt(line);
            qi.enqueue(number);
        }

        System.out.println("Queue<Integer> size: " + qi.size());

        if (qi.isEmpty() == false){
            System.out.println("Peek<Integer>: " + qi.peek());
            display(qi);
        }

        System.out.println("Enter an integer to search with positionOf:");
        String numberLine = scanner.nextLine();

        if (numberLine.isEmpty() == false){
            int searchNumber = Integer.parseInt(numberLine); // using parse as we are reading in a line intially
            int positionNumber = qi.positionOf(searchNumber);
            if (positionNumber != -1){
                System.out.println("Integer " + searchNumber + " found in position " + positionNumber);
            } else {
                System.out.println("Integer " + searchNumber + " not found");
            }
        }

        System.out.println("Enter an integer to remove (first occurrence):");
        String removeNumberLine = scanner.nextLine();
        int removeNumber = Integer.parseInt(removeNumberLine);
        qi.remove(removeNumber);
        display(qi);

        if (qi.isEmpty() == false){
            System.out.println("Dequeuing twice:");
            System.out.println(qi.dequeue());
            if (qi.isEmpty() == false){
                System.out.println(qi.dequeue());
            }
        }

        display(qi);

        System.out.println("Queue<Integer> empty? " + qi.isEmpty());
    }
}
