import java.util.*;

class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode prev;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

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

   
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        ListNode leftPointer = head;
        ListNode rightPointer = tail;

        while(leftPointer.val < rightPointer.val){
            int sum = leftPointer.val + rightPointer.val;

            if(sum == target){
                ans.add(Arrays.asList(leftPointer.val, rightPointer.val));
                leftPointer = leftPointer.next;
                rightPointer = rightPointer.next;
            } else if(sum < target) {
                leftPointer = leftPointer.next;
            } else {
                rightPointer = rightPointer.prev;
            }
        }

        return ans;
    }
}
