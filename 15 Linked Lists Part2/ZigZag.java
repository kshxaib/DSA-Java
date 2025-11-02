public class ZigZag {

    public static class Node {
        int data; 
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head; 

    private Node getMid(Node head) {
        Node slow = head;       
        Node fast = head.next;   

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; 
    }

    public Node returnZigZagLL(Node head) {
        // Step 1: Find middle of list
        Node mid = getMid(head);

        // Step 2: Reverse second half of the list
        Node prev = null;
        Node curr = mid.next;
        mid.next = null; // break the list into two halves
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node headOfReversedHalf = prev; // head of reversed second half
        Node headOfLeftHalf = head;     // head of first half

        // Step 3: Merge two halves in ZigZag manner
        Node nextLeft;
        Node nextRight;
        while (headOfLeftHalf != null && headOfReversedHalf != null) {
            nextLeft = headOfLeftHalf.next;          // store next node of left half
            headOfLeftHalf.next = headOfReversedHalf; // link left node to right node
            nextRight = headOfReversedHalf.next;     // store next node of right half
            headOfReversedHalf.next = nextLeft;      // link right node to next left node
            headOfLeftHalf = nextLeft;               // move to next left node
            headOfReversedHalf = nextRight;          // move to next right node
        }

        return head; // return new head of ZigZag linked list
    }

    // Helper function to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ZigZag list = new ZigZag();

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);

        System.out.println("ZigZag Linked List: ");

        // Rearrange list in ZigZag pattern
        head = list.returnZigZagLL(head);

        // Print the final ZigZag linked list
        printList(head);
    }
}
