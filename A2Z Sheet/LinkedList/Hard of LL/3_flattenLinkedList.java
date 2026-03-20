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
    public ListNode flattenLinkedList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mergedHead = flattenLinkedList(head.next);
        return merge(head, mergedHead);
    }

    public ListNode merge(ListNode temp1, ListNode temp2){
        ListNode dummy = new ListNode(-1);
        ListNode dummyTemp = dummy;

        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                dummyTemp.child = new ListNode(temp1.val);
                temp1 = temp1.child;
            } else {
                dummyTemp.child = new ListNode(temp2.val);
                temp2 = temp2.child;
            }

            dummyTemp = dummyTemp.child;
        }

        while (temp1 != null) {
            dummyTemp.child = new ListNode(temp1.val);
            dummyTemp = dummyTemp.child;
            temp1 = temp1.child;
        }

        while (temp2 != null) {
            dummyTemp.child = new ListNode(temp2.val);
            dummyTemp = dummyTemp.child;
            temp2 = temp2.child;
        }

        return dummy.child;
    }
}