// Problem: Print the Top View of a Binary Tree
/*
This program constructs a Binary Tree manually and prints its **Top View**.

Goal:
- Build a binary tree manually
- Print the top view nodes (visible from above the tree)

Concepts:
1. Top View Definition:
   - The Top View of a binary tree includes the nodes visible when the tree 
     is viewed from the top.
   - For each vertical line (horizontal distance from root), only the 
     **first node encountered** from top (level order) is part of the top view.

2. Approach (Level Order Traversal + HashMap):
   - Perform a level order traversal using a queue.
   - Keep track of each node's **horizontal distance (HD)** from the root.
   - Store the first node encountered for each HD in a HashMap.
   - After traversal, print nodes from the smallest to largest HD.

3. Helper Classes:
   - `Node`: Represents a binary tree node.
   - `Info`: Stores a node along with its HD for level order traversal.
*/

import java.util.*;
import java.util.LinkedList;

public class TopViewOfTree {

    // Step 1: Define structure of a Node in the binary tree
    static class Node {
        int data;       // Value of the node
        Node left;      // Pointer to left child
        Node right;     // Pointer to right child

        // Constructor to initialize node data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: Helper class to store node with its horizontal distance
    static class Info {
        Node node;           // Current node
        int horizontalDis;   // Horizontal distance (HD) from root

        public Info(Node node, int horizontalDis) {
            this.node = node;
            this.horizontalDis = horizontalDis;
        }
    }

    // Step 3: Function to print Top View of the Binary Tree
    public static void printTopView(Node root) {
        // Base Case: If tree is empty, no top view exists
        if (root == null) return;

        // Queue for Level Order Traversal (BFS)
        Queue<Info> queue = new LinkedList<>();

        // Map to store the first node at each horizontal distance
        HashMap<Integer, Node> map = new HashMap<>();

        // Track the minimum and maximum horizontal distances
        int min = 0, max = 0;

        // Initialize queue with root node (HD = 0)
        queue.add(new Info(root, 0));
        queue.add(null); // Marker for level separation

        // Step 4: Perform Level Order Traversal
        while (!queue.isEmpty()) {
            Info curr = queue.remove();

            if (curr == null) {
                // End of current level
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                // Step 5: Add node to map if it's the first node at this HD
                if (!map.containsKey(curr.horizontalDis)) {
                    map.put(curr.horizontalDis, curr.node);
                }

                // Step 6: Traverse left child (HD - 1)
                if (curr.node.left != null) {
                    queue.add(new Info(curr.node.left, curr.horizontalDis - 1));
                    min = Math.min(min, curr.horizontalDis - 1);
                }

                // Step 7: Traverse right child (HD + 1)
                if (curr.node.right != null) {
                    queue.add(new Info(curr.node.right, curr.horizontalDis + 1));
                    max = Math.max(max, curr.horizontalDis + 1);
                }
            }
        }

        // Step 8: Print the top view nodes from min to max HD
        System.out.println("Top View of the Binary Tree:");
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    // Step 9: Build the tree and test the top view function
    public static void main(String[] args) {
        // Constructing the binary tree:
        //            1
        //          /   \
        //         2     3
        //        / \   / \
        //       4  5  6  7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Print the Top View of the tree
        printTopView(root);
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

Horizontal Distances (HD):
        4(-2)
        2(-1)
        1(0)
        3(+1)
        7(+2)

Level Order Traversal Sequence:
(1,0) → (2,-1), (3,+1) → (4,-2), (5,0), (6,0), (7,+2)

Top View (first node for each HD):
HD = -2 → 4  
HD = -1 → 2  
HD =  0 → 1  
HD = +1 → 3  
HD = +2 → 7  

-------------------------------------------
Final Output:
Top View of the Binary Tree:
4 2 1 3 7
-------------------------------------------

Time Complexity: O(n)
- Each node is processed exactly once in level order traversal.

Space Complexity: O(n)
- Queue and map may hold up to ‘n’ nodes.
-------------------------------------------
*/
