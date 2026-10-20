class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode head = lists[0];

        for (int i = 1; i < lists.length; i++) {
            head = mergeLL(head, lists[i]);
        }

        return head;
    }

    private ListNode mergeLL(ListNode firstLL, ListNode secondLL) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (firstLL != null && secondLL != null) {
            if (firstLL.val <= secondLL.val) {
                temp.next = firstLL;
                firstLL = firstLL.next;
            } else {
                temp.next = secondLL;
                secondLL = secondLL.next;
            }

            temp = temp.next;
        }

        if (firstLL != null) {
            temp.next = firstLL;
        }

        if (secondLL != null) {
            temp.next = secondLL;
        }

        return dummy.next;
    }
}