// Problem: Find the Height of a Binary Tree

public class HeightOfTree {

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

    public static int findHeight(Node root) {
        // Base Case: If tree is empty → height = 0
        if (root == null) {
            return 0;
        }

        // Recursive calls to find height of left and right subtrees
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        // Current node height = 1 + max(leftHeight, rightHeight)
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                / \   / \
               4  5  6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Height of the Binary Tree: " + findHeight(root));
    }
}

/*
Time Complexity: O(n)
- Each node is visited once.

Space Complexity: O(h)
- Due to recursive call stack (h = height of tree)
*/
