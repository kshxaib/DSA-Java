class Solution {
    public ListNode deleteHead(ListNode head) {

        if(head == null || head.next == null) {
            return null;
        }

        head = head.next;
        head.prev = null;

        return head;
    }
}