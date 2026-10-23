class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);   

        for(int i=1; i<inorderList.size(); i++){
            if(inorderList.get(i) <= inorderList.get(i-1)){
                return false;
            }
        }  

        return true;
    }

    private void inorderTraversal(TreeNode node, List<Integer> inorderList){
        if(node == null) return;

        inorderTraversal(node.left, inorderList);
        inorderList.add(node.val);
        inorderTraversal(node.right, inorderList);
    }
}