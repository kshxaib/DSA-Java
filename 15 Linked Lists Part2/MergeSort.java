import java.util.LinkedList;

public class MergeSort {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private Node merge(Node leftHalf, Node rightHalf){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (leftHalf != null && rightHalf != null) {
            if(leftHalf.data <= rightHalf.data){
                temp.next = leftHalf;
                temp = temp.next;
                leftHalf = leftHalf.next;
            } else {
                temp.next = rightHalf;
                temp = temp.next;
                rightHalf = rightHalf.next;
            }
        }

        while (leftHalf != null) {
            temp.next = leftHalf;
            temp = temp.next;
            leftHalf = leftHalf.next;
        }

        while (rightHalf != null) {
            temp.next = rightHalf;
            temp = temp.next;
            rightHalf = rightHalf.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //find mid
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node leftHalfSorted = mergeSort(head);
        Node rightHalfSorted = mergeSort(rightHead);

        Node fullSortedLL = merge(leftHalfSorted, rightHalfSorted);
        return fullSortedLL;
    }

    public static Node head;

    public static void main(String[] args) {
        
    }
}
