/*
-------------------------------------------
Program: Print All Root-to-Leaf Paths in a Binary Search Tree (BST)
-------------------------------------------

Goal:
- Construct a Binary Search Tree (BST) by inserting values.
- Print all paths from the root node to each leaf node.

Concepts:
1. Binary Search Tree (BST):
   - A binary tree where:
        • Left child < Parent node
        • Right child > Parent node
   - Helps organize data for efficient searching, insertion, and traversal.

2. Root-to-Leaf Path:
   - A path that starts from the root node and ends at a leaf node.
   - A leaf node is a node with no left or right child.
   - Example:
         Path: 8 → 5 → 3 → 1

3. Logic to Print Paths:
   - Maintain an ArrayList `path` to store the current traversal path.
   - On visiting each node:
        • Add the node’s value to the path.
        • If it’s a leaf node → print the current path.
        • Recursively explore left and right subtrees.
        • Remove the last node while backtracking.

4. Key Steps:
   - Step 1: Create a `Node` class with `data`, `left`, and `right`.
   - Step 2: Implement `insert()` to build the BST.
   - Step 3: Implement `printPaths()` to recursively print all root-to-leaf paths.
   - Step 4: Test by constructing a BST and printing all paths.
-------------------------------------------
*/

import java.util.*;

public class RootToLeafPaths {

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
    
    // Step 3: Function to print all root-to-leaf paths
    public static void printPaths(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        // Add current node to the path
        path.add(root.data);

        // If leaf node reached, print the path
        if (root.left == null && root.right == null) {
            print(path);
            System.out.println();  // New line after each path
        }

        // Recur for left and right subtrees
        printPaths(root.left, path);
        printPaths(root.right, path);

        // Backtrack: remove last added node
        path.remove(path.size() - 1);
    }

    // Helper function to print a path
    public static void print(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
    }
    
    // Step 4: Main function to build and test the BST
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};   // Values to insert into BST
        Node root = null;                                // Initially empty tree

        // Insert values one by one into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);              // Assign returned root each time
        }

        System.out.println("Root-to-Leaf Paths:");
        printPaths(root, new ArrayList<>());
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

Root-to-Leaf Paths:
1. 8 → 5 → 3 → 1
2. 8 → 5 → 3 → 4
3. 8 → 5 → 6
4. 8 → 10 → 11 → 14

-------------------------------------------
Time Complexity:
- Insertion: O(h)
- Path Printing: O(n)
(where h = height of BST)
→ O(log n) for balanced BST, O(n) for skewed tree

Space Complexity:
- O(h) for recursion + O(h) for path list
-------------------------------------------
*/
