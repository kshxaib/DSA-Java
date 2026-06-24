/*
        REVERSE SINGLY LINKED LIST

Problem:
Given the head of a singly linked list,
reverse the list and return the new head.


Example 
Input: [1, 2, 3, 4, 5]

Output: [5, 4, 3, 2, 1]


Core Idea
We reverse the direction of links.

Instead of:
1 -> 2 -> 3 -> null

We make:
1 <- 2 <- 3 <- null


Key Concept
Each node points to the previous node.

So we need 3 pointers:
prev → previous node  
curr → current node  
next → store next node (important)


Time Complexity: O(n)
Each node visited once.

Space Complexity: O(1)
In-place reversal.
*/

class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;   // store next node
            curr.next = prev;   // reverse link

            prev = curr;        // move prev
            curr = next;        // move curr
        }

        head = prev;
        return head;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)



class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    public ListNode reverseList(ListNode head) {
        Stack<Integer> st = new Stack<>();

        ListNode temp = head;
        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            temp.val = st.pop();
            temp = temp.next;
        }

        return head;
    }
}