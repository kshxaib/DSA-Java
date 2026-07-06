import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        dfs(ans, root, 0);
        return ans;
    }

    private void dfs(List<Integer> ans, TreeNode root, int level){
        if(root == null) return;

        if(level == ans.size()){
            ans.add(root.val);
        }

        dfs(ans, root.right, level +1);
        dfs(ans, root.left, level +1);
    }
}