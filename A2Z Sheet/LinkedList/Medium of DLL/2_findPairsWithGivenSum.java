class Solution {
    public List<List<Integer>> findPairsWithGivenSumBrute(ListNode head, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        ListNode temp1 = head;
        while(temp1 != null){
            ListNode temp2 = temp1.next;

            while(temp2 != null){
                int sum = temp1.val + temp2.val;

                if(sum == target){
                    ans.add(Arrays.asList(temp1.val, temp2.val));
                } else if(sum > target){
                    break;
                }

                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        return ans;
    }
}