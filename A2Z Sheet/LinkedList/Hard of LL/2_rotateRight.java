class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head;
        int size = 1;

        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        k = k % size;
        if (k == 0) return head;

        int n = size - k;
        ListNode temp = head;
        int count = 1;
        while(temp != null && count < n){
            temp = temp.next;
            count++;
        }

        tail.next = head;
        head = temp.next;
        temp.next = null;

        return head;
    }
}