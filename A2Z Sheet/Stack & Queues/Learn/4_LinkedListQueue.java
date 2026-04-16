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

    private Node head; // front
    private Node tail; // rear

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    public void push(int x) {
        Node newNode = new Node(x);

        if(isEmpty()){
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow");
        }

        int val = head.data;
        head = head.next;

        // update tail when queue becomes empty
        if(head == null){
            tail = null;
        }

        return val;
    }

    public int peek() {
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow");
        }

        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

/*

*/