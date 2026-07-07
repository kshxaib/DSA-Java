class Solution {
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        return isValid(root, min, max);     
    }

    private boolean isValid(TreeNode root, long min, long max){
        if(root == null) return true;

        // value outside range
        if(root.val >= max || root.val <= min) return false;
               //left range: min < left < root      //right range: root < right < max
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}

