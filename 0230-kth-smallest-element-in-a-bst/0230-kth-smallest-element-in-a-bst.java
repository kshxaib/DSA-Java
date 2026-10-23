class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        return inorderList.get(k-1);        
    }

    private void inorder(TreeNode node, List<Integer> inorderList){
        if(node == null) return;

        inorder(node.left, inorderList);
        inorderList.add(node.val);
        inorder(node.right, inorderList);
    }
}