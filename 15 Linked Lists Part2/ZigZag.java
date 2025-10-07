public class ZigZag {

    // Node class represents a single element of the linked list
    public static class Node {
        int data;  // stores value
        Node next; // reference to next node

        // Constructor to initialize node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head; // Head of linked list

    // Function to find the middle node of the linked list
    // Uses slow and fast pointer approach
    private Node getMid(Node head) {
        Node slow = head;        // moves 1 step at a time
        Node fast = head.next;   // moves 2 steps at a time

        // When fast reaches end, slow will point to middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;  // return middle node
    }

    // Function to rearrange linked list in ZigZag fashion
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

/*
Revision Notes:

ZigZag Linked List:
- Rearranges a linked list so that the first element is followed by the last,
  second by second-last, third by third-last, and so on.

Steps:
1. Find the middle node of the list using slow and fast pointers.
2. Reverse the second half of the list.
3. Merge the first half and reversed second half in alternate fashion.

Example:
Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6
Output: 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null

Time Complexity: O(n) - traverse list multiple times (finding mid, reversing, merging)
Space Complexity: O(1) - in-place rearrangement

Use Cases:
- Rearranging data in alternating high-low or zigzag pattern
- Interview question to test linked list manipulation skills
*/
