// Problem: Find the Diameter of a Binary Tree
/*
This program constructs a Binary Tree manually and calculates its **diameter**.

Goal:
- Build a binary tree manually
- Find the diameter (longest path between any two nodes)

Concepts:
1. Diameter Definition:
   - Diameter = Number of nodes on the longest path between any two leaves.
2. Recursive Approach:
   - For each node, calculate:
       - Left Diameter
       - Right Diameter
       - Diameter passing through the current node = leftHeight + rightHeight + 1
   - Return the maximum of the three.
3. Helper Function:
   - findHeight() is used to compute height of subtrees for each node.
*/

public class DiameterOfTree1 {

    // Step 1: Define structure of a Node
    static class Node {
        int data;       // Value of the node
        Node left;      // Pointer to left child
        Node right;     // Pointer to right child

        // Constructor to initialize node with data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: Recursive function to find the height of the binary tree
    public static int findHeight(Node root) {
        // Base Case: If the node is null, height = 0
        if (root == null) {
            return 0;
        }

        // Recursive calls to find height of left and right subtrees
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        // Step 3: Height of current node = 1 + max(leftHeight, rightHeight)
        int height = Math.max(leftHeight, rightHeight) + 1;

        // Return the computed height
        return height;
    }

    // Step 4: Recursive function to find the diameter of the binary tree
    public static int findDiameter(Node root) {
        // Base Case: If tree is empty → diameter = 0
        if (root == null) {
            return 0;
        }

        // Recursively find diameter of left subtree
        int leftDiam = findDiameter(root.left);

        // Find height of left subtree (used for current diameter calculation)
        int leftHeight = findHeight(root.left);
        
        // Recursively find diameter of right subtree
        int rightDiam = findDiameter(root.right);

        // Find height of right subtree
        int rightHeight = findHeight(root.right);

        // Step 5: Diameter passing through current node
        int selfDiam = leftHeight + rightHeight + 1;

        // Step 6: Maximum of all three possible diameters
        int maxDiam = Math.max(selfDiam, Math.max(leftDiam, rightDiam));

        // Return the computed diameter
        return maxDiam;
    }

    // Step 7: Build tree manually and test diameter function
    public static void main(String[] args) {
        // Constructing the tree:
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

        // Print the diameter of the tree
        System.out.println("Diameter of the Binary Tree: " + findDiameter(root));
    }
}

/*
-------------------------------------------
DRY RUN (Step-by-Step Execution)
-------------------------------------------

Tree Structure:
            1
          /   \
         2     3
        / \   / \
       4  5  6  7

Height(4) = 1
Height(5) = 1
Height(2) = max(1,1) + 1 = 2

Height(6) = 1
Height(7) = 1
Height(3) = max(1,1) + 1 = 2

Diameter passing through node 1 = leftHeight + rightHeight + 1 = 2 + 2 + 1 = 5
Other possible diameters (at 2 or 3) = 3

-------------------------------------------
Final Output:
Diameter of the Binary Tree: 5
-------------------------------------------

Time Complexity: O(n^2)
- Because for every node, height is recomputed recursively.

Space Complexity: O(h)
- Due to recursion stack (h = height of the tree).
-------------------------------------------
*/
