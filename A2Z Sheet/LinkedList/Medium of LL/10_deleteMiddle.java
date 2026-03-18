/*
        DELETE MIDDLE NODE OF LINKED LIST

Definition:
Given the head of a singly linked list,
delete the middle node and return the updated head.

Middle definition:
Index = ⌊n / 2⌋ (0-based indexing)

Example 1
Input: [1, 3, 4, 7, 1, 2, 6]

Output:
[1, 3, 4, 1, 2, 6]

Explanation:
n = 7 → middle index = 3
Node = 7 → deleted


Example 2
Input: [1, 2, 3, 4]

Output:
[1, 2, 4]

Explanation:
n = 4 → middle index = 2
Node = 3 → deleted


Core Idea (Slow & Fast Pointer)

Use:
slow → moves 1 step  
fast → moves 2 steps  

Keep track of:
prev → node before slow

When fast reaches end,
slow will be at middle.


Why It Works

Fast pointer travels twice as fast.

So when fast finishes traversal,
slow reaches middle.

prev helps us delete slow node.


Time Complexity: O(n)
Single traversal of list.

Space Complexity: O(1)
Only pointers used.
*/

class Solution {

    public ListNode deleteMiddle(ListNode head) {

        // Edge case
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Find middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete middle node
        prev.next = slow.next;

        return head;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)