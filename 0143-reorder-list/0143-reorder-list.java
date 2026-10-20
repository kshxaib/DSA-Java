class Solution {
    public void reorderList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode curr = head;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }

        int i=0, j=list.size() -1;
        int count = 0;
        curr = head;

        while(i <= j){
            int val;

            if(count % 2 == 0){
                val = list.get(i);
                i++;
            } else {
                val = list.get(j);
                j--;
            }

            curr.val = val;
            curr = curr.next;
            count++;
        }
    }
}