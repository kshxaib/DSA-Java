class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        TreeNode curr = root;
        while(true){
            if(curr.val <= val){    // value belongs to right side
                if(curr.right != null){
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val); // insert position found
                    break;
                }
            } else {
                if(curr.left != null){   // value belongs to left side
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);   // insert position found
                    break;
                }
            }
        }

        return root;
    }
}