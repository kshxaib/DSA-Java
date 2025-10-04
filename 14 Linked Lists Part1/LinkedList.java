// Linked List implementation in Java
public class LinkedList {

    // Node class represents a single element (node) of the Linked List
    public static class Node {
        int data;     // stores the actual value
        Node next;    // reference (address) of the next node

        // Constructor: creates a new node with given data
        public Node(int data) {
            this.data = data;
            this.next = null; // next is null when node is newly created
        }
    }

    // Head points to the first node of the list
    public static Node head;
    // Tail points to the last node of the list (whose next is null)
    public static Node tail;
    // stores total number of nodes in the list
    public static int size;

    // Add a new node at the beginning of the Linked List
    public void addFirst(int data) {
        Node newNode = new Node(data); // create new node
        size++;

        // if list is empty, both head and tail will point to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // link new node to the current head
        newNode.next = head;

        // make new node the new head
        head = newNode;
    }

    // Add a new node at the end of the Linked List
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        // if list is empty, both head and tail will point to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // connect current tail to the new node
        tail.next = newNode;

        // update tail to new node
        tail = newNode;
    }

    // Print all nodes of the Linked List
    public void printLinkedList() {
        Node temp = head; // start from head

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next; // move to the next node
        }

        System.out.println("null"); // end of list
    }

    // Add a node at a specific index (in the middle)
    public void addInMiddle(int idx, int data) {
        // if position is 0, same as addFirst
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        // traverse till the node before the desired index
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // insert new node between temp and temp.next
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove the first node from the Linked List
    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty.");
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }

        // move head to next node
        head = head.next;
        size--;
    }

    // Remove the last node from the Linked List
    public void removeLast() {
        if (size == 0) {
            System.out.println("List is empty.");
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }

        // traverse to the second last node
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        // remove last node by setting next to null
        prev.next = null;
        tail = prev;
        size--;
    }

    // Iterative search: find position of a key in the list
    public int performIterativeSearch(int key) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data == key) {
                return index; // key found
            }
            temp = temp.next;
            index++;
        }

        return -1; // key not found
    }

    // Recursive search: find index of key using recursion
    public int performRecursiveSearch(Node head, int key) {
        // base case: reached end of list
        if (head == null) {
            return -1;
        }

        // key found at current node
        if (head.data == key) {
            return 0;
        }

        // search in the remaining list
        int indexInRest = performRecursiveSearch(head.next, key);

        // if key not found in rest
        if (indexInRest == -1) {
            return -1;
        }

        // add 1 while returning back through recursive calls
        return indexInRest + 1;
    }

    // Reverse the Linked List
    public void reverseLinkedList() {
        Node prev = null;
        Node current = head;
        tail = head; // old head becomes tail
        Node next;

        while (current != null) {
            next = current.next;   // store next node
            current.next = prev;   // reverse link
            prev = current;        // move prev one step ahead
            current = next;        // move current one step ahead
        }

        head = prev; // new head is the last processed node
    }

    // Delete the nth node from the end of the list
    public void deleteNthNodeFromEnd(int n) {
        int size = 0;
        Node temp = head;

        // find total size
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // if first node is to be deleted
        if (n == size) {
            head = head.next;
            return;
        }

        int i = 1;
        int indexToChangeNextPointer = size - n;
        Node prev = head;

        // reach the (size - n)th node
        while (i < indexToChangeNextPointer) {
            prev = prev.next;
            i++;
        }

        // remove the nth node from end
        prev.next = prev.next.next;
    }

    // Find middle node of the Linked List using slow and fast pointers
    public Node findMidNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // move by 1
            fast = fast.next.next;  // move by 2
        }

        return slow; // middle node
    }

    // Check if the Linked List is a palindrome
    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: find mid node
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: reverse second half of the list
        Node prev = null;
        Node curr = slow;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;  // head of reversed second half
        Node left = head;   // head of first half

        // Step 3: compare both halves
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Add nodes
        ll.addFirst(2);
        ll.addFirst(1);        // List → 1 -> 2
        ll.addLast(2);
        ll.addLast(1);         // List → 1 -> 2 -> 4 -> 5
        ll.addInMiddle(2, 3);  // Insert 3 at index 2 → 1 -> 2 -> 3 -> 4 -> 5

        // Remove nodes
        // ll.removeFirst();      // removes first node (1)
        // ll.removeLast();       // removes last node (5)

        // Print list and size
        ll.printLinkedList();  // Output → 1 -> 2 -> 3 -> 2 -> 1 -> null

        // Reverse the list
        // ll.reverseLinkedList();
        // ll.printLinkedList();

        // Delete nth node from end
        // ll.deleteNthNodeFromEnd(3);

        // System.out.println("Size of Linked List: " + ll.size);

        // Search examples
        // System.out.println(ll.performIterativeSearch(3));     // Output → index
        // System.out.println(ll.performRecursiveSearch(head, 4)); // Output → index

        // Check palindrome
        System.out.println("Is Palindrome? " + ll.checkPalindrome());
    }
}

/*
Revision Notes:

Linked List:
- A linear data structure made of nodes connected using pointers.
- Each node has:
    data  -> value stored in the node
    next  -> reference (address) of the next node

Terms:
- Head: first node of the list
- Tail: last node of the list (next = null)
- Size: number of nodes

Advantages:
- Dynamic size (can easily grow or shrink)
- Insertion and deletion are efficient (no shifting like arrays)

Disadvantages:
- No random access (must traverse from start)
- Uses extra memory for next references

Common Operations:
- addFirst()              -> insert at beginning
- addLast()               -> insert at end
- addInMiddle()           -> insert at specific index
- removeFirst()           -> delete first node
- removeLast()            -> delete last node
- performIterativeSearch() -> find element using loop
- performRecursiveSearch() -> find element using recursion
- reverseLinkedList()     -> reverse the entire list
- deleteNthNodeFromEnd()  -> remove nth node from the end
- findMidNode()           -> get the middle node
- checkPalindrome()       -> check if list is palindrome
*/
