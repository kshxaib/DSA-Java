class Solution {
    TreeNode first; // first violation
    TreeNode middle;// middle one if the nodes are adjacent
    TreeNode last;  // second violation
    TreeNode prev;  // to compare current val with previous val

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE); // initialize previous node

        inorder(root);  // detect swapped nodes

        if(first != null && last != null){   // non-adjacent swap
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if(first != null && middle != null && last == null){ // adjacent swap
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        // inorder should be sorted
        if(root.val < prev.val){
            if(first == null){ // if this is 1st violation, mark these two nodes 'first' and 'middle'
                first = prev;
                middle = root;
            } else {    // if this is second violation, mark this to 2nd violation
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }
}