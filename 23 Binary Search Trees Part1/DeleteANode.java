

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

    public static Node deleteNode(Node root, int key){
        if(root.data < key){
            root.right = deleteNode(root.right, key);
        } else if(root.data > key){
            root.left = deleteNode(root.left, key);
        } else {
            //case1: leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            //case1: 1 child
            if(root.left == null){
                return root.right;  
            } else if(root.right == null){
                return root.left;
            }

            //case3: 2 child
            Node inorderSuccessor = findInorderSuccessor(root.right);
            root.data = inorderSuccessor.data;
            root.right = deleteNode(root.right, inorderSuccessor.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
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
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};     // Values to insert into BST
        Node root = null;                      // Initially empty tree

        // Insert values one by one into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);    // Assign returned root each time
        }
        
        inorderTraversal(root);
        System.out.println();
        
        deleteNode(root, 1);
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
