import java.util.LinkedList;

public class MergeSort {

    public static class Node {
        int data;   
        Node next;  

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;        
            fast = fast.next.next;   
        }

        return slow;
    }

    private Node merge(Node leftHalf, Node rightHalf) {
        Node mergedLL = new Node(-1);  
        Node temp = mergedLL;          

        while (leftHalf != null && rightHalf != null) {
            if (leftHalf.data <= rightHalf.data) {
                temp.next = leftHalf;
                leftHalf = leftHalf.next;
            } else {
                temp.next = rightHalf;
                rightHalf = rightHalf.next;
            }
            temp = temp.next;
        }

        while (leftHalf != null) {
            temp.next = leftHalf;
            leftHalf = leftHalf.next;
            temp = temp.next;
        }

        while (rightHalf != null) {
            temp.next = rightHalf;
            rightHalf = rightHalf.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

  
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;

        Node leftHalfSorted = mergeSort(head);
        Node rightHalfSorted = mergeSort(rightHead);

        Node fullSortedLL = merge(leftHalfSorted, rightHalfSorted);

        return fullSortedLL;
    }

    // Global head node
    public static Node head;

    public static void main(String[] args) {
        MergeSort list = new MergeSort();

        list.head = new Node(4);
        list.head.next = new Node(2);
        list.head.next.next = new Node(5);
        list.head.next.next.next = new Node(1);
        list.head.next.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(list.head);

        Node sortedHead = list.mergeSort(list.head);

        System.out.println("Sorted Linked List:");
        printList(sortedHead);
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

