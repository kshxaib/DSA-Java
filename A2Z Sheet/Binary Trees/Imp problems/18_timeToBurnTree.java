import java.util.*;

class Solution {
    public int timeToBurnTree(TreeNode root, int start) {
        // child -> parent mapping
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();

        // find target node also
        TreeNode target = markParents(root, parentTrack, start);

         // BFS from target node
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();

        queue.offer(target);
        visited.put(target, true);

        int time = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean burned = false;

             for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();

                // burn left child
                if (curr.left != null && !visited.containsKey(curr.left)) {
                    queue.offer(curr.left);
                    visited.put(curr.left, true);
                    burned = true;
                }

                // burn right child
                if (curr.right != null && !visited.containsKey(curr.right)) {
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                    burned = true;
                }

                // burn parent
                TreeNode parent = parentTrack.get(curr);
                if (parent != null && !visited.containsKey(parent)) {
                    queue.offer(parent);
                    visited.put(parent, true);
                    burned = true;
                }
            }
            
            // one second passed only if fire spread
            if (burned) {
                time++;
            }

        }

        return time;
    }

    private TreeNode markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack, int start){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

         TreeNode target = null;

          while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            // find starting node
            if (curr.val == start) {
                target = curr;
            }

            if (curr.left != null) {
                parentTrack.put(curr.left, curr);
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                parentTrack.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }

        return target;
    }
}
