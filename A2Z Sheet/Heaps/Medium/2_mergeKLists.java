/*
        MERGE K SORTED LINKED LISTS

Definition:
Given array of k sorted linked lists,

Merge all into ONE sorted linked list.


Example

Input:

[
  1->4->5,
  1->3->4,
  2->6
]

Output:

1->1->2->3->4->4->5->6


=====================================================
1. BRUTE FORCE (ARRAY + SORT)
=====================================================

Steps:
1. Put all node values into array
2. Sort array
3. Create new linked list


Why This Works
All values collected together,
then globally sorted.


Time Complexity
Collect = O(N)
Sort    = O(N log N)

Total   = O(N log N)
N = total nodes

Space Complexity: O(N)
(extra array + new nodes)
*/

import java.util.*;

class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKListsBrute(ListNode[] lists) {

        ArrayList<Integer> arr = new ArrayList<>();

        // collect all values
        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];

            while (temp != null) {
                arr.add(temp.val);
                temp = temp.next;
            }
        }

        // sort values
        Collections.sort(arr);

        // build new sorted list
        ListNode dummy = new ListNode(-1);
        ListNode dTemp = dummy;

        for (int i = 0; i < arr.size(); i++) {
            dTemp.next = new ListNode(arr.get(i));
            dTemp = dTemp.next;
        }

        return dummy.next;
    }

    /*
     * =====================================================
     * 2. ITERATIVE MERGING
     * =====================================================
     * 
     * Merge lists one-by-one.
     * 
     * Like:
     * (((L1 + L2) + L3) + L4)
     * 
     * 
     * Time Complexity
     * Worst case: O(k * N)
     * Can become expensive.
     * 
     * Space Complexity: O(1)
     */

    public ListNode mergeKListsBetter(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = lists[0];

        // merge one-by-one
        for (int i = 1; i < lists.length; i++) {
            head = merge(head, lists[i]);
        }

        return head;
    }

    // merge two sorted lists
    public ListNode merge(ListNode firstL, ListNode secondL) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (firstL != null && secondL != null) {
            if (firstL.val <= secondL.val) {
                temp.next = firstL;
                firstL = firstL.next;
            } else {
                temp.next = secondL;
                secondL = secondL.next;
            }

            temp = temp.next;
        }

        // remaining nodes
        if (firstL != null) {
            temp.next = firstL;
        }

        if (secondL != null) {
            temp.next = secondL;
        }

        return dummy.next;
    }

    /*
     * =====================================================
     * 3. OPTIMAL (MIN HEAP)
     * =====================================================
     * 
     * Core Idea:
     * Always pick smallest current node
     * among all lists.
     * 
     * Use Min Heap.
     * 
     * 
     * Why This Works
     * 
     * Heap top always gives
     * globally smallest node.
     * 
     * 
     * Process
     * 1. Insert all list heads into heap
     * 2. Remove smallest node
     * 3. Add its next node into heap
     * 4. Repeat
     * 
     * 
     * Time Complexity
     * Each node inserted/removed once.
     * 
     * O(N log k)
     * 
     * BEST solution.
     * 
     * Space Complexity: O(k)
     * Heap stores at most k nodes.
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // min heap based on node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> a.val - b.val);

        // insert first node of every list
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            // smallest node
            ListNode minNode = pq.remove();
            temp.next = minNode;
            temp = temp.next;

            // push next node from same list
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
