/*
-------------------------------------------
Program: Delete a Node from a Binary Search Tree (BST)
-------------------------------------------

Goal:
- Construct a Binary Search Tree by inserting values one by one.
- Delete a specific node (key) from the BST.
- Perform Inorder Traversal to verify the tree structure after deletion.

Concepts:
1. Binary Search Tree (BST):
   - A binary tree where:
        • Left child < Parent node
        • Right child > Parent node
   - Enables efficient searching, insertion, and deletion.

2. Node Deletion Cases:
   - Case 1: Node is a leaf (no children) → simply remove it.
   - Case 2: Node has one child → replace node with its child.
   - Case 3: Node has two children → 
       • Find its Inorder Successor (smallest node in right subtree)
       • Replace node’s value with successor’s value
       • Recursively delete the successor

3. Inorder Traversal (Left → Root → Right):
   - Prints nodes in ascending order for a BST.

4. Key Steps:
   - Step 1: Create a `Node` class with `data`, `left`, `right`.
   - Step 2: Implement `insert()` to build the BST.
   - Step 3: Implement `deleteNode()` for deletion logic.
   - Step 4: Implement `inorderTraversal()` to display tree contents.
-------------------------------------------
*/

public class DeleteANode {

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

    // Step 3: Delete a node from BST based on key
    public static Node deleteNode(Node root, int key) {
        // Base Case: If tree is empty
        if (root == null) {
            return null;
        }

        // If key is smaller, search in left subtree
        if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } 
        // If key is larger, search in right subtree
        else if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } 
        // Node to be deleted found
        else {
            // Case 1: Node is a leaf (no children)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has only one child
            if (root.left == null) { 
                return root.right;   // Replace with right child
            } else if (root.right == null) {
                return root.left;    // Replace with left child
            }

            // Case 3: Node has two children
            // Find inorder successor (smallest node in right subtree)
            Node inorderSuccessor = findInorderSuccessor(root.right);

            // Replace data with inorder successor’s data
            root.data = inorderSuccessor.data;

            // Delete inorder successor from right subtree
            root.right = deleteNode(root.right, inorderSuccessor.data);
        }

        return root;
    }

    // Step 3.1: Helper function to find inorder successor
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;   // Move to the leftmost node
        }
        return root;
    }

    // Step 4: Inorder Traversal (for verification)
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);           // Visit left subtree
        System.out.print(root.data + " ");     // Print current node
        inorderTraversal(root.right);          // Visit right subtree
    }

    // Step 5: Main function to build and test the BST
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};   // Values to insert into BST
        Node root = null;                                // Initially empty tree

        // Insert values one by one into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);              // Assign returned root each time
        }

        System.out.print("Inorder Traversal before Deletion: ");
        inorderTraversal(root);
        System.out.println();

        // Delete node with key = 1
        root = deleteNode(root, 1);

        System.out.print("Inorder Traversal after Deletion:  ");
        inorderTraversal(root);
    }
}

/*
-------------------------------------------
DRY RUN
-------------------------------------------
Insert order: 8, 5, 3, 1, 4, 6, 10, 11, 14

Initial BST:
             8
           /   \
          5     10
        /  \      \
       3    6      11
      / \            \
     1   4            14

Deleting key = 1
- 1 < 8 → go left
- 1 < 5 → go left
- 1 < 3 → go left → found node (leaf) → delete

Resulting BST after deletion:
             8
           /   \
          5     10
        /  \      \
       3    6      11
        \            \
         4            14

Inorder Traversal:
3 4 5 6 8 10 11 14

-------------------------------------------
Time Complexity:
- Insertion: O(h)
- Deletion: O(h)
- Inorder Traversal: O(n)
(where h = height of BST)
→ O(log n) for balanced BST, O(n) for skewed tree

Space Complexity:
- O(h) due to recursion stack
-------------------------------------------
*/
