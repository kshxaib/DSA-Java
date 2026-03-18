/*
        ODD EVEN LINKED LIST

Definition:
Given the head of a singly linked list,
group all nodes at odd indices first,
followed by all nodes at even indices.

IMPORTANT:
This is based on POSITION (index),
not node values.

1st node  → odd
2nd node  → even
3rd node  → odd
4th node  → even


Example 1
Input: [1, 2, 3, 4, 5]

Positions: 1  2  3  4  5

Odd index nodes  = 1, 3, 5
Even index nodes = 2, 4

Output: [1, 3, 5, 2, 4]


Example 2

Input: [2, 1, 3, 5, 6, 4, 7]

Positions: 1  2  3  4  5  6  7

Odd index nodes  = 2, 3, 6, 7
Even index nodes = 1, 5, 4

Output: [2, 3, 6, 7, 1, 5, 4]


Core Idea

Split the list into 2 chains:
1. Odd indexed nodes
2. Even indexed nodes

Then connect:

odd list tail -> even list head


Time Complexity: O(n)
Each node is visited once.

Space Complexity: O(1)
Only pointers used.
*/

class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)