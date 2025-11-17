//Omar Elsayed B00993452

import java.io.*;
import java.util.*;

public class Merge {

    public static <T extends Comparable<T>> OrderedList<T> merge (OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> L3 = new OrderedList<>(); // intializing a 3rd empty list to return

        // pointers to move through list1 and list 2
        int f1 = 0;
        int f2 = 0;

        while(f1 < list1.size() && f2 < list2.size()) {

            // to get item at our pointer position
            T item1 = list1.get(f1);
            T item2 = list2.get(f2);

            if (item1.compareTo(item2) < 0) { // if item pointed to by f1 comes first / is greater than then append to our list and move according pointer
                L3.add(item1);
                f1++;
            } else if (item2.compareTo(item1) < 0) { // if item pointed to by f2 comes first / is greater than then append to our list and move according pointer
                L3.add(item2);
                f2++;
            }else { // if they are equal take one of them and add them to list and move both pointers
                L3.add(item1);
                f1++;
                f2++;
            }
        }

        if (f1 == list1.size()){ // if list 1 is shorter than 2 add rest of list 2
            while (f2 < list2.size()) {
                L3.add(list2.get(f2));
                f2++;
            }
        }

        if (f2 == list2.size()){ // if list 2 is shorter than list 1 add rest of list 1
            while (f1 < list1.size()) {
                L3.add(list1.get(f1));
                f1++;
            }
        }

        return L3;
    }


    public static <T extends Comparable<T>> OrderedList<T> common (OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> L3 = new OrderedList<>();
        int f1 = 0;
        int f2 = 0;

        while(f1 < list1.size() && f2 < list2.size()){

            T item1 = list1.get(f1);
            T item2 = list2.get(f2);

            if(item1.compareTo(item2) < 0 ){ // if item1 is less than or smaller than item2 so they arent the same so move down list
                f1++;
            } else if (item2.compareTo(item1)< 0 ) { // if item2 is less than or smaller than item1 so they arent the same so move down list
                f2++;
            }else { // both are the same so add one of them to the list
                L3.add(item1);
                f1++;
                f2++;
            }
        }

        return L3;
    }


    public static <T extends Comparable<T>> OrderedList<T> difference (OrderedList<T> list1, OrderedList<T> list2){
        OrderedList<T> L3 = new OrderedList<>();
        int f1 = 0;
        int f2 = 0;

        while(f1 < list1.size() && f2 < list2.size()) {


            T item1 = list1.get(f1);
            T item2 = list2.get(f2);

            if (item1.compareTo(item2) < 0) { // this mean item 1 is different so add it
                L3.add(item1);
                f1++;
            } else if (item2.compareTo(item1) < 0) { // this mean item 2 < item 1 so skip it
                f2++;
            }else { // if item1 == item2 dont add it just move to next items
                f1++;
                f2++;
            }
        }

        // add leftover only from list1 (items still unmatched)
        while (f1 < list1.size()) {
            L3.add(list1.get(f1));
            f1++;
        }

        return L3;
    }

    public static void main (String args[]){
        Scanner scanner = new Scanner (System.in);

        try{
            ArrayList<String> namesList = new ArrayList<>(); // list of all names from random.txt
            File file = new File("UNI second year\\CSCI2110\\A4\\src\\RandomNames.txt"); // change this file paths when testing accordingly where you store RandomNames.txt
            Scanner fileScanner = new Scanner(file);

            while(fileScanner.hasNextLine()){ // read all lines till EOF and add to our list
                namesList.add(fileScanner.nextLine());
            }

            fileScanner.close();

            System.out.print("Enter n1 between 1000 and 1500: ");
            int n1 = scanner.nextInt();

            while (n1 < 1000 || n1 > 1500) { // make sure user stays within required number of names input
                System.out.print("Input not valid enter n1 between 1000 and 1500: ");
                n1 = scanner.nextInt();
            }

            Random rand = new Random(); // to be able to create a random number

            OrderedList<String> list1 = new OrderedList<>();

            while (list1.size() < n1) {
                String name = namesList.get(rand.nextInt(namesList.size())); // get a name randomly from namesList
                list1.insert(name); // uses insert method that has binary search called so maintains order of list and avoids duplicates
            }


            System.out.print("Enter n2 between 1000 and 1500: ");
            int n2 = scanner.nextInt();

            while (n2 < 1000 || n2 > 1500) {
                System.out.print("Input not valid enter n2 between 1000 and 1500: ");
                n2 = scanner.nextInt();
            }

            OrderedList<String> list2 = new OrderedList<>();

            while (list2.size() < n2) {
                String name = namesList.get(rand.nextInt(namesList.size()));
                list2.insert(name);
            }

            // Uses our methods to obtain data to write to files
            OrderedList<String> mergedList = merge(list1, list2);
            OrderedList<String> commonList = common(list1, list2);
            OrderedList<String> differenceList = difference(list1, list2);

            // Used helper method written below to Write to and create files automatically on each run
            // For following files make sure when running have the correct file path on machine for each file

            writeToFile("UNI second year\\CSCI2110\\A4\\src\\merged.txt", mergedList);
            writeToFile("UNI second year\\CSCI2110\\A4\\src\\common.txt", commonList);
            writeToFile("UNI second year\\CSCI2110\\A4\\src\\difference.txt", differenceList);

            System.out.println("Files created check the desired outputs in mergedList.txt,comm");

        } catch (Exception e) {
            System.out.println("RandomNames.txt read incorrectly or not read");
        }
    }

    // Helper method created to write to and create files
    public static <T extends Comparable<T>> void writeToFile(String fileName, OrderedList<T> list) throws Exception {
        PrintWriter printer = new PrintWriter(new FileWriter(fileName));
        for (int i = 0; i < list.size(); i++) {
            printer.println(list.get(i));
        }
        printer.close();
    }


}
