/*
        LINKED LIST INTRODUCTION (SINGLY LINKED LIST)

Definition:
A Linked List is a linear data structure where elements
(nodes) are connected using pointers.

Each node contains:
1. Data
2. Reference to the next node

Structure of Node

        Node
      ---------
      | data  |
      | next  |
      ---------

Example Linked List

1 -> 2 -> 3 -> 4 -> 5 -> null

Head → first node
Tail → last node


Why Linked List?
Arrays Problems:
• Fixed size
• Costly insertion/deletion (shifting required)

Linked List Advantages:
• Dynamic size
• Easy insertion/deletion
• Memory allocated as needed


Types of Linked Lists

1. Singly Linked List
   node -> next

2. Doubly Linked List
   prev <- node -> next

3. Circular Linked List
   last node points to head


Time Complexities

Access element        : O(n)
Insert at beginning   : O(1)
Insert at end         : O(n) (O(1) if tail maintained)
Delete node           : O(n)


Key Terms (Interview Important)
Head
Pointer to first node.

Tail
Pointer to last node.

Traversal
Visiting each node one by one.

Node
Basic unit of linked list.


Code Explanation
Step 1 — Create Node class

Each node contains:
• data
• pointer to next node


Step 2 — Convert Array → Linked List
We create nodes for every element
and connect them using next pointer.

Example
arr = [1,2,3,4,5]

1 -> 2 -> 3 -> 4 -> 5 -> null


Step 3 — Traversal
Use a temporary pointer and move
until it becomes null.


Step 4 — Find Length
Traverse the list and count nodes.
*/

public class introduction {

    // Node structure
    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        // Array to Linked List
        int arr[] = {1, 2, 3, 4, 5};

        Node head = new Node(arr[0]);
        Node tail = head;

        for (int i = 1; i < arr.length; i++) {

            Node temp = new Node(arr[i]);
            tail.next = temp;
            tail = temp;
        }

        /*
            Linked List created

            head
             ↓
            1 -> 2 -> 3 -> 4 -> 5 -> null
        */

        // Traverse Linked List
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println("null");

        // Length of Linked List
        int size = 0;

        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        System.out.println("Length of Linked list is: " + size);
    }
}