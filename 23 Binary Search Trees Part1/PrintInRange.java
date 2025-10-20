/*
-------------------------------------------
Program: Print Nodes in a Given Range from a Binary Search Tree (BST)
-------------------------------------------

Goal:
- Construct a Binary Search Tree (BST) by inserting values.
- Print all nodes whose values lie within a given range [k1, k2].

Concepts:
1. Binary Search Tree (BST):
   - A binary tree where:
        • Left child < Parent node
        • Right child > Parent node
   - Allows efficient range-based searches.

2. Range Printing Logic:
   - For each node, check:
        • If node.data lies in [k1, k2] → print it.
        • If node.data < k1 → explore right subtree (since all left values are smaller).
        • If node.data > k2 → explore left subtree (since all right values are greater).

3. Inorder-Based Traversal:
   - Since Inorder Traversal (Left → Root → Right) prints sorted values,
     this ensures nodes are printed in increasing order.

4. Key Steps:
   - Step 1: Create a `Node` class with `data`, `left`, and `right`.
   - Step 2: Implement `insert()` to build the BST.
   - Step 3: Implement `printInRange()` to print nodes within [k1, k2].
   - Step 4: Test by constructing a BST and printing the result.
-------------------------------------------
*/

public class PrintInRange {

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

    // Step 3: Function to print all nodes in range [k1, k2]
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        // Case 1: Node lies within the range
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);     // Explore left subtree
            System.out.print(root.data + " ");   // Print node
            printInRange(root.right, k1, k2);    // Explore right subtree
        } 
        // Case 2: Node value smaller than k1 → check right subtree only
        else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } 
        // Case 3: Node value greater than k2 → check left subtree only
        else {
            printInRange(root.left, k1, k2);
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

        int k1 = 5, k2 = 12;
        System.out.print("Nodes in range [" + k1 + ", " + k2 + "]: ");
        printInRange(root, k1, k2);
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

Range: [5, 12]

Traversal:
- Start at 8 → lies within [5,12] → print 8
- Left Subtree → explore 5 → within range → print 5
- 3,1,4 < 5 → skipped
- Right Subtree of 8 → explore 10 → within range → print 10
- 11 → within range → print 11
- 14 > 12 → skipped

Output:
5 6 8 10 11

-------------------------------------------
Time Complexity:
- Insertion: O(h)
- Range Printing: O(n) in worst case
(where h = height of BST)
→ O(log n) for balanced tree, O(n) for skewed tree

Space Complexity:
- O(h) due to recursion stack
-------------------------------------------
*/
