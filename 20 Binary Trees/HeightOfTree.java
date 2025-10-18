// Problem: Find the Height of a Binary Tree
/*
This program constructs a Binary Tree and calculates its **height** using recursion.

Goal:
- Build a binary tree manually in the `main()` function
- Use recursion to find the height of the tree

Concepts:
1. Height of a Binary Tree:
   - Height = Number of nodes in the longest path from the root to a leaf node
   - An empty tree has height = 0
2. Recursive Formula:
   - height = 1 + max(height of left subtree, height of right subtree)
3. Base Case:
   - If the node is null → return 0
*/

public class HeightOfTree {

    // Step 1: Define Node structure
    static class Node {
        int data;       // Stores the value of the node
        Node left;      // Pointer to left child
        Node right;     // Pointer to right child

        // Constructor to initialize node with given data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: Recursive function to find height of the binary tree
    public static int findHeight(Node root) {
        // Base Case: If tree is empty → height = 0
        if (root == null) {
            return 0;
        }

        // Recursive calls to find height of left and right subtrees
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        // Step 3: Current node height = 1 + max(leftHeight, rightHeight)
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    public static void main(String[] args) {

        // Step 4: Manually construct the binary tree
        /*
                    1
                  /   \
                 2     3
                / \   / \
               4  5  6  7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Step 5: Compute and display the height of the tree
        System.out.println("Height of the Binary Tree: " + findHeight(root));
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

Recursive Flow:
findHeight(1)
 → findHeight(2)
     → findHeight(4) → returns 1
     → findHeight(5) → returns 1
     → max(1,1)+1 = 2
 → findHeight(3)
     → findHeight(6) → returns 1
     → findHeight(7) → returns 1
     → max(1,1)+1 = 2
 → max(2,2)+1 = 3

-------------------------------------------
Final Output:
Height of the Binary Tree: 3
-------------------------------------------

Time Complexity: O(n)
- Each node is visited once.

Space Complexity: O(h)
- Due to recursive call stack (h = height of tree)
-------------------------------------------
*/
