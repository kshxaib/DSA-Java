/*
-------------------------------------------
Program: Search a Key in a Binary Search Tree (BST)
-------------------------------------------

Goal:
- Construct a Binary Search Tree by inserting values one by one.
- Search whether a given key is present in the BST or not.

Concepts:
1. Binary Search Tree (BST):
   - A binary tree where:
        • Left child < Parent node
        • Right child > Parent node
   - Efficient searching due to its ordered structure.

2. Searching in BST:
   - If the key is equal to the current node’s data → Found.
   - If the key is smaller → Search in the left subtree.
   - If the key is greater → Search in the right subtree.

3. Key Steps:
   - Step 1: Define `Node` class (data, left, right).
   - Step 2: Insert nodes recursively while maintaining BST property.
   - Step 3: Search for a key using recursive comparison logic.
   - Step 4: Demonstrate the result in the main method.
-------------------------------------------
*/

public class SearchABST {

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

    // Step 3: Recursive function to search for a key in BST
    public static boolean isPresent(Node root, int key) {
        // Base Case 1: If tree is empty → key not found
        if (root == null) {
            return false;
        }

        // Base Case 2: If key matches current node’s value
        if (root.data == key) {
            return true;
        }

        // If key is smaller, search in left subtree
        if (root.data > key) {
            return isPresent(root.left, key);
        } 
        // If key is larger, search in right subtree
        else {
            return isPresent(root.right, key);
        }
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
        int values[] = {5, 1, 3, 4, 2, 7};     // Values to insert into BST
        Node root = null;                      // Initially empty tree

        // Insert values one by one into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);    // Assign returned root each time
        }

        // Display BST (in sorted order)
        System.out.print("Inorder Traversal of BST: ");
        inorderTraversal(root);
        System.out.println();

        // Search for a given key
        int key = 1;
        System.out.println("Searching for key " + key + ": " + isPresent(root, key));
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

Search Process Example (key = 1):
- root = 5 → 1 < 5 → move left
- root = 1 → found → return true

-------------------------------------------
Output:
Inorder Traversal of BST: 1 2 3 4 5 7
Searching for key 1: true
-------------------------------------------

Time Complexity:
- Insertion: O(h)
- Searching: O(h)
  (where h = height of BST)
  → O(log n) for balanced tree, O(n) for skewed tree.

Space Complexity:
- O(h) due to recursion stack
-------------------------------------------
*/
