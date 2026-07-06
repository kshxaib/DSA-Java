class Solution {
     class Pair {
        TreeNode node;
        int line;

        Pair(TreeNode node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    public List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        // line -> node value
        Map<Integer, Integer> map = new TreeMap<>();
        // store node with its vertical line
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int line = curr.line;
            
            // First node appearing at this line = top view
            if (!map.containsKey(line)) {
                map.put(line, node.data);
            }

            if (node.left != null) {
                queue.offer(new Pair(node.left, line - 1));
            }


            if (node.right != null) {
                queue.offer(new Pair(node.right, line + 1));
            }
        }

        // TreeMap gives left to right order
        for (int value : map.values()) {
            ans.add(value);
        }

        return ans;
    }   
}