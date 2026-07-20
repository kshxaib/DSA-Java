class Solution1 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Insert copied nodes between original nodes
        insertCopyInBetween(head);

        // Step 2: Connect random pointers of the copied nodes
        connectRandomPointers(head);

        // Step 3: Separate the copied list from the original list
        return extractCopiedList(head);
    }

    // Function to insert copied nodes between original nodes
    private void insertCopyInBetween(Node head) {
        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next;  // Store the next original node
            Node newNode = new Node(temp.val);  // Create a copy of the current node

            // Point the copied node's next to the next original node
            newNode.next = nextNode;

            // Insert the copied node after the original node
            temp.next = newNode;

            temp = nextNode;    // Move to the next original node
        }
    }

    // Function to connect random pointers of the copied nodes
    private void connectRandomPointers(Node head) {
        Node temp = head;

        while (temp != null) {
            Node copiedNextNode = temp.next;    // Access the copied node

            // If the original node has a random pointer
            if (temp.random != null) {

                // Connect the copied node's random pointer to the copied random node
                copiedNextNode.random = temp.random.next;

            } else {
                copiedNextNode.random = null;   // Otherwise point to null
            }

            temp = temp.next.next;  // Move to the next original node
        }
    }

    // Function to separate the copied list from the original linked list
    private Node extractCopiedList(Node head) {
        // Create a dummy node for the copied list
        Node dummy = new Node(-1);
        Node dTemp = dummy;

        Node temp = head;

        while (temp != null) {

            // Add copied node to the copied linked list
            dTemp.next = temp.next;
            dTemp = dTemp.next;

            // Restore the original linked list
            temp.next = temp.next.next;

            // Move to the next original node
            temp = temp.next;
        }

        // Return the head of the copied linked list
        return dummy.next;
    }
}