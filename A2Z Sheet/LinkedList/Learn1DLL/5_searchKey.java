/* Defination of ListNoode
class ListNode {
    int val;
    ListNode next;

    ListNode(int value) {
        this.val = value;
        this.next = null;
    }
}
*/


class Solution {
    public boolean searchKey(ListNode head, int key) {
        ListNode temp = head;
        while(temp != null){

            if(temp.val == key){
                return true;
            }

            temp = temp.next;
        }

        return false;
    }
}

Search in Linked List
Subscribe to TUF+

Hints
Company
You are given the head of a singly linked list and an integer key.

Return true if the key exists in the linked list, otherwise return false.


Example 1

Input: head = [1, 2, 3, 4], key = 3

Output: true

Explanation: The linked list is 1 → 2 → 3 → 4. The key 3 is present in the list.

Example 2

Input: head = [7, 8, 9, 10, 11], key = 5

Output: false

Explanation: The key 5 is not present in the list.




