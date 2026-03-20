class Solution {
    public ListNode flattenLinkedList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mergedHead = flattenLinkedList(head.next);
        return merge(head, mergedHead);
    }

    public ListNode merge(ListNode temp1, ListNode temp2){
        ListNode dummy = new ListNode(-1);
        ListNode dummyTemp = dummy;

        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                dummyTemp.child = new ListNode(temp1.val);
                temp1 = temp1.child;
            } else {
                dummyTemp.child = new ListNode(temp2.val);
                temp2 = temp2.child;
            }

            dummyTemp = dummyTemp.child;
        }

        while (temp1 != null) {
            dummyTemp.child = new ListNode(temp1.val);
            dummyTemp = dummyTemp.child;
            temp1 = temp1.child;
        }

        while (temp2 != null) {
            dummyTemp.child = new ListNode(temp2.val);
            dummyTemp = dummyTemp.child;
            temp2 = temp2.child;
        }

        return dummy.child;
    }
}


