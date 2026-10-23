class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }        

        return buildTree(inorderIndexMap, preorder, 0, preorder.length -1, inorder, 0, inorder.length -1);
    }

    private TreeNode buildTree(Map<Integer, Integer> inorderIndexMap, int preorder[], int preStart, int preEnd,  int inorder[], int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = inorderIndexMap.get(preorder[preStart]);
        int inLeftSubTree = rootIndex - inStart;

        root.left = buildTree(inorderIndexMap, preorder, preStart +1, preStart + inLeftSubTree, inorder, inStart, rootIndex -1);
        root.right = buildTree(inorderIndexMap, preorder, preStart + inLeftSubTree +1, preEnd, inorder, rootIndex +1, inEnd);

        return root;
    }
}