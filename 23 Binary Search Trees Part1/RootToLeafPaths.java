//Program: Print All Root-to-Leaf Paths in a Binary Search Tree (BST)

import java.util.*;

public class RootToLeafPaths {

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

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } 
        else {
            root.right = insert(root.right, val);
        }

        return root;
    }
    
    public static void printPaths(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            print(path);
            System.out.println();  
        }

        printPaths(root.left, path);
        printPaths(root.right, path);

        path.remove(path.size() - 1);
    }

    public static void print(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
    }
    
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};   
        Node root = null;                           

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);             
        }

        System.out.println("Root-to-Leaf Paths:");
        printPaths(root, new ArrayList<>());
    }
}

/*
Time Complexity:
- Path Printing: O(n)

Space Complexity:
- O(h) for recursion + O(h) for path list
*/
