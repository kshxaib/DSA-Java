class Solution {
    public ListNode deleteHead(ListNode head) {

        // Case 1: Empty list
        if(head == null){
            return null;
        }

        // Move head to next node
        head = head.next;

        return head;
    }
}