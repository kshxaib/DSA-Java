class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If root is null or we found p/q
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p found on one side and q on other side current root is LCA
        if(left != null && right != null){
            return root;
        }

        // return the side where p/q exists
        if(left != null){
            return left;
        }

        return right;
    }
}