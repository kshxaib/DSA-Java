class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];

        calHeight(root, diameter);
        return diameter[0];        
    }

    private int calHeight(TreeNode root, int diameter[]){
        if(root == null) return 0;

        int leftHeight = calHeight(root.left, diameter);
        int rightHeight = calHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1+ Math.max(leftHeight, rightHeight);
    }
}