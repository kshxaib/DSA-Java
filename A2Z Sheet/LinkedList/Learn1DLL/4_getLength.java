/*
        FIND LENGTH OF LINKED LIST

Problem:
Given the head of a singly linked list,
return the total number of nodes in the list.


Example 1
Input: head = [1, 2, 3, 4, 5]

Output: 5

Explanation:
There are 5 nodes in the list.


Example 2
Input: head = [8, 6]

Output: 2


Core Idea

Traverse the linked list from head
until the last node (null) is reached.

Count each node during traversal.


Visualization

Linked List

head
 ↓
1 -> 2 -> 3 -> 4 -> 5 -> null

Traversal:

1 → count = 1  
2 → count = 2  
3 → count = 3  
4 → count = 4  
5 → count = 5

Stop when temp becomes null.


Step-by-Step Algorithm

1. Initialize count = 0
2. Create a temporary pointer temp = head
3. Traverse while temp != null
4. Increment count
5. Move temp to next node
6. Return count


Time Complexity: O(n)
We visit each node once.

Space Complexity: O(1)
No extra memory required.
*/

class Solution {

    public int getLength(ListNode head) {

        int len = 0;

        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        return len;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)