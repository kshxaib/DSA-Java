/*
        SORT A LINKED LIST OF 0's, 1's AND 2's

Definition:
Given the head of a singly linked list
containing only 0, 1 and 2,
sort the linked list in ascending order.

IMPORTANT:
Do it by changing links,
not by creating new actual data nodes.


Example 
Input:
[1, 0, 2, 0, 1]

Output:
[0, 0, 1, 1, 2]


Core Idea

Since values are only:
0, 1, 2

We do NOT need merge sort.

We can create 3 separate lists:
1. zero list
2. one list
3. two list

Then connect them in order:
zero list -> one list -> two list


Why This Works
Instead of sorting generally,
we group nodes by value.

This is like Dutch National Flag logic,
but for linked list using pointers.


Visualization

Original:

1 -> 0 -> 2 -> 0 -> 1

After grouping:

Zero list:
0 -> 0

One list:
1 -> 1

Two list:
2

After connecting:

0 -> 0 -> 1 -> 1 -> 2


Step-by-Step Algorithm

1. Create 3 dummy heads:
   zeroHead, oneHead, twoHead

2. Maintain 3 tail pointers:
   zeroTail, oneTail, twoTail

3. Traverse original list:
   - if node value = 0 → attach to zero list
   - if node value = 1 → attach to one list
   - if node value = 2 → attach to two list

4. Disconnect each node before moving ahead:
   temp.next = null

5. Connect lists:
   zero list -> one list (if exists), else two list
   one list -> two list

6. Return zeroHead.next



Why temp.next = null is Important

This is not optional.
Each node originally points to old next node.

If you directly attach node into new sublist
without breaking old link,
wrong connections can remain.

So before attaching:

temp.next = null

This cleanly detaches the node
from original list.


Time Complexity: O(n)
Each node visited once.

Space Complexity: O(1)
Only pointer variables used.
Dummy nodes are constant extra space.
*/

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode zeroTail = zeroHead;
        ListNode oneTail = oneHead;
        ListNode twoTail = twoHead;

        ListNode temp = head;

        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = null;

            if (temp.data == 0) {
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            } else if (temp.data == 1) {
                oneTail.next = temp;
                oneTail = oneTail.next;
            } else {
                twoTail.next = temp;
                twoTail = twoTail.next;
            }

            temp = nextNode;
        }

        // connect 0-list
        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
        } else {
            zeroTail.next = twoHead.next;
        }

        // connect 1-list to 2-list
        oneTail.next = twoHead.next;

        // return correct head
        return zeroHead.next;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)