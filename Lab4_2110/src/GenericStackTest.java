// Omar Elsayed B00993452 lab4

import java.util.Scanner;

public class GenericStackTest {
    public static void main(String[]args){

        Scanner scanner = new Scanner (System.in);

        GenericStack<String> stackS = new GenericStack<>();
        GenericStack<Integer> stackI = new GenericStack<>();

        // STRINGS SECTION

        System.out.println("Enter strings to PUSH (one per line). Press Enter on an empty line to finish: ");

        while(true){
            String line = scanner.nextLine();
            if(line.isEmpty()){ // to keep pushing in items until ENTER is pressed on an empty line
                break;
            }
            stackS.push(line);
        }

        System.out.println("Stack<String> size: " + stackS.size());

        if (stackS.isEmpty() == false){
            System.out.println("Peek<String>: " + stackS.peek());
        }

        System.out.println("Popping all String items (LIFO):");
        while(stackS.isEmpty() == false){
            System.out.print(stackS.pop() + " ");
        }

        System.out.println(); // for formatting purposes

        System.out.println("Stack<String> empty? " + stackS.isEmpty());

        System.out.println(); // for formatting purposes

        // INTEGERS SECTION

        System.out.println("Enter integers to PUSH (one per line). Press Enter on an empty line to finish: ");

        while(true){
            String line = scanner.nextLine();
            if(line.isEmpty()){
                break;
            }
            int number = Integer.parseInt(line); // parsing int as we read in a line which is a string type not int
            stackI.push(number);
        }

        System.out.println("Stack<Integer> size: " + stackI.size());

        if (stackI.isEmpty() == false){
            System.out.println("Peek<Integer>: " + stackI.peek());
        }

        System.out.println("Popping all Integer items (LIFO):");
        while(stackI.isEmpty() == false){
            System.out.print(stackI.pop() + " ");
        }

        System.out.println(); // for formatting purposes

        System.out.println("Stack<Integer> empty? " + stackI.isEmpty());
    }
}
