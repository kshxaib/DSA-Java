// Linked List class to demonstrate Floyd’s Cycle Detection and Removal Algorithm
public class LinkedList {

    // Node class represents each element in the linked list
    public static class Node {
        int data;  // value stored in the node
        Node next; // reference (address) of the next node

        // Constructor: initializes a new node with given data
        public Node(int data) {
            this.data = data;
            this.next = null; // when node is created, next is null by default
        }
    }

    public static Node head;
    public static Node tail;

    /*
     * 🔹 Floyd’s Cycle Detection Algorithm (Tortoise & Hare Algorithm)
     * Purpose: Detects if the linked list has a cycle (loop).
     *
     * Logic:
     * - Use two pointers (slow and fast).
     * - Move 'slow' by one step and 'fast' by two steps.
     * - If they ever meet, a cycle exists.
     * - If 'fast' or 'fast.next' becomes null, the list has no cycle.
     */
    public boolean isCycle() {
        Node slow = head;  // moves 1 step each time
        Node fast = head;  // moves 2 steps each time

        // Traverse until the end or until pointers meet
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move slow pointer
            fast = fast.next.next;    // move fast pointer

            // If both pointers meet at some node, cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If loop completes without meeting → no cycle found
        return false;
    }

    /*
     * 🔹 Remove Cycle from Linked List
     * This function detects a cycle (if any) and removes it.
     *
     * Steps:
     * 1️⃣ Use Floyd’s algorithm to check if a cycle exists.
     * 2️⃣ If found, reset 'slow' to 'head' and move both slow & fast by one step.
     * 3️⃣ Keep track of 'prev' (previous node of fast).
     * 4️⃣ When slow == fast → it's the starting point of the cycle.
     * 5️⃣ Set prev.next = null to break the loop.
     */
    public void removeCycle() {
        // Step 1: Detect cycle using Floyd’s algorithm
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If both pointers meet, cycle detected
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        // Step 2: If no cycle exists
        if (!isCycle) {
            System.out.println("❌ No cycle exists in the linked list.");
            return;
        }

        // Step 3: Move slow to head to find starting point of cycle
        slow = head;
        Node prev = null; // to store the node before fast

        // Move slow and fast one step at a time until they meet again
        while (slow != fast) {
            prev = fast;         // keep track of the previous node
            slow = slow.next;    // move slow by 1
            fast = fast.next;    // move fast by 1
        }

        // Step 4: Break the cycle (set last node's next to null)
        prev.next = null;
        System.out.println("✅ Cycle has been removed successfully.");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Manually creating nodes
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);

        // Creating a cycle for testing → 3rd node points back to 2nd node
        head.next.next.next = temp;

        // Check if cycle exists
        System.out.println("Cycle present before removal? " + ll.isCycle());

        // Remove the cycle
        ll.removeCycle();

        // Check again after removal
        System.out.println("Cycle present after removal? " + ll.isCycle());
    }
}

/*
🧠 REVISION NOTES:

📌 What is a Cycle in Linked List?
- A cycle (or loop) occurs when a node’s 'next' points back to a previous node.
- Causes infinite traversal (never reaches null).

📌 Floyd’s Cycle Detection (Tortoise & Hare)
1. Use two pointers:
   → slow = moves 1 step
   → fast = moves 2 steps
2. If slow == fast → cycle exists.
3. If fast == null or fast.next == null → no cycle.

📌 Cycle Removal Steps:
1. Detect cycle using Floyd’s Algorithm.
2. Reset 'slow' to 'head'.
3. Move both slow & fast by one step until they meet → start of cycle.
4. Keep a 'prev' pointer to fast, then set prev.next = null → removes cycle.

📈 Time Complexity: O(n)
📉 Space Complexity: O(1)

✅ Used in:
- Detecting and removing infinite loops in linked lists.
- Avoiding crashes or infinite execution due to circular references.
*/
