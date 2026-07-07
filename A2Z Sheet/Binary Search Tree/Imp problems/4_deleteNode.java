class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key) return helper(root);

        TreeNode curr = root;
        while(curr != null){
            if(curr.val > key){
                if(curr.left != null && curr.left.val == key){
                    curr.left = helper(curr.left);
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if(curr.right != null && curr.right.val == key){
                    curr.right = helper(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }

        return root;
    }

    private TreeNode helper(TreeNode curr){
        if(curr.left == null){
            return curr.right;
        } else if(curr.right == null){
            return curr.left;
        } else {
            TreeNode rightSubTree = curr.right;
            TreeNode lastRight = findLastRightInLeft(curr.left);
            lastRight.right = rightSubTree;
            return curr.left;
        }
    }

    private TreeNode findLastRightInLeft(TreeNode curr){
        if(curr.right == null) return curr;

        return findLastRightInLeft(curr.right);
    }
}