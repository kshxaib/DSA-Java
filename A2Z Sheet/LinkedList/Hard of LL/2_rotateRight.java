/*
        ROTATE LINKED LIST TO THE RIGHT

Definition:
Given the head of a singly linked list
and an integer k,
rotate the list to the right by k places.

Rotation means:
Take the last node and move it to the front,
repeating this process k times.


Example 1
Input:
head = [1, 2, 3, 4, 5], k = 2

Output:
[4, 5, 1, 2, 3]

Explanation:
Rotate right once:
[5, 1, 2, 3, 4]

Rotate right twice:
[4, 5, 1, 2, 3]


Example 2
Input:
head = [0, 1, 2], k = 4

Output:
[2, 0, 1]

Explanation:
Size = 3
k = 4 % 3 = 1

So rotate only once.


Core Idea

Instead of rotating one step at a time,
first find the effective rotation.

Because rotating by list length
does not change the list.

So:

effective k = k % size

Then find the new breaking point.


Code Logic

Step 1:
Handle edge cases

If:
• head == null
• only one node
• k == 0

Then return head directly


Step 2:
Find size of linked list
and also get the last node (tail)

This loop does both:

while (tail.next != null) {
    tail = tail.next;
    size++;
}


Step 3:
Reduce useless rotations

k = k % size

Example:

size = 5
k = 12

effective k = 12 % 5 = 2

So only 2 rotations matter.


Step 4:
If effective k becomes 0

Return original head

Because full rotations cause no change.


Step 5:
Find new tail position

n = size - k

This means:
the n-th node becomes the new tail

And:
temp.next becomes the new head


Step 6:
Traverse to the new tail

You move temp until count < n

So after loop:

temp = new tail


Step 7:
Make linked list circular temporarily

tail.next = head

Now last node points back to first node


Step 8:
Set new head

head = temp.next

Because node after new tail
becomes the new head


Step 9:
Break the circle

temp.next = null

Now list is properly rotated


Time Complexity: O(n)
Explanation:
• One traversal to find size and tail
• One traversal to find new tail
Overall still O(n)

Space Complexity: O(1)
Only pointer variables used
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head;
        int size = 1;

        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        k = k % size;
        if (k == 0) return head;

        int n = size - k;
        ListNode temp = head;
        int count = 1;
        while(temp != null && count < n){
            temp = temp.next;
            count++;
        }

        tail.next = head;
        head = temp.next;
        temp.next = null;

        return head;
    }
}