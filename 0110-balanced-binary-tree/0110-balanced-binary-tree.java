class Solution {
    public boolean isBalanced(TreeNode root) {
        if(findHeight(root) == -1){
            return false;
        }

        return true;
    }

    private int findHeight(TreeNode root) {
        if(root == null) return 0;

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        
        if(lh == -1 || rh == -1) return -1;

        if(Math.abs(lh - rh) > 1){
            return -1;
        }

        return 1+ Math.max(lh, rh);
    }
}