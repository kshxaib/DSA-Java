/*
        DELETE HEAD OF DOUBLY LINKED LIST

Definition:
Given the head of a doubly linked list (DLL),
remove the first node and return the updated head.

Each node contains:
• data
• prev pointer
• next pointer


Example 1
Input: [1, 2, 3]

Output: [2, 3]

Explanation:
Node 1 is removed.


Example 2
Input: [7]

Output: []

Explanation:
Only one node → list becomes empty.


Core Idea

To delete head in DLL:
1. Move head to next node
2. Remove backward link (prev)


Time Complexity: O(1)
Only pointer updates.

Space Complexity: O(1)
No extra space used.
*/

class Solution {

    public ListNode deleteHead(ListNode head) {

        // Case 1: Empty or single node
        if (head == null || head.next == null) {
            return null;
        }

        // Step 1: Move head forward
        head = head.next;

        // Step 2: Remove backward link
        head.prev = null;

        return head;
    }
}

// Time Complexity  : O(1)
// Space Complexity : O(1)