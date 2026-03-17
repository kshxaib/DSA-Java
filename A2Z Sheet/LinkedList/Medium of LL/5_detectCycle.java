/*
        LINKED LIST CYCLE II (FIND START OF CYCLE)

Problem:
Given the head of a linked list,
return the node where the cycle begins.

If no cycle → return null

IMPORTANT:
Do NOT modify the list
Must use O(1) space


Example 1
Input: [3,2,0,-4], pos = 1

Output:
node with value 2

Explanation:
Tail connects back to index 1


Example 2
Input: [1,2], pos = 0

Output:
node with value 1


Example 3
Input: [1], pos = -1

Output:
null


Core Idea (Floyd’s Algorithm)
Step 1 → Detect cycle  
Step 2 → Find starting node of cycle  


Why It Works (Important)
Mathematically:
They meet such that:
distance(slow) = distance(fast) / 2

After resetting slow:
Both pointers travel equal distance to cycle start
So they meet exactly at cycle start


Time Complexity: O(n)

Space Complexity: O(1)
*/

class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Step 2: Find start of cycle
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // start of cycle
            }
        }

        return null; // no cycle
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)