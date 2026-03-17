class Solution {
    public ListNode reverseDLL(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }
}
