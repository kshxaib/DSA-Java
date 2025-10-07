public class ZigZag {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;   
        }
        return slow;
    }

    public Node returnZigZagLL(Node head){
        Node mid = getMid(head);
        
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node headOfReversedHalf = prev;
        Node headOfleftHalf = head;

        Node nextLeft;
        Node nextRight;
        while(headOfleftHalf != null && headOfReversedHalf != null){
            nextLeft = headOfleftHalf.next;
            headOfleftHalf.next = headOfReversedHalf;
            nextRight = headOfReversedHalf.next;
            headOfReversedHalf.next = nextLeft;
            headOfleftHalf = nextLeft;
            headOfReversedHalf = nextRight;
        }
        return head;
    }

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
    list.head = new Node(1);
    list.head.next = new Node(2);
    list.head.next.next = new Node(3);
    list.head.next.next.next = new Node(4);
    list.head.next.next.next.next = new Node(5);
    list.head.next.next.next.next.next = new Node(6);

    System.out.println("ZigZag Linked List: ");
    head = list.returnZigZagLL(head);  
    printList(head);
}
}
