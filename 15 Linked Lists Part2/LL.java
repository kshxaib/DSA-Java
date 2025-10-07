// Importing the LinkedList class from java.util package
import java.util.LinkedList;

public class LL {
    public static void main(String[] args) {
        // Creating a LinkedList of Integer type
        LinkedList<Integer> ll = new LinkedList<>();

        // Add elements to the end of the list
        ll.addLast(1); // LinkedList: [1]
        ll.addLast(2); // LinkedList: [1, 2]

        // Add element to the beginning of the list
        ll.addFirst(0); // LinkedList: [0, 1, 2]

        // Remove the last element
        ll.removeLast(); // Removes 2 → LinkedList: [0, 1]

        // Remove the first element
        ll.removeFirst(); // Removes 0 → LinkedList: [1]

        // Print the final LinkedList
        System.out.println(ll); // Output: [1]
    }
}
