class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode leftHalfSorted = sortList(head);
        ListNode rightHalfSorted = sortList(rightHead);

        ListNode sortedLL = merge(leftHalfSorted, rightHalfSorted);
        return sortedLL;
    }

    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge(ListNode leftHalf, ListNode rightHalf){
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        while(leftHalf != null && rightHalf != null){
            if(leftHalf.val <= rightHalf.val){
                temp.next = leftHalf;
                leftHalf = leftHalf.next;
            } else {
                temp.next = rightHalf;
                rightHalf = rightHalf.next;
            }
            temp = temp.next;
        }

        while (leftHalf != null) {
            temp.next = leftHalf;
            leftHalf = leftHalf.next;
            temp = temp.next;
        }

        while (rightHalf != null) {
            temp.next = rightHalf;
            rightHalf = rightHalf.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }
} 