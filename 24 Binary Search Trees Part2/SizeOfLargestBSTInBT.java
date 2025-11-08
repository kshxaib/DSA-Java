//Program: Find Size of Largest BST in a Binary Tree

public class SizeOfLargestBSTInBT {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Info {
        boolean isBST;  
        int size;   
        int min;     
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0; // Global tracker for largest BST size

    // Recursive function to find largest BST in a BT
    public static Info findLargestBST(Node root) {
        // Base Case: Empty tree is a valid BST
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Get info from left and right subtrees
        Info leftInfo = findLargestBST(root.left);
        Info rightInfo = findLargestBST(root.right);

        // Current subtree size = left.size + right.size + 1
        int size = leftInfo.size + rightInfo.size + 1;

        // Minimum and maximum values in current subtree
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // Check BST property violation
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        // If both subtrees are BSTs, current node can form a BST
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        // Otherwise, not a BST
        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        findLargestBST(root);
        System.out.println("Size of Largest BST in given BT: " + maxBST);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(h)
*/
