/*
        PALINDROME LINKED LIST

Definition:
Given the head of a singly linked list,
return true if the linked list is a palindrome,
otherwise return false.

Palindrome means:
The sequence reads the same forward and backward.


Example 1
Input: [1, 2, 2, 1]

Output: true

Explanation:
Forward  = 1 -> 2 -> 2 -> 1
Backward = 1 -> 2 -> 2 -> 1


Example 2
Input: [1, 2]

Output: false

Explanation:
Forward  = 1 -> 2
Backward = 2 -> 1


Core Idea
To check palindrome in O(1) space:

1. Find the middle of the linked list
2. Reverse the second half
3. Compare first half and second half
4. If all values match → palindrome


Why This Works

A palindrome has symmetric values
from both ends.


Step-by-Step Algorithm

1. Initialize slow = head, fast = head
2. Find middle using slow/fast pointers
3. Reverse list from slow to end
4. Set:
      left = head
      right = reversed second half
5. Compare while right != null
6. If any mismatch → return false
7. Otherwise return true


Time Complexity: O(n)

Explanation:
• Find middle → O(n)
• Reverse second half → O(n)
• Compare halves → O(n)

Overall still O(n)


Space Complexity: O(1)

Only pointers used.
No extra array or stack.
*/

class Solution {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode curr = slow;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // Step 3: Compare both halves
        ListNode right = prev;
        ListNode left = head;

        while (right != null) {
            if (right.val != left.val) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)