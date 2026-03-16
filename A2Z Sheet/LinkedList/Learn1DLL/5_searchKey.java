/*
        SEARCH IN LINKED LIST

Problem:
Given the head of a singly linked list and an integer key,
determine whether the key exists in the linked list.

Return:
true  → if key is present
false → if key is not present


Example 1
Input: head = [1, 2, 3, 4]
key = 3

Output: true

Explanation:
Linked list:
1 -> 2 -> 3 -> 4 -> null

The value 3 exists in the list.


Example 2
Input: head = [7, 8, 9, 10, 11]
key = 5

Output: false

Explanation:
5 is not present in the linked list.


Core Idea

Since linked lists do not support random access,
we must check nodes one by one.

This process is called traversal.

During traversal we compare each node value with the key.


Time Complexity: O(n)
Worst case:
We may need to traverse the entire list.

Space Complexity: O(1)
Only one pointer used.
*/

class Solution {

    public boolean searchKey(ListNode head, int key) {

        ListNode temp = head;

        while (temp != null) {

            if (temp.val == key) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)