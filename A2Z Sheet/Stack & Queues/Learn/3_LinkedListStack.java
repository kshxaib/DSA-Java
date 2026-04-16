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
        if(isEmpty()){
            head = newNode;
        }

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

        int val = head.data;
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
