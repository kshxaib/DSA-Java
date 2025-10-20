/*
-------------------------------------------
Program: Validate a Binary Search Tree (BST)
-------------------------------------------

Goal:
- Construct a Binary Search Tree (BST) by inserting values.
- Check whether the constructed tree satisfies the BST property.

Concepts:
1. Binary Search Tree (BST):
   - A binary tree where:
        • Left child < Parent node
        • Right child > Parent node
   - Allows efficient searching, insertion, and deletion.

2. BST Validation Logic:
   - For each node, recursively check:
        • All nodes in the left subtree < node.data
        • All nodes in the right subtree > node.data
   - Use min and max constraints while traversing the tree.

3. Recursive Approach:
   - For each node:
        • If node is null → return true (base case)
        • Check node.data against min and max constraints
        • Recur for left and right subtrees with updated constraints
        • Return true only if both left and right subtrees are valid

4. Key Steps:
   - Step 1: Create a `Node` class with `data`, `left`, and `right`.
   - Step 2: Implement `insert()` to build the BST.
   - Step 3: Implement `isValid()` to validate the BST.
   - Step 4: Test by constructing a BST and printing the validation result.
-------------------------------------------
*/

import java.util.*;

public class ValidateBST {

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

    // Step 3: Recursive function to validate BST
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

    // Step 4: Helper function to print a path (optional)
    public static void print(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
    }

    // Step 5: Main function to build and test the BST
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};   // Values to insert into BST
        Node root = null;                                // Initially empty tree

        // Insert values one by one into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);              // Assign returned root each time
        }

        // Validate BST and print result
        System.out.println("Is the tree a valid BST? " + isValid(root, null, null));
    }
}

/*
-------------------------------------------
DRY RUN
-------------------------------------------
Insert order: 8, 5, 3, 1, 4, 6, 10, 11, 14

BST Structure:
             8
           /   \
          5     10
        /  \      \
       3    6      11
      / \            \
     1   4            14

Validation:
- Start at root (8) with min=null, max=null → OK
- Left Subtree: check 5 with min=null, max=8 → OK
  - Left of 5: check 3 with min=null, max=5 → OK
  - Right of 5: check 6 with min=5, max=8 → OK
- Right Subtree: check 10 with min=8, max=null → OK
  - Right of 10: check 11 with min=10, max=null → OK
  - Right of 11: check 14 with min=11, max=null → OK

Output:
Is the tree a valid BST? true

-------------------------------------------
Time Complexity:
- Insertion: O(h)
- Validation: O(n)
(where h = height of BST)

Space Complexity:
- O(h) due to recursion stack
-------------------------------------------
*/
