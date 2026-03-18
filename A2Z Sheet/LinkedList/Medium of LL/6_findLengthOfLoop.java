/*
        LENGTH OF LOOP IN LINKED LIST

Definition:
Given the head of a singly linked list,
find the length of the loop if a cycle exists.

If no loop exists → return 0


What is a Loop?
A loop exists when a node points back
to some previous node instead of null.

Example:
1 -> 2 -> 3 -> 4 -> 5
     ↑              ↓
     ← ← ← ← ← ← ← ←

Loop: 2 -> 3 -> 4 -> 5 -> 2

Loop length = 4


Core Idea (Floyd’s Tortoise & Hare)

Use two pointers:
slow → moves 1 step
fast → moves 2 steps

If they meet:
cycle exists

After meeting:
traverse the cycle once to count its length


Step-by-Step Algorithm

1. Initialize slow = head, fast = head
2. Traverse while:
      fast != null && fast.next != null
3. Move slow by 1 step
4. Move fast by 2 steps
5. If slow == fast:
      cycle found
6. Start count = 1
7. Move slow = slow.next
8. While slow != fast:
      slow = slow.next
      count++
9. Return count
10. If no cycle found → return 0


Time Complexity: O(n)

Explanation:
Cycle detection is O(n)
Loop counting is at most O(n)


Space Complexity: O(1)
No extra memory used
*/

class Solution {

    public int findLengthOfLoop(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Step 2: Count loop length
                int count = 1;
                slow = slow.next;

                while (slow != fast) {
                    slow = slow.next;
                    count++;
                }

                return count;
            }
        }

        return 0;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)