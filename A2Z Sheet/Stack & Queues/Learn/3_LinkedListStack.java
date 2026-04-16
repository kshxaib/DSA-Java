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

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedListStack() {
        head = null;
    }

    public void push(int x) {
        Node newNode = new Node(x);

        newNode.next = head;  
        head = newNode;
    }

    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("Stack Underflow");
        }

        int val = head.data;
        head = head.next;
        return val;
    }

    public int top() {
        if(isEmpty()){
            throw new RuntimeException("Stack Underflow");
        }

        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
