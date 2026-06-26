import java.util.*;

class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>(); //<original, createdOne>

        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);

            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node node = map.get(temp);
            node.next = map.get(temp.next);
            node.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head);
    }


    public Node copyRandomList(Node head) {
        if (head == null) return null;

        insertCopyInBetween(head);

        connectRandomPointers(head);

        Node newHead = extractCopiedList(head);

        return newHead;
    }

    private void insertCopyInBetween(Node head){
        Node temp = head;
        while(temp != null){
            Node nextNode = temp.next;

            Node newNode = new Node(temp.val);
            temp.next = newNode;
            newNode.next = nextNode;

            temp = nextNode;
        }
    }

    private void connectRandomPointers(Node head){
        Node temp = head;
        while(temp != null){
            Node copiedNextNode = temp.next;
            
            if(temp.random != null){
                copiedNextNode.random = temp.random.next;
            } else {
                copiedNextNode.random = null;
            }

            temp = temp.next.next;
        }
    }

    private Node extractCopiedList(Node head){
        Node dummy = new Node(-1);
        Node dTemp = dummy;

        Node temp = head;
        while(temp != null){
            dTemp.next = temp.next;
            dTemp = dTemp.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}