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

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}


public ListNode reverseList(ListNode head) {
    Stack<Integer> st = new Stack<>();

    ListNode temp = head;

    while (temp != null) {
        st.push(temp.val);
        temp = temp.next;
    }

    temp = head;

    while (temp != null) {
        temp.val = st.pop();
        temp = temp.next;
    }

    return head;
}


public boolean hasCycle(ListNode head) {
    ListNode temp = head;
    Map<ListNode, Integer> map = new HashMap<>();

    while (temp != null) {
        if (map.containsKey(temp)) {
            return true;
        }

        map.put(temp, 1);
        temp = temp.next;
    }

    return false;
}