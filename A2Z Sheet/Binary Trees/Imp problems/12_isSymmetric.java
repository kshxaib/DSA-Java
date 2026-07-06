class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;  // both sides ended
        if(left == null || right == null) return false; // structure mismatch

        if(left.val != right.val) return false; // value mismatch

        // compare opposite sides
        return check(left.left, right.right) && check(left.right, right.left);
    }
}

