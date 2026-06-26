class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode() {
            val = 0;
            next = null;
            prev = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
            prev = null;
        }

        ListNode(int data1, ListNode next1, ListNode prev1) {
            val = data1;
            next = next1;
            prev = prev1;
        }
    }

    public ListNode removeDuplicates(ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;

        while(pointer2 != null){
            if(pointer1.val == pointer2.val){
                pointer2 = pointer2.next;
            } else {
                pointer1.next = pointer2;
                pointer2.prev = pointer1;

                pointer1 = pointer1.next;
                pointer2 = pointer1.next;
            }
        }
        
        // Remove duplicates at the end
        pointer1.next = null;

        return head;
    }
}