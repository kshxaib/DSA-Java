// Problem: Implement Queue using Linked List
/*
This program implements a Queue using a Linked List in Java.
A Queue works on the FIFO (First In, First Out) principle, 
where the first element added is the first one to be removed.

Operations supported:
1. add()   - Enqueue (insert) an element at the end of the queue.
2. remove() - Dequeue (remove) an element from the front of the queue.
3. peek()  - Get the front element without removing it.

Concept:
- A queue can be efficiently implemented using a linked list.
- Each node contains data and a reference to the next node.
- The queue keeps track of the front (head) and rear (tail).
*/

public class QueueUsingLL {

    // Node class represents a single element in the linked list
    public static class Node {
        int data;   // Value stored in the node
        Node next;  // Reference to the next node

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue class implements the queue operations using linked list
    public static class Queue {
        static Node head = null;  // Front of the queue
        static Node tail = null;  // Rear of the queue

        // Checks if the queue is empty
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // Adds (enqueues) an element to the end of the queue
        public static void add(int data) {
            Node newNode = new Node(data);

            // If the queue is empty, both head and tail point to new node
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }

            // Otherwise, attach new node at the end and update tail
            tail.next = newNode;
            tail = newNode;
        }

        // Removes (dequeues) an element from the front of the queue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove.");
                return -1;
            }

            int front = head.data;  // Store front value to return

            // If only one element exists, reset head and tail
            if (tail == head) {
                tail = null;
                head = null;
            } else {
                // Move head pointer to the next element
                head = head.next;
            }

            return front;
        }

        // Returns the front element without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }
            return head.data;
        }
    }

    // Main method to test queue operations
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Display elements while removing them
        while (!queue.isEmpty()) {
            System.out.println(queue.peek()); // Show front element
            queue.remove();                   // Remove front element
        }
    }
}

/*
Dry Run:
Queue: []

add(1) → [1]
add(2) → [1, 2]
add(3) → [1, 2, 3]
add(4) → [1, 2, 3, 4]
add(5) → [1, 2, 3, 4, 5]

peek() → 1 → remove() → [2, 3, 4, 5]
peek() → 2 → remove() → [3, 4, 5]
peek() → 3 → remove() → [4, 5]
peek() → 4 → remove() → [5]
peek() → 5 → remove() → []

Output:
1
2
3
4
5

Time Complexity:
add()   → O(1)
remove() → O(1)
peek()   → O(1)

Space Complexity: O(n)
*/  
