class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }        

        insertCopyInBetween(head);

        connectRandomPointers(head);

        return extractCopiedList(head);
    }

    private void insertCopyInBetween(Node head){
        Node curr = head;

        while(curr != null){
            Node nextNode = curr.next;
            Node copyNode = new Node(curr.val);

            copyNode.next = nextNode;
            curr.next = copyNode;

            curr = nextNode;
        }
    }

    private void connectRandomPointers(Node head){
        Node curr = head;

        while(curr != null){
            Node copiedNode = curr.next;

            if(curr.random != null){
                copiedNode.random = curr.random.next;
            } else {
                copiedNode.random = null;
            }

            curr = curr.next.next;
        }
    }

    private Node extractCopiedList(Node head){
        Node dummy = new Node(-1);
        Node dTemp = dummy;

        Node curr = head;
        while(curr != null){
            dTemp.next = curr.next;
            dTemp = dTemp.next;

            curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}