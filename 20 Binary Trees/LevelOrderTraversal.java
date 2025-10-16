// Problem: Level Order Traversal (Breadth-First Search) of a Binary Tree
/*
This program constructs a Binary Tree from a given preorder array (where -1 represents nulls)
and performs a **Level Order Traversal** (also known as **Breadth-First Search**).

Goal:
- Build the binary tree from a preorder array
- Traverse it level by level (top to bottom, left to right)
- Print each level on a new line

Concepts:
1. Preorder Array with -1:
   - The array represents a preorder traversal of the binary tree
     (ROOT → LEFT → RIGHT)
   - -1 indicates a null node (no child)
2. Binary Tree Construction:
   - Uses recursion and a static index to rebuild the tree
3. Level Order Traversal:
   - Use a **queue** to traverse the tree level by level
   - Enqueue the root node first
   - Use a `null` marker to indicate end of each level
   - Dequeue nodes one by one:
       • Print their data
       • Enqueue their children (if any)
       • When a `null` is found → print a newline and enqueue another `null`
         (if more nodes remain)
*/

import java.util.*;
import java.util.LinkedList;

public class LevelOrderTraversal {

    static class Node {
        int data;       
        Node left;      
        Node right;     

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {

        public static int index = -1; 

        public static Node buildTree(int nodes[]) {
            index++;

            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Function to perform Level Order Traversal (Breadth-First Search)
        public static void levelOrderTraversal(Node root) {
            if (root == null) {
                return; // Empty tree case
            }

            Queue<Node> q = new LinkedList<>(); // Queue for BFS traversal
            q.add(root);    // Add root node to queue
            q.add(null);    // Add null as level separator

            // Traverse until the queue becomes empty
            while (!q.isEmpty()) {
                Node currNode = q.remove();

                // If null encountered → end of current level
                if (currNode == null) {
                    System.out.println(); // Move to next line

                    // If queue still has nodes, add new level separator
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } 
                else {
                    // Print current node's data
                    System.out.print(currNode.data + " ");

                    // Add left and right children to queue (if not null)
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree BT = new BinaryTree();
        Node root = BT.buildTree(nodes);
        System.out.println("Root node data: " + root.data);

        System.out.println("Level Order Traversal of the tree:");
        BT.levelOrderTraversal(root); 
    }
}

/*
-------------------------------------------
DRY RUN (Level Order Traversal Step-by-Step)
-------------------------------------------

Constructed Tree:
            1
          /   \
         2     3
        / \     \
       4   5     6

Traversal Process:

Queue initially: [1, null]

1. Dequeue 1 → print "1"
   → Enqueue 2, 3
   Queue: [null, 2, 3]

2. Dequeue null → end of level
   → Print newline
   → Enqueue another null (since queue not empty)
   Queue: [2, 3, null]

3. Dequeue 2 → print "2"
   → Enqueue 4, 5
   Queue: [3, null, 4, 5]

4. Dequeue 3 → print "3"
   → Enqueue 6
   Queue: [null, 4, 5, 6]

5. Dequeue null → end of level
   → Print newline
   → Enqueue another null (since queue not empty)
   Queue: [4, 5, 6, null]

6. Dequeue 4 → print "4"
   → No children to enqueue
   Queue: [5, 6, null]

7. Dequeue 5 → print "5"
   → No children
   Queue: [6, null]

8. Dequeue 6 → print "6"
   → No children
   Queue: [null]

9. Dequeue null → end of level
   → Queue empty → break

-------------------------------------------
Final Output:

Root node data: 1
Level Order Traversal of the tree:
1 
2 3 
4 5 6
-------------------------------------------

Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(n)
- Due to queue storing nodes of each level.
-------------------------------------------
*/
