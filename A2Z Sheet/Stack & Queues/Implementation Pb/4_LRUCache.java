class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int cap;

    HashMap<Integer, Node> map = new HashMap<>();


    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    public void deleteNode(Node Node){
        Node prevNode = Node.prev;
        Node nextNode = Node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public int get(int key) {
       if(map.containsKey(key)){
            Node resNode = map.get(key);
            int val = resNode.val;

            map.remove(key);

            deleteNode(resNode);

            addNode(resNode);

            map.put(key, head.next);
            return val;
       }

       return -1;
    }

    public void put(int key, int value) {
      if(map.containsKey(key)){
        Node existingNode = map.get(key);
        map.remove(key);
        deleteNode(existingNode);
      }

      if(map.size() == cap){
        map.remove(tail.prev.key);
        deleteNode(tail.prev);
      }

      addNode(new Node(key, value));
      map.put(key, head.next);
    }

}