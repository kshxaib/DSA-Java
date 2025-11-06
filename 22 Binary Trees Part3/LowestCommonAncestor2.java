// Problem: Find the Lowest Common Ancestor (LCA) of Two Nodes in a Binary Tree

import java.util.ArrayList;

public class LowestCommonAncestor2 {

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

    public static Node LCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        if (leftLCA != null) {
            return leftLCA; 
        }

        if (rightLCA != null) {
            return rightLCA; 
        }

        return null;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 6;

        Node lca = LCA(root, n1, n2);
        System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + lca.data);
    }
}

/*
Time Complexity: O(n)
- Each node is visited once.

Space Complexity: O(h)
- Recursive stack depends on height of tree (h).
*/