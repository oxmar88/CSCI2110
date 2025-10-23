// Omar Elsayed B00993452 lab4

import java.util.Scanner;

public class PrintQueueTest {
    private static void printHelp() { // method to display commands menu
        System.out.println("Commands:");
        System.out.println("  ADD owner jobId");
        System.out.println("  LIST");
        System.out.println("  RM jobId");
        System.out.println("  RMALL owner");
        System.out.println("  HELP");
        System.out.println("  QUIT");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PrintQueue queue = new PrintQueue();

        System.out.println("Print Queue Demo (type HELP for commands)");
        printHelp();

        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("QUIT")){
                System.out.println("BYE");
                break;
            }
            if (line.isEmpty()) { // skip empty lines
                continue;
            }

            // learnt how to use split from online source to break strings into parts like slicing in python
            // https://www.geeksforgeeks.org/java/split-string-java-examples/
            String[] parts = line.split("\\s+");
            String chosenCommand = parts[0].toUpperCase(); // all uppercase to guard against errors in mis-input

            if (chosenCommand.equals("ADD")) {
                if (parts.length == 3) {
                    String owner = parts[1];
                    int jobId = Integer.parseInt(parts[2]);
                    queue.lpr(owner, jobId);
                } else {
                    System.out.println("Invalid command");
                }
            }


            else if (chosenCommand.equals("LIST")) {
                queue.lpq();
            }


            else if (chosenCommand.equals("RM")) {
                if (parts.length == 2) {
                    int jobId = Integer.parseInt(parts[1]);
                    queue.lprm(jobId);
                } else {
                    System.out.println("Invalid command");
                }
            }


            else if (chosenCommand.equals("RMALL")) {
                if (parts.length == 2) {
                    String owner = parts[1];
                    queue.lprmAll(owner);
                } else {
                    System.out.println("Invalid command");
                }
            }


            else if (chosenCommand.equals("HELP")) {
                printHelp();
            }

        }

    }
}
