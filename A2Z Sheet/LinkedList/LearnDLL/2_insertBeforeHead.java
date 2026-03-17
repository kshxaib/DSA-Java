class Solution {
    public ListNode insertBeforeHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data);

        if(head == null){
            head = newNode;
            return head;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return head;
    }
}