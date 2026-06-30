/*
        STACK USING LINKED LIST

Definition:
A Stack follows:

LIFO (Last In First Out)

Instead of array,
we use a Linked List.


Structure
Node:
• data
• next

Stack:
Top → head of linked list


Core Idea
• Insert at HEAD → push
• Remove from HEAD → pop

Why?
Because:
Linked List allows O(1) insert/delete at head


Operations
1. push(x)
2. pop()
3. top()
4. isEmpty()

Time Complexity:
push → O(1)  
pop → O(1)  
top → O(1)  

Space Complexity: O(n)
*/

class LinkedListStack {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedListStack() {
        head = null; // Stack is initially empty.
    }

    public void push(int x) {
        // Create a new node.
        Node newNode = new Node(x);

        // Insert at the beginning.
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        // Stack is empty.
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }

        // Remove the top node.
        int val = head.data;
        head = head.next;

        return val;
    }

    public int top() {
        // Stack is empty.
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }

        // Return top element.
        return head.data;
    }

    public boolean isEmpty() {
        // Stack is empty when head is null.
        return head == null;
    }
}