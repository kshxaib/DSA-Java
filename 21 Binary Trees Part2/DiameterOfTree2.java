// Problem: Find the Diameter of a Binary Tree
/*
This program constructs a Binary Tree manually and calculates its **diameter**
in an optimized way (O(n) time complexity).

Goal:
- Build a binary tree manually
- Find the diameter (longest path between any two nodes)

Concepts:
1. Diameter Definition:
   - Diameter = Number of nodes on the longest path between any two leaves.
2. Optimized Recursive Approach:
   - Instead of calling height() multiple times, use a single recursive function
     that returns both height and diameter at once.
3. Combined Result Class:
   - A helper class `Info` stores both:
       → `diam` (diameter of the subtree)
       → `height` (height of the subtree)
*/

public class DiameterOfTree2 {

    // Step 1: Define the structure of a Node in the binary tree
    static class Node {
        int data;       // Data stored in the node
        Node left;      // Pointer to left child
        Node right;     // Pointer to right child

        // Constructor to initialize node data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: (Optional) Helper function to find the height of a tree
    // This function is NOT used in the optimized approach.
    // It’s kept only for reference to understand traditional methods.
    public static int findHeight(Node root) {
        // Base Case: If tree is empty → height = 0
        if (root == null) {
            return 0;
        }

        // Recursive calls to find height of left and right subtrees
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        // Height of current node = 1 + max(leftHeight, rightHeight)
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    // Step 3: Helper class to store both diameter and height for each node
    static class Info {
        int diam;   // Diameter of the subtree
        int height; // Height of the subtree

        // Constructor to initialize both fields
        public Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }
    }

    // Step 4: Optimized recursive function to find both diameter and height
    public static Info findDiameter(Node root) {
        // Base Case: If tree is empty → diameter and height are both 0
        if (root == null) {
            return new Info(0, 0);
        }

        // Step 4.1: Recursively get Info (diameter + height) for left and right subtrees
        Info leftInfo = findDiameter(root.left);
        Info rightInfo = findDiameter(root.right);

        // Step 4.2: Compute the diameter passing through current node
        // Formula: leftHeight + rightHeight + 1
        int selfDiam = leftInfo.height + rightInfo.height + 1;

        // Step 4.3: The maximum diameter among left, right, and current
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), selfDiam);

        // Step 4.4: Height of current node = 1 + max(leftHeight, rightHeight)
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        // Step 4.5: Return Info containing both computed diameter and height
        return new Info(diam, height);
    }

    // Step 5: Build the tree manually and test the diameter function
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

        // Step 6: Call the optimized function
        Info info = findDiameter(root);

        // Step 7: Print the final diameter of the binary tree
        System.out.println("Diameter of the Binary Tree: " + info.diam);
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

Recursive Process:

For Node 4:
 - Left = null → (diam=0, height=0)
 - Right = null → (diam=0, height=0)
 - selfDiam = 0 + 0 + 1 = 1
 - height = max(0,0)+1 = 1
 → returns (diam=1, height=1)

Similarly for Node 5, 6, 7 → each returns (1,1)

For Node 2:
 - LeftInfo = (1,1), RightInfo = (1,1)
 - selfDiam = 1+1+1=3
 - height = 2
 → returns (diam=3, height=2)

For Node 3:
 - LeftInfo = (1,1), RightInfo = (1,1)
 - selfDiam = 1+1+1=3
 - height = 2
 → returns (diam=3, height=2)

For Node 1:
 - LeftInfo = (3,2), RightInfo = (3,2)
 - selfDiam = 2+2+1=5
 - height = 3
 → returns (diam=5, height=3)

-------------------------------------------
Final Output:
Diameter of the Binary Tree: 5
-------------------------------------------

Time Complexity: O(n)
- Each node is visited exactly once (no redundant height calls).

Space Complexity: O(h)
- Due to recursion stack, where h = height of the tree.
-------------------------------------------
*/
