/*
-------------------------------------------
Program: Build a Binary Search Tree (BST)
-------------------------------------------

Goal:
- Construct a Binary Search Tree by inserting values one by one.
- Perform Inorder Traversal to print elements in sorted order.

Concepts:
1. Binary Search Tree (BST):
   - A binary tree where:
        • Left child < Parent node
        • Right child > Parent node
   - Used for efficient searching, insertion, and deletion.

2. Inorder Traversal (Left → Root → Right):
   - Traverses all nodes in sorted (ascending) order for BST.

3. Key Steps:
   - Step 1: Create a `Node` class with `data`, `left`, `right`.
   - Step 2: Implement recursive `insert()` to maintain BST property.
   - Step 3: Use `inorderTraversal()` to print the tree in sorted order.
-------------------------------------------
*/

public class BuildABST {

    // Step 1: Define structure of a tree node
    static class Node {
        int data;       // Value of the node
        Node left;      // Reference to left child
        Node right;     // Reference to right child

        // Constructor: initializes data and sets children to null
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

        // If value is smaller, insert in left subtree
        if (root.data > val) {
            root.left = insert(root.left, val);
        } 
        // If value is larger or equal, insert in right subtree
        else {
            root.right = insert(root.right, val);
        }

        // Return unchanged root node
        return root;
    }

    // Step 3: Inorder Traversal (Left → Root → Right)
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);           // Visit left subtree
        System.out.print(root.data + " ");     // Print current node
        inorderTraversal(root.right);          // Visit right subtree
    }

    // Step 4: Main function to build and print BST
    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};     // Values to insert into BST
        Node root = null;                      // Initially empty tree

        // Insert values one by one into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);    // Assign returned root each time
        }

        // Print elements in sorted order
        System.out.print("Inorder Traversal of BST: ");
        inorderTraversal(root);
    }
}

/*
-------------------------------------------
DRY RUN
-------------------------------------------
Insert order: 5 → 1 → 3 → 4 → 2 → 7

Resulting BST:
            5
          /   \
         1     7
          \
           3
          / \
         2   4

Inorder Traversal:
1 2 3 4 5 7

-------------------------------------------
Time Complexity:
- Insertion: O(h) per element (h = height of tree)
- Inorder Traversal: O(n)
Overall: O(n log n) on average, O(n²) in worst case (skewed tree)

Space Complexity: O(h) (due to recursion stack)
-------------------------------------------
*/
