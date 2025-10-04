// Linked List implementation in Java
public class LinkedList {

    // Node class — represents a single element in the Linked List
    public static class Node {
        int data;     // stores actual data/value
        Node next;    // stores reference (address) of the next node

        // Constructor: initializes new node with given data
        public Node(int data) {
            this.data = data;
            this.next = null; // by default, next is null (end of list)
        }
    }

    // Head → points to the first node of the Linked List
    // Tail → points to the last node (whose next = null)
    public static Node head;
    public static Node tail;
    public static int size; // keeps track of total number of nodes

    // Add a new node at the **beginning** of the Linked List
    public void addFirst(int data){
        // Step 1: create new node
        Node newNode = new Node(data);
        size++;

        // If list is empty, both head and tail point to newNode
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }

        // Step 2: point newNode's next to current head
        newNode.next = head;

        // Step 3: make newNode the new head
        head = newNode;
    }

    // Add a new node at the **end** of the Linked List
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        // If list is empty, both head and tail point to newNode
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }

        // Step 2: connect current tail to newNode
        tail.next = newNode;

        // Step 3: update tail to newNode
        tail = newNode;
    }

    // Print all elements of the Linked List
    public void printLinkedList(){
        Node temp = head; // start from head
        while (temp != null) {
            System.out.print(temp.data + " -> "); // print data
            temp = temp.next; // move to next node
        }
        System.out.println("null"); // end of list
    }

    // Add a node at a specific position (middle)
    public void addInMiddle(int idx, int data){
        // If position is 0, add at first
        if(idx == 0){
            addFirst(data);
            return;
        }

        // Step 1: create new node
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0; 

        // Traverse to node before desired index
        while (i < idx-1) {
            temp = temp.next;
            i++;
        }

        // Step 2: connect newNode between temp and temp.next
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove the first node
    public void removeFirst(){
        if(size == 0){
            System.out.println("⚠️ No node in Linked List to remove.");
            return;
        } 
        else if(size == 1){
            // only one node
            head = null;
            tail = null;
            size--;
            return;
        }

        // Move head to the next node
        head = head.next;
        size--;
    }

    // Remove the last node
    public void removeLast(){
        if(size == 0){
            System.out.println("⚠️ No node in Linked List to remove.");
            return;
        } 
        else if(size == 1){
            head = null;
            tail = null;
            size--;
            return;
        }
        
        // Step 1: find 2nd last node (index = size - 2)
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        // Step 2: make it new tail
        prev.next = null;
        tail = prev;
        size--;
    }

    // Main method to test Linked List
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Add nodes
        ll.addFirst(2);
        ll.addFirst(1);     // List: 1 -> 2
        ll.addLast(4);
        ll.addLast(5);      // List: 1 -> 2 -> 4 -> 5
        ll.addInMiddle(2, 3); // Insert 3 at index 2 → 1 -> 2 -> 3 -> 4 -> 5

        // Remove nodes
        ll.removeFirst();   // Removes first node (1)
        ll.removeLast();    // Removes last node (5)

        // Print list and size
        ll.printLinkedList(); // Output: 2 -> 3 -> 4 -> null
        System.out.println("Size of Linked List: " + ll.size);
    }
}

/*
Revision Notes:

🔹 Linked List: A linear data structure where elements (nodes) are connected using pointers (references).
🔹 Node: contains `data` + `next` reference.
🔹 Head: points to first node.
🔹 Tail: points to last node (next = null).
🔹 Dynamic size — can easily grow/shrink.
🔹 Types:
   1. Singly Linked List — one direction (next only)
   2. Doubly Linked List — both next and previous links
   3. Circular Linked List — last node points to head

Common Operations:
1️⃣ addFirst() → Insert at beginning  
2️⃣ addLast() → Insert at end  
3️⃣ addInMiddle() → Insert at given index  
4️⃣ removeFirst() → Delete first node  
5️⃣ removeLast() → Delete last node  
6️⃣ printLinkedList() → Display all nodes
*/
