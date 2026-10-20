class Solution {
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();

        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int i = arr.size() - 1; i >= 0; i--) {
            curr.next = new ListNode(arr.get(i));
            curr = curr.next;
        }

        return dummy.next;
    }
}