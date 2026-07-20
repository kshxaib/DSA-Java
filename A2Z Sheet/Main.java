import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

public ListNode detectCycle(ListNode head) {
    ListNode temp = head;
    Map<ListNode, Integer> map = new HashMap<>();

    while (temp != null) {
        if (map.containsKey(temp)) {
            return temp;
        }

        map.put(temp, 1);
        temp = temp.next;
    }

    return null;
}