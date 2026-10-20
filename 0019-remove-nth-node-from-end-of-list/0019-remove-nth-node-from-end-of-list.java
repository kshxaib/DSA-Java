class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode dummy = head;

        ListNode curr = head;
        while(curr != null){
            list.add(curr);
            curr = curr.next;
        }                

        int removingIdx = list.size() - n;
        list.remove(removingIdx);

        dummy = new ListNode(-1);
        curr = dummy;
        for(int i=0; i<list.size(); i++){
            curr.next = list.get(i);
            curr = curr.next;
        }
        curr.next = null;

        return dummy.next;
    }
}