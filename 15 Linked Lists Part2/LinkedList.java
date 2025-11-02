public class LinkedList {

    public static class Node {
        int data;  
        Node next; 

        public Node(int data) {
            this.data = data;
            this.next = null; 
        }
    }

    public static Node head;
    public static Node tail;

    public boolean isCycle() {
        Node slow = head; 
        Node fast = head; 

        while (fast != null && fast.next != null) {
            slow = slow.next;         
            fast = fast.next.next;    

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            System.out.println("❌ No cycle exists in the linked list.");
            return;
        }

        slow = head;
        Node prev = null; 

        while (slow != fast) {
            prev = fast;         
            slow = slow.next;    
            fast = fast.next;   
        }

        prev.next = null;
        System.out.println("✅ Cycle has been removed successfully.");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);

        head.next.next.next = temp;

        System.out.println("Cycle present before removal? " + ll.isCycle());

        ll.removeCycle();

        System.out.println("Cycle present after removal? " + ll.isCycle());
    }
}
