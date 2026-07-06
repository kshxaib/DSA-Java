import java.util.*;

class Solution {
    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int maxWidth = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            long first = 0;
            long last = 0;

            // Normalize indexes to avoid overflow
            long minIndex = queue.peek().index;

            for(int i=0; i<levelSize; i++){
                Pair curr = queue.poll();
                TreeNode node = curr.node;
                long index = curr.index - minIndex;

                if(i == 0) first = index;
                if(i == levelSize -1) last = index;

                if(node.left != null){
                    queue.offer(new Pair(node.left, 2*index +1));
                }

                if(node.right != null){
                    queue.offer(new Pair(node.right, 2*index +2));
                }
            }

            maxWidth = Math.max(maxWidth,(int) (last - first +1));
        }

        return maxWidth;
    }
}