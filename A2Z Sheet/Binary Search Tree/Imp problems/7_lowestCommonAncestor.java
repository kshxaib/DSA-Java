class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            // both nodes are on right side
            if (curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            }

            // both nodes are on left side
            else if (curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            }

            // split point found
            else {
                return curr;
            }
        }

        return null;
    }
}
