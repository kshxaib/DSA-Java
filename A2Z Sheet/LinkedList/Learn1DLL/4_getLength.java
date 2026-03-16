class Solution {
    public int getLength(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }

        return len;
    }
}
Find the length of the Linked List
Subscribe to TUF+

Hints
Company
You are given the head of a singly linked list. Your task is to return the number of nodes in the linked list.


Example 1

Input: head = [1, 2, 3, 4, 5]

Output: 5

Example 2

Input: head = [8, 6]

Output: 2