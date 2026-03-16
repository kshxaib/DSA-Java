/*
        DELETE HEAD OF LINKED LIST

Problem:
Given the head of a singly linked list,
delete the first node (head) and return
the updated head of the list.


Example 1
Input: Linked List = [1, 2, 3]

Output: [2, 3]

Explanation:
The first node (1) is removed.


Example 2
Input: Linked List = [1]

Output: []

Explanation:
After deleting the only node,
the list becomes empty.


Core Idea

To delete the head:

Simply move the head pointer
to the next node.

Because head always points to
the first node of the list.


Visualization

Before deletion

head
 ↓
1 -> 2 -> 3 -> null


After deletion

head
 ↓
2 -> 3 -> null

Node with value 1 is removed.


Step-by-Step Algorithm

1. Check if list is empty.
2. If head == null → return null.
3. Move head to the next node.
4. Return updated head.


Time Complexity: O(1)
Only one pointer update.

Space Complexity: O(1)
No extra memory used.
*/

class Solution {

    public ListNode deleteHead(ListNode head) {

        // Case 1: Empty list
        if (head == null) {
            return null;
        }

        // Move head to next node
        head = head.next;

        return head;
    }
}

// Time Complexity  : O(1)
// Space Complexity : O(1)