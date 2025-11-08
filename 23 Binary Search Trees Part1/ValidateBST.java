// Program: Validate a Binary Search Tree (BST)

import java.util.*;

public class ValidateBST {

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

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } 

        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean isValid(Node root, Node min, Node max) {
        // Base Case: Empty subtree is valid
        if (root == null) {
            return true;
        }

        // Check current node against min and max constraints
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        // Recur for left subtree (max = root) and right subtree (min = root)
        boolean isLeftValid = isValid(root.left, min, root);
        boolean isRightValid = isValid(root.right, root, max);

        // Return true only if both subtrees are valid
        return isLeftValid && isRightValid;
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};  
        Node root = null;                            

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);             
        }

        System.out.println("Is the tree a valid BST? " + isValid(root, null, null));
    }
}

/*
Time Complexity:
- Insertion: O(h)
- Validation: O(n)
(where h = height of BST)

Space Complexity:
- O(h) due to recursion stack
*/
