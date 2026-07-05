import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }

                subList.add(queue.poll().val);
            }

            ans.add(subList);
        }

        return ans;
    }
}