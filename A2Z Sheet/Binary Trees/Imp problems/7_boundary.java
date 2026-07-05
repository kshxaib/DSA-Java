import java.util.*;

class Solution {
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.data = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> boundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        if (!isLeaf(root))
            result.add(root.data);

        addLeftBoundary(result, root);
        addLeaves(result, root);
        addRightBoundary(result, root);

        return result;
    }

    private void addLeftBoundary(List<Integer> result, TreeNode root) {
        TreeNode curr = root.left;

        while (curr != null) {
            if (!isLeaf(curr))
                result.add(curr.data);
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeaves(List<Integer> result, TreeNode root) {
        TreeNode curr = root;

        if (isLeaf(curr)) {
            result.add(curr.data);
            return;
        }

        if (curr.left != null)
            addLeaves(result, curr.left);
        if (curr.right != null)
            addLeaves(result, curr.right);
    }

    private void addRightBoundary(List<Integer> result, TreeNode root) {
        TreeNode curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr))
                temp.add(curr.data);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}