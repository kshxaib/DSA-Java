import java.util.*;

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode tempNode = stack.pop();
        pushAllLeft(tempNode.right);
        return tempNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode root){
        TreeNode curr = root;

        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
    }
}