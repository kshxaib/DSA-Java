/*
        REVERSE SINGLY LINKED LIST

Problem:
Given the head of a singly linked list,
reverse the list and return the new head.


Example 
Input: [1, 2, 3, 4, 5]

Output: [5, 4, 3, 2, 1]


Core Idea
We reverse the direction of links.

Instead of:
1 -> 2 -> 3 -> null

We make:
1 <- 2 <- 3 <- null


Key Concept
Each node points to the previous node.

So we need 3 pointers:
prev → previous node  
curr → current node  
next → store next node (important)


Time Complexity: O(n)
Each node visited once.

Space Complexity: O(1)
In-place reversal.
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;   // store next node
            curr.next = prev;   // reverse link

            prev = curr;        // move prev
            curr = next;        // move curr
        }

        head = prev;
        return head;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)