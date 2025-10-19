// Problem: Print the Kth Level of a Binary Tree
/*
This program constructs a Binary Tree manually and prints all nodes 
present at a specific level 'K' in the tree.

Goal:
- Build a binary tree manually.
- Print all nodes that appear at the Kth level of the tree.

Concepts:
1. Binary Tree Basics:
   - Each node has at most two children: left and right.
   - The first (topmost) level is considered Level 1.

2. What is "Kth Level"?
   - The set of nodes present at depth ‘K’.
   - Example:
          1        → Level 1
         / \
        2   3      → Level 2
       / \ / \
      4  5 6  7    → Level 3
     If K = 3, output should be: 4 5 6 7

3. Approach (Recursive Depth Tracking):
   - Start from the root node with level = 1.
   - Recursively traverse left and right children, increasing the level.
   - When the current level equals K, print the node’s data.

4. Helper Class:
   - `Node`: Represents each node of the binary tree with `data`, `left`, and `right` references.
*/

import java.util.*;
import java.util.LinkedList;

public class KthLevel {

    // Step 1: Define Node structure for Binary Tree
    static class Node {
        int data;    // Value of the node
        Node left;   // Pointer to left child
        Node right;  // Pointer to right child

        // Constructor
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: Recursive function to print nodes at Kth level
    public static void printKthLevel(Node root, int k, int level) {
        // Base case: Empty tree or branch end
        if (root == null) {
            return;
        }

        // Step 3: If current level equals target K, print node data
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        // Step 4: Recur for left and right subtrees with level incremented
        printKthLevel(root.left, k, level + 1);
        printKthLevel(root.right, k, level + 1);
    }

    // Step 5: Build binary tree and test function
    public static void main(String[] args) {
        /*
                    1
                  /   \
                 2     3
                / \   / \
               4  5  6  7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Example: Expected output for level 3 → 4 5 6 7
        System.out.println("Nodes at Level 3:");
        printKthLevel(root, 3, 1);
    }
}

/*
-------------------------------------------
DRY RUN (Step-by-Step Execution)
-------------------------------------------

Tree:
            1
          /   \
         2     3
        / \   / \
       4  5  6  7

Input: k = 3, level = 1 (start from root)

Recursive Traversal Flow:
printKthLevel(1, 3, 1)
 → left -> printKthLevel(2, 3, 2)
     → left -> printKthLevel(4, 3, 3) → prints 4
     → right -> printKthLevel(5, 3, 3) → prints 5
 → right -> printKthLevel(3, 3, 2)
     → left -> printKthLevel(6, 3, 3) → prints 6
     → right -> printKthLevel(7, 3, 3) → prints 7

-------------------------------------------
Final Output:
Nodes at Level 3:
4 5 6 7
-------------------------------------------

Time Complexity: O(n)
- Each node is visited once during traversal.

Space Complexity: O(h)
- Recursive call stack depth = height (h) of the tree.
-------------------------------------------
*/