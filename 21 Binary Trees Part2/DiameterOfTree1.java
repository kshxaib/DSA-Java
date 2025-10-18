// Problem: Count the Total Number of Nodes in a Binary Tree
/*
This program constructs a Binary Tree manually and counts the **total number of nodes**
present in the tree using recursion.

Goal:
- Build a binary tree manually
- Use recursion to count all nodes (including root, internal, and leaf nodes)

Concepts:
1. Node Counting Logic:
   - For each node → total nodes = left subtree nodes + right subtree nodes + 1 (for the current node)
2. Base Case:
   - If the node is null → count = 0
3. Recursive Case:
   - Recursively count nodes in left and right subtrees
   - Add 1 for the current node
*/

public class DiameterOfTree1 {

    static class Node {
        int data;       
        Node left;      
        Node right;     

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

    public static int findDiameter(Node root){
        if(root == null){
            return 0;
        }

        int leftDiam = findDiameter(root.left);
        int leftHeight = findHeight(root.left);
        
        int rightDiam = findDiameter(root.right);
        int rightHeight = findHeight(root.right);

        int selfDiam = (leftHeight + rightHeight) + 1;
        int maxDiam  = Math.max(selfDiam, Math.max(leftDiam, rightDiam));

        return maxDiam;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(findDiameter(root));
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

Recursive Process:
countNodes(1)
 → countNodes(2)
     → countNodes(4) → returns 1
     → countNodes(5) → returns 1
     → total = 1 + 1 + 1 = 3
 → countNodes(3)
     → countNodes(6) → returns 1
     → countNodes(7) → returns 1
     → total = 1 + 1 + 1 = 3
 → total = 3 + 3 + 1 = 7

-------------------------------------------
Final Output:
Total number of nodes in the Binary Tree: 7
-------------------------------------------

Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(h)
- Due to recursion stack (h = height of the tree).
-------------------------------------------
*/
