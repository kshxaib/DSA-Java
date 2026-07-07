class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;    // empty tree

        if(root.val == key) return helper(root);    // deleting root

        TreeNode curr = root;
        while(curr != null){    // deleting root
            if(curr.val > key){ // key lies left
                if(curr.left != null && curr.left.val == key){
                    curr.left = helper(curr.left);  // delete left child
                    break;
                } else {
                    curr = curr.left;
                }
            } else {    // key lies right
                if(curr.right != null && curr.right.val == key){
                    curr.right = helper(curr.right);    // delete right child
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }

        return root;
    }

    private TreeNode helper(TreeNode curr){
        if(curr.left == null){  // only right child
            return curr.right;
        } else if(curr.right == null){   // only left child
            return curr.left;
        } else {    // two children
            TreeNode rightSubTree = curr.right;      // store right subtree
            TreeNode lastRight = findLastRightInLeft(curr.left);    // largest node in left subtree
            lastRight.right = rightSubTree;  // attach right subtree
            return curr.left;
        }
    }

    private TreeNode findLastRightInLeft(TreeNode curr){
        if(curr.right == null) return curr; // maximum node

        return findLastRightInLeft(curr.right);
    }
}