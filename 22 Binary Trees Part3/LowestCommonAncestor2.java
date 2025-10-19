// Problem: Find the Lowest Common Ancestor (LCA) of Two Nodes in a Binary Tree
/*
This program constructs a Binary Tree manually and finds the **Lowest Common Ancestor (LCA)** 
of two given nodes using a **recursive approach** (without storing paths).

Goal:
- Build a binary tree manually.
- Recursively find the node that is the lowest (deepest) common ancestor of two given nodes.

Concepts:
1. Binary Tree Basics:
   - Each node can have up to two children: left and right.
   - Nodes are connected hierarchically starting from the root.

2. What is the Lowest Common Ancestor (LCA)?
   - For any two nodes n1 and n2 in a binary tree, the **LCA** is the lowest node 
     (farthest from the root) that has both n1 and n2 as descendants.
   - Example:

              1
            /   \
           2     3
          / \   / \
         4  5  6  7

     For nodes (4, 5) → LCA = 2  
     For nodes (4, 7) → LCA = 1

3. Approach (Recursive Traversal):
   - Base Case: If the current node is null, return null.
   - If the current node matches one of the target nodes (n1 or n2), return it.
   - Recursively search for LCA in the left and right subtrees.
   - Combine results:
       • If both left and right return non-null → current node is the LCA.
       • If only one side returns non-null → propagate that node upward.
       • If both sides return null → propagate null.

4. Helper Class:
   - `Node`: Represents each node of the binary tree with `data`, `left`, and `right` references.
*/

import java.util.ArrayList;

public class LowestCommonAncestor2 {

    // Step 1: Define Node structure for Binary Tree
    static class Node {
        int data;    // Value of the node
        Node left;   // Pointer to left child
        Node right;  // Pointer to right child

        // Constructor to initialize node data and children
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: Recursive function to find the Lowest Common Ancestor
    public static Node LCA(Node root, int n1, int n2) {
        // Base case: if tree is empty, return null
        if (root == null) {
            return null;
        }

        // If the current node matches one of the target nodes
        // it may be the LCA (if the other is found below)
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // Recursively find LCA in left and right subtrees
        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        // If both left and right subtrees return non-null,
        // it means one node is found in each subtree → current node is LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If only one side returns non-null, propagate it upward
        if (leftLCA != null) {
            return leftLCA;
        }

        if (rightLCA != null) {
            return rightLCA;
        }

        // If neither subtree contains any target node
        return null;
    }

    // Step 3: Build the tree and test the LCA function
    public static void main(String args[]) {

        /*
                    1
                  /   \
                 2     3
                / \   / \
               4  5  6  7
        */

        // Constructing the binary tree manually
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Input nodes for which LCA needs to be found
        int n1 = 4, n2 = 6;

        // Find and print the LCA
        Node lca = LCA(root, n1, n2);
        System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + lca.data);
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

Input: n1 = 4, n2 = 6

1. Start at root (1)
   - Not equal to 4 or 6 → search left and right.

2. Go left (2)
   - Not equal to 4 or 6 → search both sides.

3. Left of 2 → Node 4 → matches n1 → return Node(4)
4. Right of 2 → Node 5 → doesn’t match → returns null
   → LeftLCA=4, RightLCA=null → return 4 upward.

5. Go right of root (3)
   - Not equal to 4 or 6 → search both sides.

6. Left of 3 → Node 6 → matches n2 → return Node(6)
7. Right of 3 → Node 7 → no match → null
   → LeftLCA=6, RightLCA=null → return 6 upward.

8. At root (1): LeftLCA=4, RightLCA=6 → both non-null → LCA = 1

-------------------------------------------
Final Output:
Lowest Common Ancestor of 4 and 6 is: 1
-------------------------------------------

Time Complexity: O(n)
- Each node is visited once.

Space Complexity: O(h)
- Recursive stack depends on height of tree (h).
-------------------------------------------
*/