// Problem: Find the Kth Ancestor of a Node in a Binary Tree
/*
This program constructs a Binary Tree manually and finds the **Kth Ancestor** 
of a given node using **recursive traversal**.

Goal:
- Build a binary tree manually.
- For a given node `n` and integer `k`, find the ancestor node that is `k` levels above `n`.

Concepts:
1. Binary Tree Basics:
   - A Binary Tree is a hierarchical structure where each node has up to two children.
   - Each node contains:
        • data (value)
        • left child reference
        • right child reference

2. What is a Kth Ancestor?
   - The Kth ancestor of a node is the node that is `k` levels higher in the path from the node to the root.
   - Example:

              1
            /   \
           2     3
          / \   / \
         4  5  6  7

     For node (5):
       • 1st ancestor = 2
       • 2nd ancestor = 1

3. Approach (Recursive Traversal):
   - Recursively search for the target node in the binary tree.
   - When found, return 0 (distance from itself).
   - While backtracking:
       • Increment distance by 1 for each ancestor level.
       • If distance equals `k`, print the current node as the Kth ancestor.

4. Helper Class:
   - `Node`: Represents each node of the binary tree with `data`, `left`, and `right` references.
*/

public class KthAncestorOfNode {

    // Step 1: Define Node structure for Binary Tree
    static class Node {
        int data;   // Value of the node
        Node left;  // Pointer to left child
        Node right; // Pointer to right child

        // Constructor to initialize node data and children
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: Recursive function to find the Kth ancestor of a given node
    public static int findKthAncestor(Node root, int n, int k) {
        // Base case: if tree is empty, return -1
        if (root == null) {
            return -1;
        }

        // If current node matches the target node, return distance 0
        if (root.data == n) {
            return 0;
        }

        // Recursively search in left and right subtrees
        int leftDis = findKthAncestor(root.left, n, k);
        int rightDis = findKthAncestor(root.right, n, k);

        // If the node was not found in either subtree
        if (leftDis == -1 && rightDis == -1) {
            return -1;
        }

        // Find which side returned a valid distance
        int max = Math.max(leftDis, rightDis);

        // If the current node is the Kth ancestor, print it
        if (max + 1 == k) {
            System.out.println("The " + k + "th ancestor of node " + n + " is: " + root.data);
        }

        // Return distance incremented by 1 while backtracking
        return max + 1;
    }

    // Step 3: Build the tree and test the function
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

        // Example: Find 2nd ancestor of node 5 → Expected Output: 1
        findKthAncestor(root, 5, 2);
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

Input: n = 5, k = 2

1. Start from root (1)
   - Not equal to 5 → search left and right.

2. Left subtree (2)
   - Not equal to 5 → search its children.

3. Left of 2 → Node(4) → not match → returns -1
4. Right of 2 → Node(5) → match → returns 0

   → LeftDis = -1, RightDis = 0 → max = 0
   → max + 1 = 1 (not equal to 2) → return 1

5. Back at root (1)
   → LeftDis = 1, RightDis = -1 → max = 1
   → max + 1 = 2 → matches k → print(1)

-------------------------------------------
Final Output:
The 2th ancestor of node 5 is: 1
-------------------------------------------

Time Complexity: O(n)
- Each node is visited once.

Space Complexity: O(h)
- Recursive stack depends on height of the tree (h).
-------------------------------------------
*/
