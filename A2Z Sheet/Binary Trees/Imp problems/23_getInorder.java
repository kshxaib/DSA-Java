import java.util.*;

class Solution {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null){
            // no left subtree
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            } else {
                // find inorder predecessor
                TreeNode IP = curr.left;
                while(IP.right != null && IP.right != curr){
                    IP = IP.right;
                }

                // create thread
                if(IP.right == null){
                    IP.right = curr;
                    curr = curr.left;
                } 
                
                // remove thread
                else {
                    IP.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}