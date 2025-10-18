// Problem: Check if a Binary Tree is a Subtree of Another Binary Tree
/*
This program constructs two Binary Trees manually and checks if one tree (`subRoot`)
is a **subtree** of the other (`root`) using recursion.

Goal:
- Build two binary trees manually
- Verify whether `subRoot` exists as a subtree within `root`

Concepts:
1. Subtree Definition:
   - A binary tree `subRoot` is considered a subtree of another tree `root`
     if there exists a node in `root` such that the subtree rooted at that node
     is **identical** to `subRoot`.
2. Recursive Approach:
   - For every node in `root`, check:
       → If the subtree starting at that node is identical to `subRoot`.
       → Otherwise, recursively check in left and right subtrees.
3. Helper Function:
   - `isIdentical()` is used to check if two trees are exactly the same.
*/

public class SubtreeOfAnotherTree {

    // Step 1: Define structure of a Node in the binary tree
    static class Node {
        int data;       // Value of the node
        Node left;      // Pointer to left child
        Node right;     // Pointer to right child

        // Constructor to initialize node data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: Helper function to check if two trees are identical
    public static boolean isIdentical(Node node, Node subRoot) {
        // Base Case 1: If both nodes are null → identical
        if (node == null && subRoot == null) {
            return true;
        }

        // Base Case 2: If one is null or data differs → not identical
        else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        // Step 2.1: Recursively check left subtrees
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }

        // Step 2.2: Recursively check right subtrees
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        // Step 2.3: Both subtrees match
        return true;
    }

    // Step 3: Function to check whether subRoot is a subtree of root
    public static boolean isSubtree(Node root, Node subRoot) {
        // Base Case: If main tree is empty → cannot contain a subtree
        if (root == null) {
            return false;
        }

        // Step 3.1: If data matches, check for identical subtree
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // Step 3.2: Recursively check in left and right subtrees
        boolean leftAns = isSubtree(root.left, subRoot);
        boolean rightAns = isSubtree(root.right, subRoot);

        // Step 3.3: Return true if found in either side
        return leftAns || rightAns;
    }

    // Step 4: Build the trees and test the subtree function
    public static void main(String[] args) {
        // Constructing the main tree:
        //            1
        //          /   \
        //         2     3
        //        / \   / \
        //       4  5  6  7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Constructing the subtree:
        //         2
        //        / \
        //       4   5
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        // Step 5: Check if subRoot is a subtree of root
        System.out.println("Is subRoot a subtree of root? " + isSubtree(root, subRoot));
    }
}

/*
-------------------------------------------
DRY RUN (Step-by-Step Execution)
-------------------------------------------

Main Tree (root):
            1
          /   \
         2     3
        / \   / \
       4  5  6  7

SubTree (subRoot):
         2
        / \
       4   5

Execution:
1. Start at root node (1)
   → 1 != 2 → move to left subtree.

2. Now at node (2)
   → 2 == 2 → check if identical trees.

3. Compare:
   Node(2) ↔ Node(2)
   → Left (4 ↔ 4) → true
   → Right (5 ↔ 5) → true
   → Both match → subtree found!

-------------------------------------------
Final Output:
Is subRoot a subtree of root? true
-------------------------------------------

Time Complexity: O(n * m)
- n = number of nodes in the main tree
- m = number of nodes in the subtree
- For every node in `root`, `isIdentical()` may run on `subRoot`.

Space Complexity: O(h)
- Due to recursion stack (h = height of main tree).
-------------------------------------------
*/
