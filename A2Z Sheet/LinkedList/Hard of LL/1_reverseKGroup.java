class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);

            if (kthNode == null) {
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverse(temp);

            if (temp == head) {
                head = kthNode;
            } else {
                prev.next = kthNode;
            }

            prev = temp;
            temp = nextNode;
        }

        return head;
    }

    public ListNode findKthNode(ListNode temp, int k) {
        int count = 1;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public void reverse(ListNode temp) {
        ListNode curr = temp;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}