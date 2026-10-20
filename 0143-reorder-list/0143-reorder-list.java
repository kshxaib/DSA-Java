class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }        

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode curr = secondHalf;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = prev;

        while(pointer2 != null){
            ListNode next1 = pointer1.next;
            ListNode next2 = pointer2.next;

            pointer1.next = pointer2;
            pointer2.next = next1;

            pointer1 = next1;
            pointer2 = next2;
        }
    }
}