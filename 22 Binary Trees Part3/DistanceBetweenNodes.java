// Problem: Find the Minimum Distance Between Two Nodes in a Binary Tree

import java.util.*;
import java.util.LinkedList;

public class DistanceBetweenNodes {

    static class Node {
        int data;    
        Node left;   
        Node right;  

        // Constructor
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

    public static int countDisFromLCA(Node lca, int n) {
        if (lca == null) {
            return -1; 
        }

        if (lca.data == n) {
            return 0;
        }

        int leftDis = countDisFromLCA(lca.left, n);
        int rightDis = countDisFromLCA(lca.right, n);

        if (leftDis == -1 && rightDis == -1) {
            return -1;
        } 

        else if (leftDis == -1) {
            return rightDis + 1;
        } 

        else {
            return leftDis + 1;
        }
    }

    // Step 4: Combine both parts — find LCA and calculate distance
    public static int findMinDis(Node root, int n1, int n2) {
        Node lca = LCA(root, n1, n2);
        int dis1 = countDisFromLCA(lca, n1); // distance from LCA to n1
        int dis2 = countDisFromLCA(lca, n2); // distance from LCA to n2

        return dis1 + dis2; // total distance
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;

        System.out.println("Minimum Distance between " + n1 + " and " + n2 + " is: " + findMinDis(root, n1, n2));
    }
}

/*
Time Complexity: O(n)
- Each node is visited once during LCA and distance calculations.

Space Complexity: O(h)
- Recursive stack depth equals height (h) of the binary tree.
*/