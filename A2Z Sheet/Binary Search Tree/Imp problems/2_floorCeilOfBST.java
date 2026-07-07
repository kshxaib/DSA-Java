/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/
import java.util.*;

class Solution {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        int floor = findFloor(root, key);
        int ceil = findCeil(root, key);

        List<Integer> ans = new ArrayList<>();

        ans.add(floor);
        ans.add(ceil);

        return ans;
    }

    private int findFloor(TreeNode root, int key){
        int ans = -1;
        TreeNode curr = root;

        while(curr != null){
            if(curr.data <= key){
                ans = curr.data;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        return ans;
    }

    private int findCeil(TreeNode root, int key){
        int ans = -1;
        TreeNode curr = root;

        while(curr != null){
            if(curr.data >= key){
                ans = curr.data;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return ans;
    }
}