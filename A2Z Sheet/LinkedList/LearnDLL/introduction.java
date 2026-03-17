/*
        DOUBLY LINKED LIST – DELETION OPERATIONS

Definition:
A Doubly Linked List (DLL) is a linear data structure
where each node has:

1. Data
2. Pointer to next node
3. Pointer to previous node

Structure of Node

        Node
      -----------------
      | prev | data | next |
      -----------------

Example DLL
null <- 1 <-> 2 <-> 3 <-> 4 <-> 5 -> null

Head → first node
Tail → last node


Why Doubly Linked List?

Advantages over Singly LL:
• Can traverse in both directions
• Easier deletion (no need to track previous manually)

Disadvantages:
• Extra memory (prev pointer)
• More pointer handling → more chances of mistakes


Types of Deletions Covered
1. Delete First Node
2. Delete Last Node
3. Delete K-th Node


Time Complexities
Delete First   : O(1)
Delete Last    : O(n)
Delete K-th    : O(n)


Space Complexity: O(1)
*/

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
        if (head == null) return null;

        if (head.next == null) return null;

        head = head.next;
        head.prev = null;

        return head;
    }

    public static Node removeLast(Node head) {
        if (head == null) return null;

        if (head.next == null) return null;

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;

        return head;
    }

    public static Node removeKthNode(Node head, int k) {
        if (head == null) return null;

        Node temp = head;
        int count = 1;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if (temp == null) return head;

        // delete head
        if (temp.prev == null) {
            head = head.next;
            if (head != null) head.prev = null;
            return head;
        }

        // delete last
        if (temp.next == null) {
            temp.prev.next = null;
            return head;
        }

        // delete middle
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return head;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};

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