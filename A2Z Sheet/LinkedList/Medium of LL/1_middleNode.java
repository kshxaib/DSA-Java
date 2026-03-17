/*
        FIND MIDDLE OF LINKED LIST (TORTOISE & HARE)

Problem:
Given the head of a singly linked list,
return the middle node.

If there are two middle nodes,
return the SECOND middle node.


Example 1
Input: [1, 2, 3, 4, 5]

Output: [3, 4, 5]

Explanation:
Middle node = 3


Example 2
Input: [1, 2, 3, 4, 5, 6]

Output: [4, 5, 6]

Explanation:
Two middles = 3 and 4
Return SECOND → 4


Core Idea

Use TWO pointers:
1. Slow pointer → moves 1 step
2. Fast pointer → moves 2 steps

When fast reaches end,
slow will be at the middle.


Why It Works
Fast moves twice as fast as slow.

So when fast completes traversal,
slow has covered half distance → middle.


Visualization

List:
1 -> 2 -> 3 -> 4 -> 5

Step-by-step:
slow = 1, fast = 1
slow = 2, fast = 3  
slow = 3, fast = 5  
slow = 3 → middle


Even Case
1 -> 2 -> 3 -> 4 -> 5 -> 6

slow = 1, fast = 1
slow = 2, fast = 3  
slow = 3, fast = 5  
slow = 4, fast = null

Return slow = 4 (SECOND middle)


Time Complexity: O(n)
We traverse the list once.

Space Complexity: O(1)
No extra space used.
*/

class Solution {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)