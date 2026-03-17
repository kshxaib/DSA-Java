public class introduction {

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

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node removeFirst(Node head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        head = head.next;
        head.prev = null;
        return head;
    }

    public static Node removeLast(Node head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
        return head;
    }

    public static Node removeKthNode(Node head, int k) {
        if (head == null)
            return null;

        Node temp = head;
        int count = 1;

        // move to kth node
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // if k is out of bounds
        if (temp == null)
            return head;

        // case 1: deleting head
        if (temp.prev == null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }

        // case 2: deleting last node
        if (temp.next == null) {
            temp.prev.next = null;
            return head;
        }

        // case 3: deleting middle node
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return head;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5 };

        Node head = new Node(arr[0]);
        Node tail = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        print(head);

        // remove first
        head = removeFirst(head);
        print(head);

        // remove last
        head = removeLast(head);
        print(head);
    }
}