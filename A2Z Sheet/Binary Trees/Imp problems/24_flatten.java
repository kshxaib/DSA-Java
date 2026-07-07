
// BRUTE
class Solution1 {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            // If left subtree exists
            if (curr.left != null) {

                // Find rightmost node of left subtree
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                // Connect predecessor's right to current right subtree
                prev.right = curr.right;

                // Move left subtree to right
                curr.right = curr.left;

                // Remove left connection
                curr.left = null;
            }
            
            // move ahead
            curr = curr.right;
        }
    }
}