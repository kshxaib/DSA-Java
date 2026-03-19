class Solution {
    public ListNode addOne(ListNode head) {
        int carry = helper(head);
        if(carry == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }

        return head;
    }

    public int helper(ListNode temp){
        if(temp == null){
            return 1;
        }

        int carry = helper(temp.next);

        int val = temp.val + carry;
        if(val < 10){
            temp.val = val;
            return 0;            
        } else {
            temp.val = 0;
            return 1;
        }
    }
}


