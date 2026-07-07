import java.util.*;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // value -> inorder index
        Map<Integer, Integer> inorderIdxMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderIdxMap.put(inorder[i], i);
        }        

        TreeNode root = buildTree(inorderIdxMap, postorder, 0, postorder.length-1, 
        inorder, 0, inorder.length -1);
        return root;
    }

    private TreeNode buildTree(Map<Integer, Integer> inorderIdxMap, int postorder[], int postStart, int postEnd, 
        int inorder[], int inStart, int inEnd){

        // no node left
        if(postStart > postEnd || inStart > inEnd) return null;

        // postorder last = root
        TreeNode root = new TreeNode(postorder[postEnd]);

        // root index in inorder
        int inRoot = inorderIdxMap.get(postorder[postEnd]);
        // left subtree size
        int inLeftNums = inRoot - inStart;

        // create left subtree
        root.left = buildTree(inorderIdxMap, postorder, postStart, postStart + inLeftNums -1, inorder, inStart, inRoot-1);

        // create right subtree
        root.right = buildTree(inorderIdxMap, postorder, postStart + inLeftNums, postEnd -1, inorder, inRoot +1, inEnd);

        return root;
    }
}



