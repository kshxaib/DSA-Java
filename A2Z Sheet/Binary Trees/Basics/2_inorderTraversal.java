import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        inorder(ans, root);

        return ans;
    }

    private void inorder(List<Integer> ans, TreeNode root){
        if(root == null){
            return;
        }

        inorder(ans, root.left);
        ans.add(root.val);
        inorder(ans, root.right);
    }
}