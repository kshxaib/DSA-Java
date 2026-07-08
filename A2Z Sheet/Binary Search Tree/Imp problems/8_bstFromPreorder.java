class Solution {
    int index = 0;  

    public TreeNode bstFromPreorder(int[] preorder) {
        int up = Integer.MAX_VALUE; // upper bound -> // initially every value is allowed

        return buildBST(preorder, up);  
    }

    private TreeNode buildBST(int preorder[], int up){

        // if array ends OR value crosses allowed limit it does not belong to current subtree
        if(index == preorder.length || preorder[index] > up) return null;

        // preorder current element is root
        TreeNode node = new TreeNode(preorder[index]);
        index++;  // for next element

        // build left subtree all values must be smaller than current node
        node.left = buildBST(preorder, node.val);  
        // build right subtree values can go till ancestor's upper bound
        node.right = buildBST(preorder, up);

        return node;  
    }
}

