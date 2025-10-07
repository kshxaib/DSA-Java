public class DoubleLL {

    // Node class represents a single node in the doubly linked list
    public static class Node {
        int data;   // stores the data
        Node next;  // pointer to the next node
        Node prev;  // pointer to the previous node

        // Constructor to initialize a node
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Head points to the first node
    // Tail points to the last node
    // Size keeps count of total nodes
    public static Node head;
    public static Node tail;
    public static int size;

    // Add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        // Case 1: If list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Case 2: Link new node before head
        newNode.next = head;
        head.prev = newNode;
        head = newNode; // Move head to new node
    }

    // Add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        // Case 1: If list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Case 2: Link new node after tail
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode; // Move tail to new node
    }

    // Remove a node from the beginning of the list
    public void removeFirst() {
        if (size == 0) { // Empty list
            System.out.println("No nodes to remove.");
            return;
        } else if (size == 1) { // Only one node
            head = null;
            tail = null;
            size--;
            return;
        }

        // Move head to next node and break backward link
        head = head.next;
        head.prev = null;
        size--;
    }

    // Remove a node from the end of the list
    public void removeLast() {
        if (size == 0) { // Empty list
            System.out.println("No nodes to remove.");
            return;
        } else if (size == 1) { // Only one node
            head = null;
            tail = null;
            size--;
            return;
        }

        // Move tail to previous node and break forward link
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    // Reverse the doubly linked list
    public void reverseDLL() {
        Node curr = head;
        Node prev = null;
        Node next;

        // Traverse and swap next/prev pointers of each node
        while (curr != null) {
            next = curr.next;  // store next node
            curr.next = prev;  // reverse next pointer
            curr.prev = next;  // reverse prev pointer
            prev = curr;       // move prev one step ahead
            curr = next;       // move curr one step ahead
        }

        head = prev; // update head to new first node
    }

    // Print the doubly linked list
    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main function to test all operations
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();

        // Adding elements at the beginning
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        // Uncomment to test other operations
        // dll.removeFirst();
        // dll.addLast(4);
        // dll.removeLast();

        // Print list and size
        dll.printLL();
        System.out.println("Size of list: " + dll.size);

        // Reverse and print again
        dll.reverseDLL();
        dll.printLL();
    }
}

/*
Revision Notes:

Doubly Linked List (DLL):
- Each node has three parts: data, next (pointer to next node), and prev (pointer to previous node).
- Allows traversal in both forward and backward directions.

Operations:
1. addFirst(data): Inserts new node at the beginning.
2. addLast(data): Inserts new node at the end.
3. removeFirst(): Deletes the first node.
4. removeLast(): Deletes the last node.
5. reverseDLL(): Reverses the entire list.
6. printLL(): Prints all nodes.

Example Flow:
addFirst(3) → [3]
addFirst(2) → [2 <-> 3]
addFirst(1) → [1 <-> 2 <-> 3]
removeLast() → [1 <-> 2]

Time Complexity:
- addFirst, addLast, removeFirst, removeLast: O(1)
- reverseDLL, printLL: O(n)

Space Complexity: O(1)
*/
