// 📘 Linked List implementation in Java
public class LinkedList {

    // Inner Node class — represents each element in the Linked List
    public static class Node {
        int data;     // stores actual data or value
        Node next;    // reference (address) to the next node

        // Constructor: creates a new node with given data
        public Node(int data) {
            this.data = data;
            this.next = null; // by default, no next node yet
        }
    }

    // Head → points to the first node in the Linked List
    // Tail → points to the last node (whose 'next' is null)
    public static Node head;
    public static Node tail;
    public static int size; // keeps track of total nodes in the list

    // Add a new node at the **beginning** of the Linked List
    public void addFirst(int data){
        Node newNode = new Node(data); // step 1: create new node
        size++;

        // if list is empty → head and tail are same
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }

        // Step 2: link new node to current head
        newNode.next = head;

        // Step 3: make newNode the new head
        head = newNode;
    }

    // Add a new node at the **end** of the Linked List
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        // If list is empty → head and tail are same
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }

        // Step 2: connect old tail to newNode
        tail.next = newNode;

        // Step 3: update tail to point to newNode
        tail = newNode;
    }

    // Print all elements in the Linked List
    public void printLinkedList(){
        Node temp = head; // temporary pointer starting at head
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next; // move to next node
        }
        System.out.println("null"); // last node reached
    }

    // Add a node at a specific index (in the middle)
    public void addInMiddle(int idx, int data){
        if(idx == 0){ // if position is 0 → same as addFirst()
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        // Traverse till node before the desired index
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // Insert between temp and temp.next
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove the first node
    public void removeFirst(){
        if(size == 0){
            System.out.println("⚠️ No node in Linked List to remove.");
            return;
        } else if(size == 1){ // only one element
            head = null;
            tail = null;
            size--;
            return;
        }

        // Move head pointer to next node
        head = head.next;
        size--;
    }

    // Remove the last node
    public void removeLast(){
        if(size == 0){
            System.out.println("⚠️ No node in Linked List to remove.");
            return;
        } else if(size == 1){ // only one node
            head = null;
            tail = null;
            size--;
            return;
        }

        // Step 1: move to second last node (index = size - 2)
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        // Step 2: disconnect last node and make prev the new tail
        prev.next = null;
        tail = prev;
        size--;
    }

    // Iterative Search — finds position of a key in Linked List
    public int performIterativeSearch(int key){
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if(temp.data == key){
                return index; // found key, return its position
            }
            temp = temp.next;
            index++;
        }

        return -1; // not found
    }

    // Recursive Search — uses recursion to find the index of a key
    public int performRecursiveSearch(Node head, int key) {
        // Base case: reached end (key not found)
        if (head == null) {
            return -1;
        }

        // Key found → return 0 (current node position)
        if (head.data == key) {
            return 0;
        }

        // Recursive case → search in rest of list
        int indexInRest = performRecursiveSearch(head.next, key);

        // If not found in rest, return -1
        if (indexInRest == -1) {
            return -1;
        }

        // Add +1 as we backtrack up the recursive calls
        return indexInRest + 1;
    }

    public void reverseLinkedList(){
        Node prev = null;
        Node current = head;
        tail = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void deleteNthNodeFromEnd(int n){
        int size = 0;
        Node temp = head;

        while(temp != null){
            temp = temp.next;
            size++;
        }

        if(n==size){
            head = head.next;
            return;
        }

        int i = 1;
        int indexToChangeNextPointer = size - n;
        Node prev = head;
        while (i < indexToChangeNextPointer) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public Node findMidNode(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //middle node
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Add nodes
        ll.addFirst(2);
        ll.addFirst(1);        // List → 1 -> 2
        ll.addLast(4);
        ll.addLast(5);         // List → 1 -> 2 -> 4 -> 5
        ll.addInMiddle(2, 3);  // Insert 3 at index 2 → 1 -> 2 -> 3 -> 4 -> 5

        // Remove nodes
        // ll.removeFirst();      // removes 1
        // ll.removeLast();       // removes 5

        // Print list and size
        ll.reverseLinkedList();
        ll.printLinkedList();  // Output → 2 -> 3 -> 4 -> null
        
        ll.deleteNthNodeFromEnd(3);
        
        System.out.println("Size of Linked List: " + ll.size);
        // Search examples
        System.out.println(ll.performIterativeSearch(3));     // Output → 1
        System.out.println(ll.performRecursiveSearch(head, 4)); // Output → 2
    }
}

/*
 Revision Notes:
🔹 Linked List:
   - A linear data structure made up of nodes connected by pointers.
   - Each node stores:
       ➤ data → value of the node
       ➤ next → reference to the next node

🔹 Important Terms:
   - Head → points to the first node
   - Tail → points to the last node (next = null)
   - Size → number of nodes in the list

🔹 Advantages:
    Dynamic size (can grow/shrink easily)
    Easy insertion and deletion (no shifting elements)

🔹 Disadvantages:
    Sequential access only (no random access like arrays)
    Extra memory for storing next references

🔹 Common Operations:
   ➤ addFirst() → Insert at beginning
   ➤ addLast() → Insert at end
   ➤ addInMiddle() → Insert at specific index
   ➤ removeFirst() → Delete first node
   ➤ removeLast() → Delete last node
   ➤ performIterativeSearch() → Find element by loop
   ➤ performRecursiveSearch() → Find element using recursion
   ➤ printLinkedList() → Display all nodes
*/
