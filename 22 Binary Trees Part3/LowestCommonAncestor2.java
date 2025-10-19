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

3. Approach (Root-to-Node Paths):
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

    public static Node LCA(Node root, int n1, int n2){
        if(root == null){
            return null;
        }

        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        if(rightLCA == null){
            return leftLCA;
        }

        if(leftLCA == null){
            return rightLCA;
        }

        return root;
    }

    // Step 4: Build tree and test function
    public static void main(String args[]) {
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

        int n1 = 4, n2 = 6;

        Node lca = LCA(root, n1, n2);
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
- Space for path lists and recursive stack.
-------------------------------------------
*/