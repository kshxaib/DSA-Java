class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode zeroTail = zeroHead;
        ListNode oneTail = oneHead;
        ListNode twoTail = twoHead;

        ListNode temp = head;

        while(temp != null){
            ListNode nextNode = temp.next;
            temp.next = null;

            if(temp.data == 0){
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            } else if (temp.data == 1){
                oneTail.next = temp;
                oneTail = oneTail.next;
            } else {
                twoTail.next = temp;
                twoTail = twoTail.next;
            }

            temp = nextNode;
        }

        // connect 0-list
        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
        } else {
            zeroTail.next = twoHead.next;
        }

        // connect 1-list to 2-list
        oneTail.next = twoHead.next;

        return zeroHead.next;
    }
}