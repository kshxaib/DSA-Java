class Solution {
    public ListNode mergeKLists(ListNode[] lists) {        
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<lists.length; i++){
            ListNode temp = lists[i];

            while(temp != null){
                arr.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(arr);

        ListNode dummy = new ListNode(-1);
        ListNode dTemp = dummy;

        for(int i=0; i<arr.size(); i++){
            dTemp.next = new ListNode(arr.get(i));
            dTemp = dTemp.next;
        }

        return dummy.next;
    }
}