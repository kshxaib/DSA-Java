// Problem: Print the Kth Level of a Binary Tree

import java.util.*;
import java.util.LinkedList;

public class KthLevel {

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

    public static void printKthLevelRecursive(Node root, int k, int level) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        printKthLevelRecursive(root.left, k, level + 1);
        printKthLevelRecursive(root.right, k, level + 1);
    }

    public static void printKthLevel(Node root, int k){
        if(root == null){
            return;
        }

        int myLvl = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        myLvl++;
        while (!queue.isEmpty()) {
            Node curr = queue.remove();

            if(curr == null){
                if(queue.isEmpty()){
                    break;
                } else{
                    queue.add(null);
                    myLvl++;
                }
            } else{
                if(myLvl == k){
                    System.out.println(curr.data + " ");
                }

                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 1;
        System.out.println("Nodes at Level " + k + ":");
        printKthLevel(root, k);
    }
}

/*
Time Complexity: O(n)
- Each node is visited once during traversal.

Space Complexity: O(h)
- Recursive call stack depth = height (h) of the tree.
*/