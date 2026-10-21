class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;   

        if(isSameTree(root, subRoot)){
            return true;
        }  

        boolean leftTree = isSubtree(root.left, subRoot);
        boolean rightTree = isSubtree(root.right, subRoot);

        return leftTree || rightTree;
    }

    private boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }
}