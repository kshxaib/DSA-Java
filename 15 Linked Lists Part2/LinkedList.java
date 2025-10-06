// Linked List class to demonstrate Floyd’s Cycle Detection Algorithm
public class LinkedList {

    // Node class represents each element in the linked list
    public static class Node {
        int data;  // value stored in the node
        Node next; // reference to the next node

        public Node(int data) {
            this.data = data;
            this.next = null; // next will be null when node is first created
        }
    }

    public static Node head;
    public static Node tail;

    /*
     * 🔹 Floyd’s Cycle Detection Algorithm (a.k.a. Tortoise and Hare Algorithm)
     * Used to detect whether a linked list contains a cycle (loop).
     *
     * Concept:
     * - Use two pointers: slow and fast.
     * - Move slow by 1 step and fast by 2 steps.
     * - If they ever meet, there is a cycle.
     * - If fast or fast.next becomes null → No cycle.
     */
    public boolean isCycle() {
        Node slow = head;  // moves one step at a time
        Node fast = head;  // moves two steps at a time

        // Continue traversing while fast and fast.next exist
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move by 1 step
            fast = fast.next.next;    // move by 2 steps

            // If slow and fast meet → cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If loop ends → no cycle found
        return false;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Create linked list nodes manually
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // Create a loop for testing
        head.next.next.next = head; // 3rd node points back to head → cycle created

        // Output: true (since cycle exists)
        System.out.println(ll.isCycle());
    }
}

/*
🧠 Revision Notes:

📌 What is a Cycle in Linked List?
- A cycle occurs when a node’s `next` pointer refers back to any previous node.
- This creates an infinite loop if traversed normally.

📌 Floyd’s Cycle Detection (Tortoise & Hare Algorithm)
1. Use two pointers: slow (moves 1 step), fast (moves 2 steps).
2. If at any point, slow == fast → cycle exists.
3. If fast or fast.next becomes null → no cycle.

📈 Time Complexity: O(n)
📉 Space Complexity: O(1) (No extra memory used)

✅ Used in:
- Detecting infinite loops in linked lists.
- Memory leak detection or pointer corruption.
*/
