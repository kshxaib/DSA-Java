
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

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
         else if(root.data < k1){
            printInRange(root.left, k1, k2);
         } else {
            printInRange(root.right, k1, k2);
         }
    }
    
    // Step 5: Main function to build and test the BST
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};   // Values to insert into BST
        Node root = null;                                // Initially empty tree

        // Insert values one by one into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);              // Assign returned root each time
        }

        printInRange(root, 5, 12);
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
