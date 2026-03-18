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

/*
 * -----------------------------------------------------
 * 
 * Step-by-Step Algorithm
 * 
 * 1. If any list is null → return null
 * 2. Set temp1 = headA, temp2 = headB
 * 3. Move both one step at a time
 * 4. If temp1 reaches null → move to headB
 * 5. If temp2 reaches null → move to headA
 * 6. Continue until temp1 == temp2
 * 7. Return temp1
 * 
 * -----------------------------------------------------
 * 
 * Dry Run
 * 
 * A: 1 -> 9 -> 1 -> 2 -> 4
 * B: 3 -> 2 -> 4
 * 
 * Intersection at node 2
 * 
 * temp1 path:
 * 1 -> 9 -> 1 -> 2 -> 4 -> null -> 3 -> 2
 * 
 * temp2 path:
 * 3 -> 2 -> 4 -> null -> 1 -> 9 -> 1 -> 2
 * 
 * They meet at node 2
 * 
 * -----------------------------------------------------
 * 
 * Edge Cases
 * 
 * • No intersection → both become null
 * • One list empty → return null
 * • Intersection at head
 * • Different lengths
 * 
 * -----------------------------------------------------
 * 
 * Time Complexity
 * 
 * O(m + n)
 * 
 * Both pointers traverse at most
 * two lists combined.
 * 
 * -----------------------------------------------------
 * 
 * Space Complexity
 * 
 * O(1)
 * 
 * Only two pointers used.
 * 
 * -----------------------------------------------------
 * 
 * Key Interview Points
 * 
 * • Most optimal approach
 * • No length calculation needed
 * • No extra HashSet needed
 * • Based on pointer switching
 * • Compare references, not values
 * 
 * -----------------------------------------------------
 * 
 * Common Mistakes
 * 
 * • Comparing values instead of nodes
 * • Using extra space unnecessarily
 * • Overcomplicating pointer resets
 * • Forgetting null handling
 * 
 * -----------------------------------------------------
 */