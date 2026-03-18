class Solution {
    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                int count = 1;
                slow = slow.next;

                while(slow != fast){
                    slow = slow.next;
                    count++;
                }

                return count;
            }
        }

        return 0;
    }
}