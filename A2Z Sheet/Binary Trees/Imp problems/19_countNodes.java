import java.util.*;

// BRUTE
class Solution1 {
    public int countNodes(TreeNode root) {
        int count = 0;
        count = inorder(root, count);
        return count;
    }

    private int inorder(TreeNode root, int count) {
        if (root == null) return 0;

        int left = inorder(root.left, count);
        int right = inorder(root.right, count);

        return 1 + left + right;
    }
}


// OPTIMAL
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lHeight = getHeightLeft(root);
        int rHeight = getHeightRight(root);

        if(lHeight == rHeight){
           return (1 << lHeight) - 1;
        } 

        else return countNodes(root.left) + countNodes(root.right) +1;
    }

    private int getHeightLeft(TreeNode root){
        int count = 0;

        while(root != null){
            count++;
            root = root.left;
        }

        return count;
    }
    private int getHeightRight(TreeNode root){
        int count = 0;

        while(root != null){
            count++;
            root = root.right;
        }

        return count;
    }
}