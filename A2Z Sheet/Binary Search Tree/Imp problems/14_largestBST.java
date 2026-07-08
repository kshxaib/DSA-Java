class Solution {
    class NodeInfo {
        int maxVal; // maximum value in subtree
        int minVal; // minimum value in subtree
        int maxSize;// largest BST size

        NodeInfo(int maxVal, int minVal, int maxSize) {
            this.maxVal = maxVal;
            this.minVal = minVal;
            this.maxSize = maxSize;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        return findLargestBST(root).maxSize;
    }

    private NodeInfo findLargestBST(TreeNode root) {
        if (root == null) { // empty tree is BST
            return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        NodeInfo left = findLargestBST(root.left);   // get left subtree information
        NodeInfo right = findLargestBST(root.right);    // get right subtree information

        // valid BST
        if (left.maxVal < root.val && root.val < right.minVal) {
            return new NodeInfo(Math.max(root.val, right.maxVal), Math.min(root.val, left.minVal), 
                1 + left.maxSize + right.maxSize);
        }

        // invalid BST, make parent validation fail
        return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}


