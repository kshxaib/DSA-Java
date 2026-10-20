class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(int i=0; i<lists.length; i++){
            ListNode temp = lists[i];
            if(temp != null){
                pq.add(temp);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            ListNode smallestNode = pq.remove();
            temp.next = smallestNode;
            temp = temp.next;

            if(smallestNode.next != null){
                pq.add(smallestNode.next);
            }
        }

        return dummy.next;
    }
}