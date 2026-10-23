class Solution {
    public int maxPathSum(TreeNode root) {
        int ans[] = new int[1];
        ans[0] = Integer.MIN_VALUE;

        findMaxPath(root, ans);
        return ans[0];
    }

    private int findMaxPath(TreeNode node, int ans[]) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, findMaxPath(node.left, ans));
        int rightSum = Math.max(0, findMaxPath(node.right, ans));

        int currentPathSum = leftSum + rightSum + node.val;
        ans[0] = Math.max(ans[0], currentPathSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}