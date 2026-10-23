class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int result[] = new int[2];  //[0]: counter, [1]: element
        inorder(root, result, k);

        return result[1];        
    }

    private void inorder(TreeNode node, int result[], int k){
        if(node == null) return;

        inorder(node.left, result, k);
        result[0]++;

        if(result[0] == k){
            result[1] = node.val;
            return;
        }

        inorder(node.right, result, k);
    }
}