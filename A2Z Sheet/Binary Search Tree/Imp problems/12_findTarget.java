import java.util.*;

class Solution {
    class NextIterator {
        Stack<TreeNode> stack = new Stack<>();

        NextIterator(TreeNode root) {
            pushAllLeft(root);
        }

        private void pushAllLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        int next() {
            TreeNode node = stack.pop();
            pushAllLeft(node.right);
            return node.val;
        }

        boolean hasNext() {
            return !stack.isEmpty();
        }
    }

     class PrevIterator {
        Stack<TreeNode> stack = new Stack<>();

        PrevIterator(TreeNode root) {
            pushAllRight(root);
        }

        private void pushAllRight(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
        }

        int prev() {
            TreeNode node = stack.pop();
            pushAllRight(node.left);
            return node.val;
        }

        boolean hasPrev() {
            return !stack.isEmpty();
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        NextIterator left = new NextIterator(root);
        PrevIterator right = new PrevIterator(root);

        int i = left.next();
        int j = right.prev();

        while (i < j) {
            int sum = i + j;

            if (sum == k) {
                return true;
            }

            if (sum < k) {
                if (!left.hasNext()) break;
                i = left.next();
            } else {
                if (!right.hasPrev()) break;
                j = right.prev();
            }
        }

        return false;
    }
}