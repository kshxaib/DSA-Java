// Problem: Find the Diameter of a Binary Tree

public class DiameterOfTree1 {

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
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }

    public static int findDiameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiam = findDiameter(root.left);
        int leftHeight = findHeight(root.left);
        
        int rightDiam = findDiameter(root.right);
        int rightHeight = findHeight(root.right);

        int selfDiam = leftHeight + rightHeight + 1;
        int maxDiam = Math.max(selfDiam, Math.max(leftDiam, rightDiam));

        return maxDiam;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Diameter of the Binary Tree: " + findDiameter(root));
    }
}

/*
Time Complexity: O(n^2)
- Because for every node, height is recomputed recursively.

Space Complexity: O(h)
- Due to recursion stack (h = height of the tree).
*/
