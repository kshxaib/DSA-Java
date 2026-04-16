class LinkedListQueue {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; //front
    private Node tail; //rear

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
        return val;
    }

    public int peek() {
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow");
        }

        int val = head.data;
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
