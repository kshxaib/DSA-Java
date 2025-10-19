// Problem: Find the Lowest Common Ancestor (LCA) of Two Nodes in a Binary Tree
/*
This program constructs a Binary Tree manually and finds the **Lowest Common Ancestor (LCA)** 
of two given nodes.

Goal:
- Build a binary tree manually.
- Find the node that is the lowest (deepest) common ancestor of two given nodes.

Concepts:
1. Binary Tree Basics:
   - Each node can have up to two children: left and right.
   - Nodes are connected hierarchically starting from the root.

2. What is the Lowest Common Ancestor (LCA)?
   - For any two nodes n1 and n2 in a binary tree, the **LCA** is the lowest node 
     (farthest from the root) that has both n1 and n2 as descendants.
   - Example:

              1
            /   \
           2     3
          / \   / \
         4  5  6  7

     For nodes (4, 5) → LCA = 2  
     For nodes (4, 7) → LCA = 1

3. Approach (Using Root-to-Node Paths):
   - Find the path from the root to node n1 and store it in a list (path1).
   - Find the path from the root to node n2 and store it in another list (path2).
   - Traverse both lists until values differ — the last common node before divergence is the LCA.

4. Helper Class:
   - `Node`: Represents each node of the binary tree with `data`, `left`, and `right` references.
*/

import java.util.ArrayList;

public class LowestCommonAncestor2 {

    // Step 1: Define Node structure for Binary Tree
    static class Node {
        int data;    // Value of the node
        Node left;   // Pointer to left child
        Node right;  // Pointer to right child

        // Constructor
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: Function to store path from root to the target node 'n'
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        // Base case: if tree is empty
        if (root == null) {
            return false;
        }

        // Add current node to the path
        path.add(root);

        // If current node matches the target node
        if (root.data == n) {
            return true;
        }

        // Recursively search in left and right subtrees
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        // If node is found in either subtree
        if (foundLeft || foundRight) {
            return true;
        }

        // Otherwise, backtrack (remove last node)
        path.remove(path.size() - 1);
        return false;
    }

    // Step 3: Function to find the Lowest Common Ancestor
    public static Node LCA(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // Find paths from root to both nodes
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // Compare both paths to find the last common node
        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
            i++;
        }

        // i-1 gives the last common node before paths diverge
        Node lca = path1.get(i - 1);
        return lca;
    }

    // Step 4: Build tree and test LCA function
    public static void main(String args[]) {
        /*
                    1
                  /   \
                 2     3
                / \   / \
               4  5  6  7
        */

        // Build tree manually
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Input nodes
        int n1 = 4, n2 = 7;

        // Call LCA function
        Node lca = LCA(root, n1, n2);

        // Output result
        System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + lca.data);
    }
}

/*
-------------------------------------------
DRY RUN (Step-by-Step Execution)
-------------------------------------------

Tree:
            1
          /   \
         2     3
        / \   / \
       4  5  6  7

Input: n1 = 4, n2 = 7

Step 1: Find path1 (root → 4)
path1 = [1, 2, 4]

Step 2: Find path2 (root → 7)
path2 = [1, 3, 7]

Step 3: Compare elements:
i=0 → path1[0]=1, path2[0]=1 → same  
i=1 → path1[1]=2, path2[1]=3 → different → stop  

LCA = path1[i-1] = path1[0] = 1

-------------------------------------------
Final Output:
Lowest Common Ancestor of 4 and 7 is: 1
-------------------------------------------

Time Complexity: O(n)
- Each node is visited once while finding both paths.

Space Complexity: O(n)
- Space for storing paths and recursive stack.
-------------------------------------------
*/
