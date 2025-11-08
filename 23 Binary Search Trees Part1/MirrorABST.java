//Program: Create Mirror of a Binary Search Tree (BST)

import java.util.*;

public class MirrorABST {
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

    // Step 3: Recursive function to create mirror of BST
    public static Node createMirror(Node root) {
        // Base Case: If node is null → return null
        if (root == null) {
            return null;
        }

        // Recur for left and right subtrees
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        // Swap left and right subtrees
        root.left = rightMirror;
        root.right = leftMirror;

        // Return root (now mirrored)
        return root;
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
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};   
        Node root = null;                               

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        root = createMirror(root);

        System.out.print("Preorder traversal of mirrored BST: ");
        preorderTraversal(root);
    }
}

/*
Time Complexity:
- Mirror Creation: O(n)

Space Complexity:
- O(h) due to recursion stack
*/
