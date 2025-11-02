public class DoubleLL {

    public static class Node {
        int data;   
        Node next;  
        Node prev;  

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode; 
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode; 
    }

    public void removeFirst() {
        if (size == 0) { 
            System.out.println("No nodes to remove.");
            return;
        } else if (size == 1) { 
            head = null;
            tail = null;
            size--;
            return;
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast() {
        if (size == 0) { 
            System.out.println("No nodes to remove.");
            return;
        } else if (size == 1) { 
            head = null;
            tail = null;
            size--;
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void reverseDLL() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;  // store next node
            curr.next = prev;  // reverse next pointer
            curr.prev = next;  // reverse prev pointer
            prev = curr;       // move prev one step ahead
            curr = next;       // move curr one step ahead
        }

        head = prev; // update head to new first node
    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();

        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        dll.removeFirst();
        dll.addLast(4);
        dll.removeLast();

        dll.printLL();
        System.out.println("Size of list: " + dll.size);

        dll.reverseDLL();
        dll.printLL();
    }
}

