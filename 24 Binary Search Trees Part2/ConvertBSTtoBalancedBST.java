//Program: Convert Unbalanced BST to Balanced Binary Search Tree (BST)

import java.util.*;

public class ConvertBSTtoBalancedBST {

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

    public static Node balancedBST(Node root) {
        ArrayList<Integer> nodesData = new ArrayList<>();
        getInorderNodes(root, nodesData);

        root = createBalancedBST(nodesData, 0, nodesData.size() - 1);

        return root;
    }

    public static Node createBalancedBST(ArrayList<Integer> nodesData, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(nodesData.get(mid));

        root.left = createBalancedBST(nodesData, start, mid - 1);
        root.right = createBalancedBST(nodesData, mid + 1, end);

        return root;
    }

    public static void getInorderNodes(Node root, ArrayList<Integer> nodesData) {
        if (root == null) {
            return;
        }

        getInorderNodes(root.left, nodesData);
        nodesData.add(root.data);
        getInorderNodes(root.right, nodesData);
    }

    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balancedBST(root);

        System.out.print("Preorder Traversal of Balanced BST: ");
        preOrderTraversal(root);
        System.out.println();
    }
}

/*
Time Complexity:
- Inorder traversal: O(n)
- Rebuilding balanced BST: O(n)
- Total = O(n)

Space Complexity:
- O(n) for list storage
- O(log n) for recursion (balanced tree height)
*/
