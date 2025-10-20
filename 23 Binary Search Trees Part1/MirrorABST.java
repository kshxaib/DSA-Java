/*
-------------------------------------------
Program: Create Mirror of a Binary Search Tree (BST)
-------------------------------------------

Goal:
- Construct a Binary Search Tree (BST) by inserting values.
- Generate its mirror image by swapping left and right subtrees at every node.

Concepts:
1. Binary Search Tree (BST):
   - A binary tree where:
        • Left child < Parent node
        • Right child > Parent node
   - Enables fast insertion, deletion, and search operations.

2. Mirror of a Binary Tree:
   - The mirror of a tree is formed by swapping left and right children of all nodes.
   - For every node:
        • Its left child becomes its right child.
        • Its right child becomes its left child.
   - Note: The mirror of a BST is **not** necessarily a BST.

3. Recursive Mirror Logic:
   - Base Case: If node is null → return null.
   - Recur for left and right subtrees.
   - Swap the returned left and right subtrees.
   - Return the current root.

4. Traversal for Verification:
   - Use **Preorder Traversal** (Root → Left → Right) to display the mirrored tree.
   - Helps verify that the left-right swapping is done correctly.

5. Key Steps:
   - Step 1: Create a `Node` class with `data`, `left`, and `right`.
   - Step 2: Implement `insert()` to build the BST.
   - Step 3: Implement `createMirror()` to form the mirror tree.
   - Step 4: Implement `preorderTraversal()` to print the mirrored tree.
   - Step 5: Test by constructing a BST and printing its mirror.
-------------------------------------------
*/

import java.util.*;

public class MirrorABST {

    // Step 1: Define structure of a tree node
    static class Node {
        int data;       // Value of the node
        Node left;      // Reference to left child
        Node right;     // Reference to right child

        // Constructor: initializes node value and sets children to null
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: Recursive function to insert a value into BST
    public static Node insert(Node root, int val) {
        // Base Case: If tree is empty, create a new node
        if (root == null) {
            root = new Node(val);
            return root;
        }

        // If value is smaller, insert into left subtree
        if (root.data > val) {
            root.left = insert(root.left, val);
        } 
        // If value is larger or equal, insert into right subtree
        else {
            root.right = insert(root.right, val);
        }

        // Return unchanged root node
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

    // Step 4: Preorder Traversal (Root → Left → Right)
    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Step 5: Main function to build, mirror, and test the BST
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};   // Values to insert into BST
        Node root = null;                                // Initially empty tree

        // Insert values one by one into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);              // Assign returned root each time
        }

        // Create mirror of the BST
        root = createMirror(root);

        // Print mirrored BST using preorder traversal
        System.out.print("Preorder traversal of mirrored BST: ");
        preorderTraversal(root);
    }
}

/*
-------------------------------------------
DRY RUN
-------------------------------------------
Insert order: 8, 5, 3, 1, 4, 6, 10, 11, 14

Original BST:
             8
           /   \
          5     10
        /  \      \
       3    6      11
      / \            \
     1   4            14

Mirror BST:
             8
           /   \
         10      5
        /      /  \
      11     6     3
     /           /  \
   14           4    1

Preorder Traversal (Root → Left → Right):
8 10 11 14 5 6 3 4 1

-------------------------------------------
Time Complexity:
- Insertion: O(h)
- Mirror Creation: O(n)
(where h = height of BST, n = total nodes)

Space Complexity:
- O(h) due to recursion stack
-------------------------------------------
*/
