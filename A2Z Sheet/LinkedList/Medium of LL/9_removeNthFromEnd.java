class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        int nthFromStart = (size - n) +1;

        if (nthFromStart == 1) {
            return head.next;
        }

        int count = 1;
        ListNode prev = head;
        
        while(count < nthFromStart -1){
            prev = prev.next;
            count++;
        }

        prev.next = prev.next.next;
        return head;
    }
}