class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node clone = new Node(node.val);
        map.put(node, clone);
        queue.offer(node);

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            for(Node neighbor : curr.neighbors){

                if(!map.containsKey(neighbor)){
                    Node neighborClone = new Node(neighbor.val);
                    map.put(neighbor, neighborClone);
                    queue.offer(neighbor);
                }

                Node cloned = map.get(curr);
                Node neighborClone = map.get(neighbor);

                cloned.neighbors.add(neighborClone);
            }
        }

        return clone;
    }
}