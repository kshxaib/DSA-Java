import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();  // child -> parent
        markParents(root, parentTrack, target);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>(); // BFS from target
        queue.offer(target);
        visited.put(target, true);

        int currDistance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            if(currDistance == k) break;       // reached kth distance
            currDistance++;

            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();

                if(curr.left != null && !visited.containsKey(curr.left)){    // move left
                    queue.offer(curr.left);
                    visited.put(curr.left, true);
                }

                if(curr.right != null && !visited.containsKey(curr.right)){  // move right
                    queue.offer(curr.right);
                    visited.put(curr.right, true);
                }

                // move parent
                if(parentTrack.get(curr) != null && !visited.containsKey(parentTrack.get(curr))){
                    queue.offer(parentTrack.get(curr));
                    visited.put(parentTrack.get(curr), true);
                }
            }
        }

        // remaining nodes are distance k
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            ans.add(curr.val);
        }

        return ans;
    }

    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack, TreeNode target){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                queue.offer(curr.left);
                parentTrack.put(curr.left, curr);
            }

            if(curr.right != null){
                queue.offer(curr.right);
                parentTrack.put(curr.right, curr);
            }
        }
    }
}