/*
        DETECT CYCLE IN LINKED LIST (FLOYD'S ALGORITHM)

Problem:
Given the head of a singly linked list,
determine if the list contains a cycle.

Return:
true  → if cycle exists
false → if no cycle


What is a Cycle?
A cycle exists if a node points back
to a previous node instead of null.

Example:

1 -> 2 -> 3 -> 4
          ↑     ↓
          ← ← ←


Core Idea (Tortoise & Hare)

Use TWO pointers:
1. Slow pointer → moves 1 step
2. Fast pointer → moves 2 steps

If a cycle exists:
they will eventually meet.

If no cycle:
fast will reach null.


Why It Works
• Fast moves faster than slow
• In a loop, fast will "lap" slow
• So they must collide at some point


Time Complexity:O(n)
At most one full traversal.

Space Complexity: O(1)
No extra memory used.
*/

class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)