import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        postorder(ans, root);

        return ans;
    }

    private void postorder(List<Integer> ans, TreeNode root){
        if(root == null){
            return;
        }

        postorder(ans, root.left);
        postorder(ans, root.right);
        ans.add(root.val);
    }
}