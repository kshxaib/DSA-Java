
class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        if(Math.abs(lh - rh) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        return 1+ Math.max(lh, rh);
    }
}


class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return getHeight(root) != -1;

    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        if(lh == -1 || rh == -1) return -1;

        if(Math.abs(lh - rh) > 1) return -1;

        return 1+ Math.max(lh, rh);
    }
}