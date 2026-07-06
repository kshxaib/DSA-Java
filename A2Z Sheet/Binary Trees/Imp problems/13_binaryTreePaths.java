import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        dfs(ans, root, "");
        return ans;
    }

    private void dfs(List<String> ans, TreeNode root, String path){
        if (root == null) return;

        // Add current node
        if (path.length() == 0) {
            path = "" + root.val;
        } else {
            path = path + "->" + root.val;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        dfs(ans, root.left, path);
        dfs(ans, root.right, path);
    }
}