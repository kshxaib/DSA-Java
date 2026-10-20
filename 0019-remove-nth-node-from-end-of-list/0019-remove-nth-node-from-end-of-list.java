class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pointer1 = dummy;        
        ListNode pointer2 = dummy;

        for(int i=0; i<n; i++){
            pointer2 = pointer2.next;
        }      

        while(pointer2.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        } 

        pointer1.next = pointer1.next.next;
        return dummy.next;
    }
}