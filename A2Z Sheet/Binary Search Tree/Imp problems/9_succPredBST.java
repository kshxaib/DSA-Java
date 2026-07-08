import java.util.*;

class Solution {
    List<Integer> succPredBST(TreeNode root, int key){
        int predecessor = findPredecessor(root, key);
        int successor = findSuccessor(root, key);

        List<Integer> ans = new ArrayList<>();
        ans.add(predecessor);
        ans.add(successor);

        return ans; 
    }

    private int findPredecessor(TreeNode root, int key){
        int ans = -1;
        TreeNode curr = root;

        while(curr != null){
            if(curr.data < key){
                ans = curr.data;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        return ans;
    }

    private int findSuccessor(TreeNode root, int key){
        int ans = -1;
        TreeNode curr = root;

        while(curr != null){
            if(curr.data > key){
                ans = curr.data;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return ans;
    }
}



