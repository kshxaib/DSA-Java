/*
========================================================
      DELETE ALL OCCURRENCES OF A KEY IN DLL
========================================================

Problem:
Given the head of a doubly linked list
and a target value,

delete every node whose value equals
the target.

Return the updated head.


--------------------------------------------------------
Example
--------------------------------------------------------

Input:

1 <-> 2 <-> 3 <-> 1 <-> 4

target = 1

Output:

2 <-> 3 <-> 4


========================================================
CORE IDEA
========================================================

Traverse the linked list.

Whenever a node contains
the target value,

remove it by updating:

previous node's next

and

next node's prev.

Continue until end of list.


========================================================
ALGORITHM
========================================================

1. Start from head.

2. Store next node.

3. If current node contains target:

      Update previous node.

      Update next node.

      If deleting head,

      move head forward.

4. Move to stored next node.

5. Return updated head.


========================================================
CODE
========================================================
*/

class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode() {
            val = 0;
            next = null;
            prev = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
            prev = null;
        }

        ListNode(int data1, ListNode next1, ListNode prev1) {
            val = data1;
            next = next1;
            prev = prev1;
        }
    }

    public ListNode deleteAllOccurrences(ListNode head, int target) {
        // Start from the head node
        ListNode curr = head;

        // Traverse the entire list
        while(curr != null){
            // Store next node before possibly deleting current
            ListNode next = curr.next;

            // If current node matches the target value
            if(curr.val == target){
                 // If not the head, link previous node to next
                if(curr.prev != null){
                    curr.prev.next = curr.next;
                } else {
                     // If it's the head, move head forward
                    head = curr.next;
                }

                 // If not the tail, link next node to previous
                if(curr.next != null){
                    curr.next.prev = curr.prev;
                }
            }

            // Move to the next node
            curr = next;
        }

        return head;
    }
}

/*
 * Time Complexity : O(n)
 * 
 * Every node is visited once.
 * 
 * Space Complexity : O(1)
 * 
 * Only pointer variables are used.
 */