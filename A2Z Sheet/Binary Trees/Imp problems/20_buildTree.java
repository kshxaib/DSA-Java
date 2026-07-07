import java.util.*;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // value -> inorder index
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }        

        TreeNode root = buildTree(inorderIndexMap, preorder, 0, preorder.length -1,
                            inorder, 0, inorder.length -1);
        return root;
    }

    private TreeNode buildTree(Map<Integer, Integer> inorderIndexMap, 
    int preorder[], int preStart, int preEnd, 
    int inorder[], int inStart, int inEnd){

        // no node available
        if(preStart > preEnd || inStart > inEnd) return null;

        // no node available
        TreeNode root = new TreeNode(preorder[preStart]);

        // root position in inorder
        int inRoot = inorderIndexMap.get(preorder[preStart]);
        // left subtree size
        int inLeftNums = inRoot - inStart;

        // build left subtree
        root.left = buildTree(inorderIndexMap, preorder, preStart +1, preStart + inLeftNums, 
            inorder, inStart, inRoot -1);

        // build right subtree
        root.right = buildTree(inorderIndexMap, preorder, preStart + inLeftNums +1,
            preEnd, inorder, inRoot +1, inEnd);

        return root;
    }
}