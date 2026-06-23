import java.util.*;

// Class representing a node in Doubly Linked List
class Node {
    // Stores data of the node
    int data;

    // Pointer to the next node
    Node next;

    // Pointer to the previous node
    Node prev;

    // Constructor when data, next and prev are provided
    Node(int data1, Node next1, Node prev1) {
        data = data1;
        next = next1;
        prev = prev1;
    }

    // Constructor when only data is provided
    Node(int data1) {
        data = data1;
        next = null;
        prev = null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Initializing an array to create nodes
        int[] arr = {2, 5, 8, 7};

        // Creating the head node of the doubly linked list
        Node head = new Node(arr[0]);

        // Printing the memory reference of head
        System.out.println(head);

        // Printing the data stored in head node
        System.out.println(head.data);
    }
}
