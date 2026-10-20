class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

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
}