public class DoubleLL {

    // Node class represents a single node in the doubly linked list
    public static class Node {
        int data;   // stores data
        Node next;  // points to next node
        Node prev;  // points to previous node

        // Constructor to initialize node
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Head -> first node of list
    // Tail -> last node of list
    // Size -> total nodes in list
    public static Node head;
    public static Node tail;
    public static int size;

    // Add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        // If list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Link new node with current head
        newNode.next = head;
        head.prev = newNode;
        head = newNode; // Move head to new node
    }

    // Add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        // If list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Link new node after tail
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode; // Move tail to new node
    }

    // Remove a node from the beginning of the list
    public void removeFirst() {
        if (size == 0) { // No nodes to remove
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
        if (size == 0) { // No nodes to remove
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

    // Print the doubly linked list
    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();

        // Adding elements at beginning
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        // Uncomment to test other operations
        // dll.removeFirst(); 
        // dll.addLast(4);
        dll.removeLast();

        // Print final list and its size
        dll.printLL();
        System.out.println("Size of list: " + dll.size);
    }
}

/*
Revision Notes:

Doubly Linked List (DLL):
- Each node has 3 parts: data, next (pointer to next node), and prev (pointer to previous node).
- Allows traversal in both directions (forward and backward).

Operations:
1. addFirst(data): Inserts new node at beginning.
2. addLast(data): Inserts new node at end.
3. removeFirst(): Removes first node.
4. removeLast(): Removes last node.
5. printLL(): Displays the linked list.

Example Flow:
addFirst(3) -> [3]
addFirst(2) -> [2 <-> 3]
addFirst(1) -> [1 <-> 2 <-> 3]
removeLast() -> [1 <-> 2]

Time Complexity:
- addFirst / addLast / removeFirst / removeLast: O(1)
- printLL: O(n)

Space Complexity: O(1)
*/
