// Problem: Transform a Binary Tree to a Sum Tree
/*
This program constructs a Binary Tree manually and transforms it into a **Sum Tree** using **post-order traversal**.

Goal:
- Convert each node’s value to the sum of values of its left and right subtrees in the original tree.
- Leaf nodes become 0 since they have no children.

Concepts:
1. Binary Tree Basics:
   - A Binary Tree is a hierarchical structure where each node has up to two children.
   - Each node contains:
        • data (value)
        • left child reference
        • right child reference

2. What is a Sum Tree?
   - In a Sum Tree, the value of every node is replaced with the sum of the values of its left and right subtrees 
     (in the original tree).
   - Example:

          Original Tree:             Sum Tree:
                1                         27
              /   \                     /   \
             2     3                  9     13
            / \   / \                / \   / \
           4  5  6  7              0  0  0  0

     Explanation:
     - Node(1): 4+5+2 + 6+7+3 = 27
     - Node(2): 4+5 = 9
     - Node(3): 6+7 = 13
     - Leaves (4,5,6,7): become 0

3. Approach (Post-order Traversal):
   - Perform a post-order traversal (left → right → root).
   - For each node:
        • Recursively find the sum of left and right subtrees.
        • Store current node’s original value (tempData).
        • Update node’s value = (sum of values in left + right subtrees + their own node values).
   - Return the original node’s value to its parent so it can calculate the sum properly.

4. Helper Class:
   - `Node`: Represents each node of the binary tree with `data`, `left`, and `right` references.
*/

public class TransformToSumTree {

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

    // Step 2: Recursive function to transform the binary tree into a sum tree
    public static int transformTree(Node root) {
        // Base case: if tree is empty, return 0
        if (root == null) {
            return 0;
        }

        // Recursively transform left and right subtrees
        int leftData = transformTree(root.left);
        int rightData = transformTree(root.right);

        // Store the original data before modification
        int tempData = root.data;

        // Fetch the current data of children (after transformation)
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        // Update current node's value to sum of children's data + their subtree sums
        root.data = (leftData + newLeft) + (rightData + newRight);

        // Return original node's value to parent
        return tempData;
    }

    // Step 3: Preorder traversal to print the updated tree values
    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Step 4: Build tree and test the transform function
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

        // Transform the tree into a Sum Tree
        transformTree(root);

        // Print preorder traversal of the transformed tree
        System.out.print("Preorder Traversal of Sum Tree: ");
        preorderTraversal(root);
    }
}

/*
-------------------------------------------
DRY RUN (Step-by-Step Execution)
-------------------------------------------

Tree before transformation:
            1
          /   \
         2     3
        / \   / \
       4  5  6  7

Post-order traversal order: 4 → 5 → 2 → 6 → 7 → 3 → 1

1. Node(4): Leaf node → new value = 0 → return 4
2. Node(5): Leaf node → new value = 0 → return 5
3. Node(2):
   leftData = 4, rightData = 5
   newLeft = 0, newRight = 0
   new value = (4 + 0) + (5 + 0) = 9
   return 2’s original value = 2

4. Node(6): Leaf node → new value = 0 → return 6
5. Node(7): Leaf node → new value = 0 → return 7
6. Node(3):
   leftData = 6, rightData = 7
   newLeft = 0, newRight = 0
   new value = (6 + 0) + (7 + 0) = 13
   return 3’s original value = 3

7. Node(1):
   leftData = 2, rightData = 3
   newLeft = 9, newRight = 13
   new value = (2 + 9) + (3 + 13) = 27

-------------------------------------------
Final Transformed Tree:
            27
          /   \
         9     13
        / \   / \
       0  0  0  0
-------------------------------------------

Preorder Output:
27 9 0 0 13 0 0

-------------------------------------------
Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(h)
- Recursive stack depends on height of tree (h).
-------------------------------------------
*/
