/*
        INSERT BEFORE HEAD (DOUBLY LINKED LIST)

Problem:
Given the head of a doubly linked list and a value X,
insert a new node with value X before the head.

Return the updated head.


Example 1
Input: head = [1, 2, 3]
X = 3

Output: [3, 1, 2, 3]

Explanation:
New node is inserted before 1.


Example 2
Input: head = [5]
X = 7

Output: [7, 5]


Core Idea

In doubly linked list, we must maintain
both next AND prev pointers.

Steps:

1. Create new node
2. Link new node → current head
3. Link current head → new node (prev)
4. Update head


Time Complexity: O(1)
No traversal required.

Space Complexity: O(1)
Only one node created.
*/

class Solution {

    public ListNode insertBeforeHead(ListNode head, int data) {

        // Step 1: Create new node
        ListNode newNode = new ListNode(data);

        // Step 2: If list is empty
        if (head == null) {
            return newNode;
        }

        // Step 3: Link new node with current head
        newNode.next = head;
        head.prev = newNode;

        // Step 4: Update head
        head = newNode;

        return head;
    }
}

// Time Complexity  : O(1)
// Space Complexity : O(1)