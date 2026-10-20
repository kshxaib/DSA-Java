class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<lists.length; i++){
            ListNode temp = lists[i];

            while(temp != null){
                list.add(temp.val);
                temp = temp.next;
            }
        }        

        Collections.sort(list);

        ListNode dummy = new ListNode(-1);
        ListNode dTemp = dummy;

        for(int i=0; i<list.size(); i++){
            dTemp.next = new ListNode(list.get(i));
            dTemp = dTemp.next;
        }

        return dummy.next;
    }
}