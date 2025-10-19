// Problem: Find the Minimum Distance Between Two Nodes in a Binary Tree
/*
This program constructs a Binary Tree manually and finds the **minimum distance** 
between two given nodes using the concept of the **Lowest Common Ancestor (LCA)**.

Goal:
- Build a binary tree manually.
- Find the Lowest Common Ancestor (LCA) of two given nodes.
- Calculate the distance from the LCA to each node and sum them up to get the total distance.

Concepts:
1. Binary Tree Basics:
   - Each node can have at most two children: left and right.
   - Nodes are hierarchically connected starting from the root.

2. What is the Lowest Common Ancestor (LCA)?
   - For any two nodes n1 and n2, the **LCA** is the lowest (deepest) node that has both n1 and n2 as descendants.
   - Example:

              1
            /   \
           2     3
          / \   / \
         4  5  6  7

     For nodes (4, 5) → LCA = 2  
     For nodes (4, 7) → LCA = 1

3. What is “Distance Between Two Nodes”?
   - Distance = Number of edges in the shortest path connecting the two nodes.
   - Example: 
        Distance(4, 5) = 2 (4 → 2 → 5)
        Distance(4, 6) = 4 (4 → 2 → 1 → 3 → 6)

4. Approach:
   Step 1: Find the LCA of the two nodes.
   Step 2: From the LCA, calculate the distance to n1 and n2 individually.
   Step 3: Add both distances to get the minimum distance between nodes.

   Formula:
      Distance(n1, n2) = Distance(LCA → n1) + Distance(LCA → n2)

5. Helper Class:
   - `Node`: Represents a single node in the binary tree with `data`, `left`, and `right` pointers.
*/

import java.util.*;
import java.util.LinkedList;

public class DistanceBetweenNodes {

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

    // Step 2: Recursive function to find the Lowest Common Ancestor (LCA)
    public static Node LCA(Node root, int n1, int n2) {
        // Base case: if tree is empty, return null
        if (root == null) {
            return null;
        }

        // If current node matches one of the targets, it may be the LCA
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // Recursively search in left and right subtrees
        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        // If both subtrees return non-null, current node is LCA
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

        // If neither subtree contains target nodes
        return null;
    }

    // Step 3: Find distance from LCA to a specific node
    public static int countDisFromLCA(Node lca, int n) {
        if (lca == null) {
            return -1; // node not found in this path
        }

        // If we find the node, distance = 0
        if (lca.data == n) {
            return 0;
        }

        // Recursively check left and right subtrees
        int leftDis = countDisFromLCA(lca.left, n);
        int rightDis = countDisFromLCA(lca.right, n);

        // If node not found in both subtrees
        if (leftDis == -1 && rightDis == -1) {
            return -1;
        } 
        // If found in right subtree
        else if (leftDis == -1) {
            return rightDis + 1;
        } 
        // If found in left subtree
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

    // Step 5: Build the binary tree and test the distance function
    public static void main(String[] args) {
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

        // Example nodes
        int n1 = 4, n2 = 5;

        // Expected distance = 2 (Path: 4 → 2 → 5)
        System.out.println("Minimum Distance between " + n1 + " and " + n2 + " is: " + findMinDis(root, n1, n2));
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

Input: n1 = 4, n2 = 5

Step 1: Find LCA of 4 and 5
   - LCA = 2

Step 2: Find distance from LCA (2) to 4
   countDisFromLCA(2, 4)
     → left = Node(4) → found → distance = 0 → +1 = 1

Step 3: Find distance from LCA (2) to 5
   countDisFromLCA(2, 5)
     → right = Node(5) → found → distance = 0 → +1 = 1

Step 4: Add both distances
   Total Distance = 1 + 1 = 2

-------------------------------------------
Final Output:
Minimum Distance between 4 and 5 is: 2
-------------------------------------------

Time Complexity: O(n)
- Each node is visited once during LCA and distance calculations.

Space Complexity: O(h)
- Recursive stack depth equals height (h) of the binary tree.
-------------------------------------------
*/