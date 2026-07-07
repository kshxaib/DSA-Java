class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;

        while(curr != null){
            if(curr.val == val) return curr;    // target found

            // target is bigger search right side
            if(curr.val < val){
                curr = curr.right;
            } 

            // target is smaller search left side
            else {
                curr = curr.left;
            }
        }    

        return null;    // not founf
    }
}