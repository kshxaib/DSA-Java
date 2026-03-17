/*
        REMOVE CYCLE IN LINKED LIST

Problem:
Given the head of a linked list that may contain a cycle,
remove the cycle and return the modified list.


Core Idea (Floyd’s Algorithm)
Step 1 → Detect cycle using slow & fast pointers  
Step 2 → Find starting node of cycle  
Step 3 → Break the cycle


Step 1 — Detect Cycle
Use two pointers:

slow → moves 1 step  
fast → moves 2 steps  

If they meet → cycle exists


Step 2 — Find Start of Cycle
After collision:

Move slow to head  
Keep fast at meeting point  

Move both one step at a time

Where they meet again = start of cycle


Step 3 — Break Cycle
We need the node BEFORE the start of cycle

So track:

prev = fast

Then:

prev.next = null


Step-by-Step Algorithm
1. Detect cycle using slow & fast
2. If no cycle → return head
3. Move slow to head
4. Move slow & fast one step
5. Track previous node of fast
6. When slow == fast:
      prev.next = null
*/

class Solution {

    public ListNode removeCycle(ListNode head) {

        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // Step 2: Find start of cycle
        slow = head;
        ListNode prev = null;

        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        // Step 3: Break cycle
        prev.next = null;

        return head;
    }
}