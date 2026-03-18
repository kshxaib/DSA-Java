/*
        SORT LINKED LIST (MERGE SORT ON LINKED LIST)

Definition:
Given the head of a singly linked list,
sort the list in ascending order
and return the new head.


Example 1
Input: [4, 2, 1, 3]

Output:
[1, 2, 3, 4]


Example 2
Input: [-1, 5, 3, 4, 0]

Output:
[-1, 0, 3, 4, 5]


Why Not Use Normal Sorting Directly?

In arrays:
we can access middle in O(1)

In linked lists:
random access is not possible

So algorithms like quick sort are not ideal here.

Best choice for linked list sorting:
MERGE SORT


Why Merge Sort Works Best for Linked List
• Splitting using slow/fast pointer is easy
• Merging two sorted linked lists is easy
• No random indexing needed
• Gives O(n log n) time


Core Idea

Merge Sort works in 3 steps:
1. Find middle of linked list
2. Divide into two halves
3. Recursively sort both halves
4. Merge sorted halves


Time Complexity: O(n log n)
Explanation:
• Splitting takes O(log n) levels
• Merging at each level costs O(n)

Space Complexity: O(log n)
Explanation:
Recursive call stack is used.
*/

class Solution {

    public ListNode sortList(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find middle
        ListNode mid = getMid(head);

        // Step 2: Split list into two halves
        ListNode rightHead = mid.next;
        mid.next = null;

        // Step 3: Recursively sort both halves
        ListNode leftHalfSorted = sortList(head);
        ListNode rightHalfSorted = sortList(rightHead);

        // Step 4: Merge sorted halves
        ListNode sortedLL = merge(leftHalfSorted, rightHalfSorted);

        return sortedLL;
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge(ListNode leftHalf, ListNode rightHalf) {
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        while (leftHalf != null && rightHalf != null) {
            if (leftHalf.val <= rightHalf.val) {
                temp.next = leftHalf;
                leftHalf = leftHalf.next;
            } else {
                temp.next = rightHalf;
                rightHalf = rightHalf.next;
            }

            temp = temp.next;
        }

        while (leftHalf != null) {
            temp.next = leftHalf;
            leftHalf = leftHalf.next;
            temp = temp.next;
        }

        while (rightHalf != null) {
            temp.next = rightHalf;
            rightHalf = rightHalf.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }
}

// Time Complexity  : O(n log n)
// Space Complexity : O(log n)