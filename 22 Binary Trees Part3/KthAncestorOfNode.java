// Problem: Find the Kth Ancestor of a Node in a Binary Tree

public class KthAncestorOfNode {

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

    public static int findKthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDis = findKthAncestor(root.left, n, k);
        int rightDis = findKthAncestor(root.right, n, k);

        if (leftDis == -1 && rightDis == -1) {
            return -1;
        }

        int max = Math.max(leftDis, rightDis);

        if (max + 1 == k) {
            System.out.println("The " + k + "th ancestor of node " + n + " is: " + root.data);
        }

        return max + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        findKthAncestor(root, 5, 2);
    }
}

/*
Time Complexity: O(n)
- Each node is visited once.

Space Complexity: O(h)
- Recursive stack depends on height of the tree (h).
*/
