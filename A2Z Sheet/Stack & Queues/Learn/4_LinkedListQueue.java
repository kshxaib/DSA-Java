/*
        QUEUE USING LINKED LIST

Definition:
A Queue follows:

FIFO (First In First Out)

Using Linked List:
• Insert at TAIL (rear)
• Remove from HEAD (front)


Structure
Node:
• data
• next

Queue:
head → front  
tail → rear  


Core Idea
• push → add at tail
• pop → remove from head
Both operations = O(1)


Operations

1. push(x)
2. pop()
3. peek()
4. isEmpty()


Time Complexity
push → O(1)  
pop → O(1)  
peek → O(1)  

Space Complexity: O(n)
*/

class LinkedListQueue {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Front of queue.
    private Node tail; // Rear of queue.

    public LinkedListQueue() {
        head = null;
        tail = null; // Queue is initially empty.
    }

    public void push(int x) {
        // Create a new node.
        Node newNode = new Node(x);

        // First element.
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Insert at rear.
        tail.next = newNode;
        tail = newNode;
    }

    public int pop() {
        // Queue is empty.
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        // Remove front element.
        int val = head.data;
        head = head.next;

        // Queue became empty.
        if (head == null) {
            tail = null;
        }

        return val;
    }

    public int peek() {
        // Queue is empty.
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        // Return front element.
        return head.data;
    }

    public boolean isEmpty() {
        // Queue is empty when head is null.
        return head == null;
    }
}

