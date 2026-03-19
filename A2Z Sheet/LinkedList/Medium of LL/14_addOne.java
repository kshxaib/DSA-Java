/*
        ADD ONE TO A NUMBER REPRESENTED BY LINKED LIST

Definition:
Given a singly linked list where each node
stores one digit of a number,
add 1 to the number and return the updated head.

Digits are stored in normal order:
leftmost digit comes first.

Example:
1 -> 2 -> 3  represents 123

After adding 1:
1 -> 2 -> 4


Example 1

Input:
1 -> 2 -> 3

Output:
1 -> 2 -> 4

Explanation:
123 + 1 = 124


Example 2

Input:
9 -> 9

Output:
1 -> 0 -> 0

Explanation:
99 + 1 = 100


Core Idea

Addition starts from the LAST digit,
but singly linked list gives access from the FRONT.

So we use recursion to go till the end first,
then come back while handling carry.

This is exactly how addition works manually
from right to left.


Why Recursion Works

For list:

1 -> 2 -> 9

Recursion goes to end:

9

Then while returning:

9 + 1 = 10
store 0, carry = 1

2 + 1 = 3
store 3, carry = 0

1 remains same

Final:
1 -> 3 -> 0


Time Complexity: O(n)
Each node is visited once.

Space Complexity: O(n)
Because recursion uses call stack.
*/

class Solution {
    public ListNode addOne(ListNode head) {

        int carry = helper(head);

        if (carry == 1) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }

        return head;
    }

    public int helper(ListNode temp) {

        if (temp == null) {
            return 1;
        }

        int carry = helper(temp.next);

        int val = temp.val + carry;

        if (val < 10) {
            temp.val = val;
            return 0;
        } else {
            temp.val = 0;
            return 1;
        }
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(n)   // due to recursion stack