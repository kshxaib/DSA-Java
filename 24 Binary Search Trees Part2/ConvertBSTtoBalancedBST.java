/*
-------------------------------------------
Program: Convert Unbalanced BST to Balanced Binary Search Tree (BST)
-------------------------------------------

Goal:
- Convert an existing **unbalanced BST** into a **height-balanced BST**.
- Use inorder traversal to collect sorted data (since inorder of BST is always sorted).
- Rebuild a new balanced BST from this sorted list.

-------------------------------------------
Concepts:

1. Balanced Binary Search Tree (BST):
   - A BST where the depth difference between left and right subtrees of every node 
     is not more than 1.
   - Balanced BST improves search, insertion, and deletion efficiency to O(log n).

2. Conversion Steps:
   - Step 1: Perform an inorder traversal of the BST.
             (This produces a sorted list of node values.)
   - Step 2: Use this sorted list to build a new balanced BST.
             (Middle element becomes root, recursively build left and right.)
   - Step 3: Return the new root and verify by traversal.

3. Key Recursive Functions:
   a) `getInorderNodes(root, list)` → stores inorder traversal in a list.
   b) `createBalancedBST(list, start, end)` → builds balanced BST from list.
   c) `balancedBST(root)` → main function that combines both steps.

4. Traversal for Verification:
   - Preorder traversal is used to display the final balanced BST.

5. Steps Overview:
   - Step 1: Create Node structure.
   - Step 2: Perform inorder traversal and store elements.
   - Step 3: Construct balanced BST using recursive divide and conquer.
   - Step 4: Test using a skewed (unbalanced) BST as input.
-------------------------------------------
*/

import java.util.*;

public class ConvertBSTtoBalancedBST {

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

    // Step 2: Main function to convert an existing BST to balanced BST
    public static Node balancedBST(Node root) {
        // Step 2.1: Store inorder traversal (sorted sequence)
        ArrayList<Integer> nodesData = new ArrayList<>();
        getInorderNodes(root, nodesData);

        // Step 2.2: Build balanced BST from sorted list
        root = createBalancedBST(nodesData, 0, nodesData.size() - 1);

        // Step 2.3: Return new root of balanced BST
        return root;
    }

    // Step 3: Recursive function to build balanced BST from sorted data
    public static Node createBalancedBST(ArrayList<Integer> nodesData, int start, int end) {
        // Base case: invalid range
        if (start > end) {
            return null;
        }

        // Find middle element → root of this subtree
        int mid = (start + end) / 2;
        Node root = new Node(nodesData.get(mid));

        // Recursively build left and right subtrees
        root.left = createBalancedBST(nodesData, start, mid - 1);
        root.right = createBalancedBST(nodesData, mid + 1, end);

        // Return root of this subtree
        return root;
    }

    // Step 4: Inorder Traversal (Left → Root → Right) to store sorted values
    public static void getInorderNodes(Node root, ArrayList<Integer> nodesData) {
        if (root == null) {
            return;
        }

        getInorderNodes(root.left, nodesData);
        nodesData.add(root.data);
        getInorderNodes(root.right, nodesData);
    }

    // Step 5: Preorder Traversal (Root → Left → Right) for final verification
    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // Step 6: Main function to test conversion
    public static void main(String[] args) {
        // Create an unbalanced BST (left-heavy + right-heavy mix)
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        // Convert to balanced BST
        root = balancedBST(root);

        // Print final balanced BST (Preorder Traversal)
        System.out.print("Preorder Traversal of Balanced BST: ");
        preOrderTraversal(root);
        System.out.println();
    }
}

/*
-------------------------------------------
DETAILED DRY RUN (Step-by-Step Execution)
-------------------------------------------

Initial Tree (Unbalanced BST):
            8
           / \
          6   10
         /      \
        5        11
       /           \
      3             12

-------------------------------------------
Step 1: Inorder Traversal (getInorderNodes)

→ Inorder traversal gives sorted order for BST.

Traversal Path:
Left → Root → Right

Order of Visits:
3 → 5 → 6 → 8 → 10 → 11 → 12

So, nodesData = [3, 5, 6, 8, 10, 11, 12]

-------------------------------------------
Step 2: Build Balanced BST using createBalancedBST()

Call #1: createBalancedBST(list, 0, 6)
   - mid = (0 + 6) / 2 = 3
   - root = 8
   => Left: (0,2)
   => Right: (4,6)

Call #2: createBalancedBST(list, 0, 2)
   - mid = (0 + 2) / 2 = 1
   - root = 5
   => Left: (0,0)
   => Right: (2,2)

   Call #3: createBalancedBST(list, 0, 0)
      - mid = 0
      - root = 3
      - left=null, right=null
      → return Node(3)

   Call #4: createBalancedBST(list, 2, 2)
      - mid = 2
      - root = 6
      - left=null, right=null
      → return Node(6)

   Node(5).left = Node(3)
   Node(5).right = Node(6)
   → return Node(5)

Call #5: createBalancedBST(list, 4, 6)
   - mid = (4 + 6) / 2 = 5
   - root = 11
   => Left: (4,4)
   => Right: (6,6)

   Call #6: createBalancedBST(list, 4, 4)
      - mid = 4
      - root = 10
      - left=null, right=null
      → return Node(10)

   Call #7: createBalancedBST(list, 6, 6)
      - mid = 6
      - root = 12
      - left=null, right=null
      → return Node(12)

   Node(11).left = Node(10)
   Node(11).right = Node(12)
   → return Node(11)

Finally:
Node(8).left = Node(5)
Node(8).right = Node(11)

-------------------------------------------
Final Balanced BST Structure:
            8
           / \
          5   11
         / \  / \
        3  6 10 12

-------------------------------------------
Step 3: Preorder Traversal Output (Root → Left → Right)

8 → 5 → 3 → 6 → 11 → 10 → 12

Output:
Preorder Traversal of Balanced BST: 8 5 3 6 11 10 12

-------------------------------------------
Time Complexity:
- Inorder traversal: O(n)
- Rebuilding balanced BST: O(n)
- Total = O(n)

Space Complexity:
- O(n) for list storage
- O(log n) for recursion (balanced tree height)

-------------------------------------------
*/
