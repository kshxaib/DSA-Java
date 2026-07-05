import java.util.*;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        // BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        boolean leftToRight = true; // direction flag

        while (!queue.isEmpty()) {
            int levelSize = queue.size();   // nodes present in current level
            Integer subList[] = new Integer[levelSize]; // store current level values

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // decide position according to direction
                int index = leftToRight ? i : levelSize - i - 1;
                subList[index] = node.val;

                // add next level nodes
                if (node.left != null) queue.offer(node.left);
                
                if (node.right != null) queue.offer(node.right);
            }

            leftToRight = !leftToRight; // change direction after every level
            result.add(Arrays.asList(subList));
        }

        return result;
    }
}