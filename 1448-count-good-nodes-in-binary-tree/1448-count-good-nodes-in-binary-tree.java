class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);        
    }

    private int dfs(TreeNode node, int maxTillNow){
        if(node == null) return 0;

        int count = 0;

        if(node.val >= maxTillNow){
            count = 1;
            maxTillNow = node.val;
        }

        // maxTillNow = Math.max(maxTillNow, node.val);

        count += dfs(node.left, maxTillNow); 
        count += dfs(node.right, maxTillNow); 

        return count;
    }
}