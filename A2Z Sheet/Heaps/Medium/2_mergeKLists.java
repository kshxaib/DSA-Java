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


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = lists[0];

        for(int i = 1; i < lists.length; i++) {
            head = merge(head, lists[i]);
        }

        return head;
    }

    public ListNode merge(ListNode firstL, ListNode secondL) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(firstL != null && secondL != null) {
            if(firstL.val <= secondL.val) {
                temp.next = firstL;
                firstL = firstL.next;
            } else {
                temp.next = secondL;
                secondL = secondL.next;
            }

            temp = temp.next;
        }

        if(firstL != null) {
            temp.next = firstL;
        }

        if(secondL != null) {
            temp.next = secondL;
        }

        return dummy.next;
    }
}