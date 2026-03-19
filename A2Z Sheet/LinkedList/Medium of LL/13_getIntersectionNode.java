/*
        INTERSECTION OF TWO LINKED LISTS

Definition:
Given the heads of two singly linked lists,
return the node where both linked lists intersect.

If there is no intersection,
return null.

IMPORTANT:
Intersection means same node reference,
NOT same value.


Example
List A:
4 -> 1 -> 8 -> 4 -> 5

List B:
5 -> 6 -> 1 -> 8 -> 4 -> 5

Here both lists intersect at node 8

Why?
Because from node 8 onward,
both lists share the exact same nodes in memory.


Very Important Concept
This is WRONG:

temp1.val == temp2.val
Same value does NOT mean intersection.

This is CORRECT:
temp1 == temp2

Because intersection is based on
same node reference / same memory location.


Core Idea (Two Pointer Switching Technique)

Use two pointers:
temp1 starts from headA
temp2 starts from headB

Move both one step at a time.

When any pointer reaches null,
redirect it to the head of the other list.

Eventually:

• both pointers travel equal total distance
• they either meet at intersection
• or both become null

Time Complexity: O(m + n)
Both pointers traverse at most
two lists combined.

Space Complexity: O(1)
Only two pointers used.
*/

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == temp2) {
                return temp1;
            }
            if (temp1 == null) {
                temp1 = headB;

            }
            if (temp2 == null) {
                temp2 = headA;
            }
        }

        return temp1;
    }
}