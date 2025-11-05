// Problem: Level Order Traversal (Breadth-First Search) of a Binary Tree

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
Root node data: 1
Level Order Traversal of the tree:
1 
2 3 
4 5 6

Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(n)
- Due to queue storing nodes of each level.
-------------------------------------------
*/
