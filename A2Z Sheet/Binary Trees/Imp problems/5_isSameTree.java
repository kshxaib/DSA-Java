class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;     // both trees ended together

        if(p == null || q == null) return false;    // structure mismatch
        
        if(p.val != q.val) return false;            // value mismatch
        
        
        boolean left = isSameTree(p.left, q.left);  // compare left subtree

        boolean right = isSameTree(p.right, q.right);// compare right subtree

        return left && right;                        // both sides should be same
    }
}

