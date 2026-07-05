class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxSum;
    }

    private int findMaxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Ignore negative paths
        int leftSum = Math.max(0, findMaxPath(node.left));
        int rightSum = Math.max(0, findMaxPath(node.right));

        // Path passing through current node
        int currentPath = leftSum + rightSum + node.val;

        // Update global answer
        maxSum = Math.max(maxSum, currentPath);

        // Return one side path to parent
        return node.val + Math.max(leftSum, rightSum);
    }
}