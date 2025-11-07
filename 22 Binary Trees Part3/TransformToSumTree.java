// Problem: Transform a Binary Tree to a Sum Tree

/*
3. Approach (Post-order Traversal):
   - Perform a post-order traversal (left → right → root).
   - For each node:
        • Recursively find the sum of left and right subtrees.
        • Store current node’s original value (tempData).
        • Update node’s value = (sum of values in left + right subtrees + their own node values).
   - Return the original node’s value to its parent so it can calculate the sum properly.
*/

public class TransformToSumTree {

    static class Node {
        int data;   
        Node left; 
        Node right; 

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int transformTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftData = transformTree(root.left);
        int rightData = transformTree(root.right);

        int tempData = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = (leftData + newLeft) + (rightData + newRight);

        return tempData;
    }

    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transformTree(root);

        System.out.print("Preorder Traversal of Sum Tree: ");
        preorderTraversal(root);
    }
}

/*
Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(h)
- Recursive stack depends on height of tree (h).
*/
