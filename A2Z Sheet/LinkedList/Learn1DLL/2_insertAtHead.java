/*
        INSERTION AT HEAD OF LINKED LIST

Problem:
Given the head of a singly linked list and a value X,
insert a new node with value X at the beginning of the list.

Return the updated head.


Example 1
Input: Linked List = [1, 2, 3]
X = 7

Output: [7, 1, 2, 3]

Explanation:
7 becomes the new first node.


Example 2
Input: Linked List = []
X = 7

Output: [7]

Explanation:
List was empty, so the new node becomes head.


Core Idea

To insert at the head:
1. Create a new node.
2. Make its next pointer point to current head.
3. Update head to the new node.

This makes the new node the first node.


Visualization

Before insertion

head
 ↓
1 -> 2 -> 3 -> null


After inserting 7

head
 ↓
7 -> 1 -> 2 -> 3 -> null


Time Complexity: O(1)
Insertion happens at constant time.
No traversal required.

Space Complexity: O(1)
Only one new node created.
*/

class Solution {

    public ListNode insertAtHead(ListNode head, int X) {

        // Step 1: create new node
        ListNode newNode = new ListNode(X);

        // Step 2: link new node to current head
        newNode.next = head;

        // Step 3: update head
        head = newNode;

        // Step 4: return new head
        return head;
    }
}

// Time Complexity  : O(1)
// Space Complexity : O(1)