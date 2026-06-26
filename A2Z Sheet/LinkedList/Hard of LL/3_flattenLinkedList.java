/*
        FLATTEN A LINKED LIST

Definition:
Given a special linked list where:

1. next  → points to the next head node
2. child → points to a sorted linked list downward

Flatten the entire structure into
one single sorted linked list
using only the child pointer.


Structure

Main list using next:

1 -> 4 -> 7 -> 8

Each node may have a child list:

1
|
2
|
3

4
|
5
|
6

7
|
9

8
|
10
|
11
|
12

After flattening:

1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12
(using child pointer only)


Core Idea

This is basically:
Flatten recursively + merge sorted linked lists

Because:
• every child list is already sorted
• once head.next is flattened,
  we only need to merge:
  
  current child-list
  with
  flattened remaining list


  Approach
1. Flatten the list on the right side first
2. Merge current vertical list with flattened right side
3. Return merged head

This is correct.


Step 1 — Base Case

If:

head == null
or
head.next == null

Then return head directly

Why?

Because:
• empty list is already flat
• single list does not need merging


Step 2 — Recursive Flatten

ListNode mergedHead = flattenLinkedList(head.next);

This means:

first flatten all lists on the right side

So when recursion comes back,
head.next side is already one sorted child list


Step 3 — Merge Two Sorted Child Lists

Now merge:

head
and
mergedHead

Both are sorted through child pointer


Why Merge Works

Because each vertical child chain is sorted.

So flattening becomes the same pattern as merge sort:

merge(sorted list 1, sorted list 2)


Step-by-Step Algorithm

1. If head is null or only one main node:
   return head

2. Recursively flatten head.next

3. Merge current child list with flattened next list

4. Return merged head


Time Complexity: O(N)
Where N = total number of nodes
across all child lists

More precisely:
each merge processes nodes repeatedly,
so practical explanation depends on structure.

For k top-level lists,
this recursive merge approach is often described as:

O(total nodes * number of lists) in worst shape

It is not as optimal as divide-and-conquer merging.


Space Complexity: O(N) for newly created nodes
+ recursion stack
*/

class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode() {
            val = 0;
            next = null;
            child = null;
        }

        ListNode(int data) {
            val = data;
            next = null;
            child = null;
        }

        ListNode(int data, ListNode nextNode, ListNode childNode) {
            val = data;
            next = nextNode;
            child = childNode;
        }
    }

    public ListNode flattenLinkedList(ListNode head) {
        // Step 1: If the list is empty or contains only one main list, it is already flattened.
        if (head == null || head.next == null) {
            return head;
        }

        // Step 2: Recursively flatten the remaining lists
        ListNode flattenedRightList = flattenLinkedList(head.next);

        // Step 3: Merge the current child list with the flattened right-side list
        return mergeSortedLists(head, flattenedRightList);
    }

    private ListNode mergeSortedLists(ListNode firstList, ListNode secondList) {
        ListNode dummy = new ListNode(-1);  // Dummy node to simplify merging
        ListNode current = dummy;

        while (firstList != null && secondList != null) {   // Step 4: Merge both sorted child lists
            if (firstList.val <= secondList.val) {
                current.child = firstList;
                firstList = firstList.child;
            } else {
                current.child = secondList;
                secondList = secondList.child;
            }

            current = current.child;    // Move forward in merged list
            current.next = null;        // Remove old next pointer
        }

        while (firstList != null) {     // Step 5: Attach remaining nodes from first list
            current.child = firstList;
            current = current.child;
            firstList = firstList.child;

            current.next = null;
        }

        while (secondList != null) {    // Step 6: Attach remaining nodes from second list
            current.child = secondList;
            current = current.child;
            secondList = secondList.child;

            current.next = null;
        }

        return dummy.child;    // Step 7: Return the head of the merged child list
    }
}