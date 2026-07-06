

class Solution {
    boolean checkChildrenSum(TreeNode root) { 
        if(root == null) return true;   // empty tree

        if(root.left == null && root.right == null) return true;    // leaf node always valid

        int sum = 0;
        if(root.left != null){  // add left child value
            sum += root.left.val;
        }

        if(root.right != null){  // add right child value
            sum += root.right.val;
        }

        if (root.val != sum) {   // current node violates property
            return false;
        }

        // check left and right subtree
        return checkChildrenSum(root.left) && checkChildrenSum(root.right);
    }
}
