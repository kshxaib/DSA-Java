/*
        ADD TWO NUMBERS (LINKED LIST)

Definition:
You are given two non-empty linked lists
representing two non-negative integers.

Digits are stored in REVERSE order.

Each node contains one digit.

Return the sum as a linked list.


Important Note
Digits are stored in reverse order.

Example:

l1 = [2, 4, 3]
means number = 342

l2 = [5, 6, 4]
means number = 465

342 + 465 = 807

Output:
[7, 0, 8]

Because 807 in reverse order is:

7 -> 0 -> 8


Example 1

Input:
l1 = [2, 4, 3]
l2 = [5, 6, 4]

Output:
[7, 0, 8]


Example 2

Input:
l1 = [0]
l2 = [0]

Output:
[0]


Example 3

Input:
l1 = [9, 9, 9, 9, 9, 9, 9]
l2 = [9, 9, 9, 9]

Output:
[8, 9, 9, 9, 0, 0, 0, 1]


Core Idea

This is exactly like manual addition
from right to left.

Since digits are already stored in reverse order,
we can add nodes directly from head.

At every step:

sum = digit1 + digit2 + carry

Then:

digit to store = sum % 10
new carry      = sum / 10


Step-by-Step Algorithm

1. Create dummy node
2. Keep current pointer = dummy
3. Initialize carry = 0
4. Traverse while:
   l1 != null OR l2 != null OR carry != 0

5. Start sum = carry
6. If l1 exists, add l1.val
7. If l2 exists, add l2.val
8. Create new node with sum % 10
9. Update carry = sum / 10
10. Move current pointer forward
11. Return dummy.next


Time Complexity: O(max(n, m))
Where:
n = length of l1
m = length of l2
We traverse both lists once.

Space Complexity: O(max(n, m))
Because result linked list is created.
Auxiliary extra space excluding output = O(1)
*/

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }
}

// Time Complexity  : O(max(n, m))
// Space Complexity : O(max(n, m))