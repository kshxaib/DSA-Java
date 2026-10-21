class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int LH = findHeight(root.left);
        int RH = findHeight(root.right);

        if(Math.abs(LH - RH) > 1) return false;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return left && right;
    }

    private int findHeight(TreeNode root) {
        if(root == null) return 0;

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        return 1+ Math.max(lh, rh);
    }
}