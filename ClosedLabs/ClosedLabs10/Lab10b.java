/**
 * Lab10b.java
 *
 *   A program that asks the user for two lists of Strings and stores them in two separate
 *   ArrayLists.  The program then creates new lists consisting of the first two lists
 *   appended to each other in different orders. 
 *   Used to practice using ArrayLists and breaking code up into methods, and as a first
 *   step to implementing Lab12b.java - interleaving the lists in different ways.
 *
 * @author: Minrui(Wally) Yang
 * @version: 20161103
 */
import java.util.Scanner;
import java.util.ArrayList;


public class Lab10b {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();

        System.out.println("Enter the first wordlist:");
        list1 = getList(stdin);
        System.out.println("\nEnter the second wordlist:");
        list2 = getList(stdin);

        System.out.println("\nWordlist 1");
        System.out.println("----------");
        displayList(list1);

        System.out.println("\nWordlist 2");
        System.out.println("----------");
        displayList(list2);

        System.out.println("\nList 1 merged with List 2");
        System.out.println("-------------------------");
        displayList(mergeLists(list1, list2));

        System.out.println("\nList 2 merged with List 1");
        System.out.println("-------------------------");
        displayList(mergeLists(list2, list1));
    }

    // Given a Scanner as input creates a new empty list of Strings and then prompts the
    // user to enter Strings on the console.  If the string entered by the user is XXX or
    // xxx the method returns the list of Strings it created to the calling program.  Otherwise
    // it adds the String entered by the user to the end of its list and asks for another
    // String
    private static ArrayList<String> getList(Scanner inScanner) {
        ArrayList<String> list = new ArrayList<String>();

        System.out.print("Enter a word ('XXX' to quit): ");
        String str = inScanner.nextLine();
        while (!(str.equals("XXX") || str.equals("xxx"))) {
            list.add(str);
            System.out.print("Enter a word ('XXX' to quit): ");
            str = inScanner.nextLine();
        }
        return list;
    }

    // Given a ArrayList<String> object, display the contents of the list to the console.  The
    // list should be displayed as the index of the item in the list, followed by a colon
    // then by the item itself.
    private static void displayList(ArrayList<String> myList) {
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + ": " + myList.get(i));
        }
    }

    // Given two ArrayList<String> objects, create a new ArrayList<String> object that contains
    // duplicates of the Strings in the first list followed by duplicates of the Strings
    // in the second list.  The original ArrayList<String> objects should not be changed by
    // this method.
    private static ArrayList<String> appendLists(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < list1.size(); i++) {
            list.add(list1.get(i));
        }
        for (int i = 0; i < list2.size(); i++) {
            list.add(list2.get(i));
        }

        return list;
    }

    // Given two ArrayList<String> objects, create a new ArrayLlist<String> object that contains
    // two ArrayList and alternate between elements of list1 and lsit2, append the remaining elements
    // to the merged list.
    private static ArrayList<String> mergeLists(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> shorter;
        ArrayList<String> longer;

        if (list1.size() < list2.size()) {
            shorter = list1;
            longer = list2;
        }
        else {
            shorter = list2;
            longer = list1;
        }

        for (int i = 0; i < shorter.size(); i++) {
            list.add(list1.get(i));
            list.add(list2.get(i));
        }
        for (int i = shorter.size(); i < longer.size(); i++) {
            list.add(longer.get(i));
        }

        return list;
    }
}
