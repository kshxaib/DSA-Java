/*
        REVERSE NODES IN K-GROUP

Definition:
Given the head of a linked list,
reverse the nodes of the list k at a time
and return the modified list.

If the number of remaining nodes is less than k,
leave them as they are.

IMPORTANT:
• Reverse nodes, not values
• Leftover nodes (< k) stay unchanged


Example 1
Input:
head = [1, 2, 3, 4, 5], k = 2

Output:
[2, 1, 4, 3, 5]

Explanation:
Reverse every group of 2 nodes

[1,2] -> [2,1]
[3,4] -> [4,3]
[5] stays same


Example 2
Input:
head = [1, 2, 3, 4, 5], k = 3

Output:
[3, 2, 1, 4, 5]

Explanation:
[1,2,3] -> [3,2,1]
Remaining [4,5] has size less than 3
so it remains unchanged


Core Idea

Process the linked list group by group.

For each group:
1. Find the k-th node
2. If k nodes do not exist → stop
3. Detach that group
4. Reverse the group
5. Connect reversed group back
6. Move to next group


Key Pointers Used
temp     → starting node of current group
kthNode  → last node of current k-sized group
nextNode → first node after current group
prev     → tail of previously reversed group


Step-by-Step Algorithm

1. Start temp = head, prev = null

2. Find k-th node from temp

3. If k-th node is null:
   remaining nodes are less than k
   connect previous tail to temp
   stop

4. Store nextNode = kthNode.next

5. Break the group:
   kthNode.next = null

6. Reverse current group

7. If temp was original head:
   update head = kthNode

8. Otherwise:
   prev.next = kthNode

9. Current group's original start (temp)
   becomes tail after reversal,
   so connect:
   temp.next = nextNode

10. Move prev = temp
    move temp = nextNode


Time Complexity: O(n)
Explanation:
Each node is visited a constant number of times.

Space Complexity: O(1)
Only pointer manipulation used.
*/

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            ListNode kthNode = findKthNode(temp, k);

            // less than k nodes left
            if (kthNode == null) {
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;

            // detach current k-group
            kthNode.next = null;

            // reverse current group
            reverse(temp);

            // first group
            if (temp == head) {
                head = kthNode;
            } else {
                prev.next = kthNode;
            }

            // temp becomes tail after reversal
            prev = temp;
            temp = nextNode;
        }

        return head;
    }

    public ListNode findKthNode(ListNode temp, int k) {
        int count =  1;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        return temp;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1) 