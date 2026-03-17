/*
        REVERSE DOUBLY LINKED LIST

Definition:
Given the head of a doubly linked list (DLL),
reverse the list in-place and return the new head.

Each node contains:
• data
• next pointer
• prev pointer


Example 1
Input: [10, 20, 30]

Output: [30, 20, 10]


Example 2
Input: [1, 3, 5, 7, 9]

Output: [9, 7, 5, 3, 1]


Core Idea

In DLL, each node has two pointers:
prev ← node → next

To reverse the list:
We simply swap next and prev for every node.


Time Complexity: O(n)
Traverse each node once.

Space Complexity: O(1)
In-place reversal.
*/

class Solution {

    public ListNode reverseDLL(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {

            next = curr.next;

            // reverse pointers
            curr.next = prev;
            curr.prev = next;

            // move forward
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)