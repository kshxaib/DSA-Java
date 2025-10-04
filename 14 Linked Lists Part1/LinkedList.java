// Linked List implementation
public class LinkedList {

    // Node class represents a single element (node) in the linked list
    public static class Node {
        int data;     // stores the actual data/value
        Node next;    // stores the reference (address) of the next node

        // Constructor to initialize a new node with given data
        public Node(int data) {
            this.data = data;
            this.next = null; // initially next is null (no next node yet)
        }
    }

    // Head points to the first node of the linked list
    // Tail points to the last node of the linked list
    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        // step1: create new node
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        // step2:
        newNode.next = head;
        // step3:
        head = newNode;
    }

    public void addLast(int data){
        // step1:
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        // step2:
        tail.next = newNode;
        // step3:
        tail = newNode;
    }

    public void printLinkedList(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        // Create a LinkedList object
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);

        ll.printLinkedList();
    }
}

/*
🔹 Notes:
- Head: The starting point of the linked list (first node).
- Tail: The last node in the linked list, whose 'next' is null.
- Each node contains data + reference to the next node.
- Linked List allows dynamic memory allocation (size can grow/shrink).
*/
