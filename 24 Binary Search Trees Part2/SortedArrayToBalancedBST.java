/*
-------------------------------------------
Program: Convert Sorted Array to Balanced Binary Search Tree (BST)
-------------------------------------------

Goal:
- Convert a sorted array into a **height-balanced Binary Search Tree (BST)**.
- Perform **inorder traversal** to verify that the BST is correctly constructed.

Concepts:
1. Balanced Binary Search Tree (BST):
   - A BST where the depth of the two subtrees of every node never differs by more than one.
   - Ensures optimal performance for search, insert, and delete operations.

2. Sorted Array to BST Conversion Logic:
   - A **sorted array** represents the inorder traversal of a BST.
   - To build a balanced BST:
        • Pick the middle element as the root.
        • Recursively construct the left subtree from the left half of the array.
        • Recursively construct the right subtree from the right half of the array.

3. Recursive Construction Steps:
   - Base Case: If start > end → return null.
   - Find the middle index → mid = (start + end) / 2.
   - Create a new node with value arr[mid].
   - Recursively call for left and right subtrees.

4. Traversal for Verification:
   - Use **Inorder Traversal (Left → Root → Right)**.
   - For a BST, the inorder output should be in ascending order.

5. Key Steps:
   - Step 1: Create a `Node` class with `data`, `left`, and `right`.
   - Step 2: Implement `createBST()` to build a balanced BST recursively.
   - Step 3: Implement `inorderTraversal()` to verify correctness.
   - Step 4: Test the program using a sorted array.
-------------------------------------------
*/

public class SortedArrayToBalancedBST {

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

    // Step 2: Recursive function to convert sorted array to balanced BST
    public static Node createBST(int arr[], int start, int end) {
        // Base Case: If range is invalid, return null
        if (start > end) {
            return null;
        }

        // Find middle index to ensure balanced tree
        int mid = (start + end) / 2;

        // Create a new node with middle element as root
        Node newNode = new Node(arr[mid]);

        // Recursively build left and right subtrees
        newNode.left = createBST(arr, start, mid - 1);
        newNode.right = createBST(arr, mid + 1, end);

        // Return root of this subtree
        return newNode;
    }

    // Step 3: Inorder Traversal (Left → Root → Right)
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    // Step 4: Main function to build and test the balanced BST
    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12};  // Sorted array input

        // Create balanced BST from sorted array
        Node root = createBST(arr, 0, arr.length - 1);

        // Display inorder traversal (should match the input array)
        System.out.print("Inorder Traversal of Balanced BST: ");
        inorderTraversal(root);
        System.out.println();
    }
}

/*
-------------------------------------------
DETAILED DRY RUN (full recursive steps and index math)
-------------------------------------------

Input:
arr = [3, 5, 6, 8, 10, 11, 12]
start = 0
end   = 6
length = 7

Call #1: createBST(arr, 0, 6)
  - Compute mid = (start + end) / 2 = (0 + 6) / 2 = 6 / 2 = 3
  - arr[mid] = arr[3] = 8
  - Create Node(8)  <-- ROOT

  Now build left subtree of Node(8):
  Call #2: createBST(arr, 0, 2)
    - Compute mid = (0 + 2) / 2 = 2 / 2 = 1
    - arr[1] = 5
    - Create Node(5)

    Build left subtree of Node(5):
    Call #3: createBST(arr, 0, 0)
      - Compute mid = (0 + 0) / 2 = 0 / 2 = 0
      - arr[0] = 3
      - Create Node(3)

      Left of Node(3):
      Call #4: createBST(arr, 0, -1)
        - start = 0, end = -1 → start > end → return null
        => Node(3).left = null

      Right of Node(3):
      Call #5: createBST(arr, 1, 0)
        - start = 1, end = 0 → start > end → return null
        => Node(3).right = null

      Return Node(3)
      (Node(3) is a leaf: left=null, right=null)

    Assign Node(5).left = Node(3)

    Build right subtree of Node(5):
    Call #6: createBST(arr, 2, 2)
      - Compute mid = (2 + 2) / 2 = 4 / 2 = 2
      - arr[2] = 6
      - Create Node(6)

      Left of Node(6):
      Call #7: createBST(arr, 2, 1)
        - start = 2, end = 1 → start > end → return null
        => Node(6).left = null

      Right of Node(6):
      Call #8: createBST(arr, 3, 2)
        - start = 3, end = 2 → start > end → return null
        => Node(6).right = null

      Return Node(6)
      (Node(6) is a leaf)

    Assign Node(5).right = Node(6)

    Return Node(5)
    (Subtree rooted at 5 is complete: left=3, right=6)

  Assign Node(8).left = Node(5)

  Now build right subtree of Node(8):
  Call #9: createBST(arr, 4, 6)
    - Compute mid = (4 + 6) / 2 = 10 / 2 = 5
    - arr[5] = 11
    - Create Node(11)

    Build left subtree of Node(11):
    Call #10: createBST(arr, 4, 4)
      - Compute mid = (4 + 4) / 2 = 8 / 2 = 4
      - arr[4] = 10
      - Create Node(10)

      Left of Node(10):
      Call #11: createBST(arr, 4, 3)
        - start = 4, end = 3 → start > end → return null
        => Node(10).left = null

      Right of Node(10):
      Call #12: createBST(arr, 5, 4)
        - start = 5, end = 4 → start > end → return null
        => Node(10).right = null

      Return Node(10)
      (Node(10) is a leaf)

    Assign Node(11).left = Node(10)

    Build right subtree of Node(11):
    Call #13: createBST(arr, 6, 6)
      - Compute mid = (6 + 6) / 2 = 12 / 2 = 6
      - arr[6] = 12
      - Create Node(12)

      Left of Node(12):
      Call #14: createBST(arr, 6, 5)
        - start = 6, end = 5 → start > end → return null
        => Node(12).left = null

      Right of Node(12):
      Call #15: createBST(arr, 7, 6)
        - start = 7, end = 6 → start > end → return null
        => Node(12).right = null

      Return Node(12)
      (Node(12) is a leaf)

    Assign Node(11).right = Node(12)

    Return Node(11)
    (Subtree rooted at 11 is complete: left=10, right=12)

  Assign Node(8).right = Node(11)

Return Node(8) as full tree root.

-------------------------
Final Tree Structure (visual):
        8
       / \
      5   11
     / \  / \
    3  6 10 12

(Each leaf: 3, 6, 10, 12 have left=null and right=null)

-------------------------------------------
Time Complexity:
- Building BST: O(n) because each element is visited once during tree construction.
- Traversal: O(n)

Space Complexity:
- Recursion stack: O(log n) for a balanced tree (height ≈ log n)
- Additional node objects: O(n)
-------------------------------------------
*/
