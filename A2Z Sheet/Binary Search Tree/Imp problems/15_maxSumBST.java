class Solution {
    int maxSum = 0;

    class NodeInfo {
        int maxVal; // maximum value in subtree
        int minVal; // minimum value in subtree
        int sum;    // current BST sum

        NodeInfo(int maxVal, int minVal, int sum) {
            this.maxVal = maxVal;
            this.minVal = minVal;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        findMaxBST(root);
        return maxSum;
    }

    private NodeInfo findMaxBST(TreeNode root) {
        if (root == null) { // empty tree is BST
            return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        NodeInfo left = findMaxBST(root.left);
        NodeInfo right = findMaxBST(root.right);
        
        if (left.maxVal < root.val && root.val < right.minVal) {    // valid BST
            int currSum = root.val  + left.sum  + right.sum;
            maxSum = Math.max(maxSum, currSum);

            return new NodeInfo(Math.max(root.val, right.maxVal), Math.min(root.val, left.minVal), currSum);
        }

        return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);   // invalid BST
    }
}