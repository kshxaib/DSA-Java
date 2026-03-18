/*
        REMOVE N-th NODE FROM END OF LINKED LIST

Definition:
Given the head of a singly linked list and an integer n,
remove the n-th node from the end of the list
and return the updated head.


Example 1
Input: head = [1, 2, 3, 4, 5], n = 2

Output: [1, 2, 3, 5]

Explanation:
2nd node from end is 4, so remove it.


Example 2
Input: head = [1], n = 1

Output: []

Explanation:
Only one node exists, so list becomes empty.

Core Idea:

1. Find length of list
2. Convert n-th from end → n-th from start
3. Traverse to previous node
4. Delete target node

This works correctly.


Formula
nthFromStart = (size - n) + 1

Example:

List: 1 -> 2 -> 3 -> 4 -> 5
size = 5
n = 2

nthFromStart = (5 - 2) + 1 = 4
So remove 4th node from start = 4


Time Complexity: O(n)
Explanation:
One pass to count O(n)
One pass to delete O(n)

Space Complexity: O(1)
No extra data structure used.
*/

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = 0;
        ListNode temp = head;

        // Step 1: Find length
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: Convert nth from end to nth from start
        int nthFromStart = (size - n) + 1;

        // Step 3: If head needs to be deleted
        if (nthFromStart == 1) {
            return head.next;
        }

        // Step 4: Move to previous node
        int count = 1;
        ListNode prev = head;

        while (count < nthFromStart - 1) {
            prev = prev.next;
            count++;
        }

        // Step 5: Delete target node
        prev.next = prev.next.next;

        return head;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)