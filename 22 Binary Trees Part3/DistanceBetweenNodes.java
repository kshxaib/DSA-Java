import java.util.*;
import java.util.LinkedList;

public class DistanceBetweenNodes {

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

     public static Node LCA(Node root, int n1, int n2) {
        // Base case: if tree is empty, return null
        if (root == null) {
            return null;
        }

        // If the current node matches one of the target nodes
        // it may be the LCA (if the other is found below)
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // Recursively find LCA in left and right subtrees
        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        // If both left and right subtrees return non-null,
        // it means one node is found in each subtree → current node is LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If only one side returns non-null, propagate it upward
        if (leftLCA != null) {
            return leftLCA;
        }

        if (rightLCA != null) {
            return rightLCA;
        }

        // If neither subtree contains any target node
        return null;
    }

    public static int countDisFromLCA(Node lca, int n){
        if(lca == null){
            return -1;
        }

        if(lca.data == n){
            return 0;
        }

        int leftDis = countDisFromLCA(lca.left, n);
        int rightDis = countDisFromLCA(lca.right, n);

        if(leftDis == -1 && rightDis == -1){
            return -1;
        } else if(leftDis ==- 1){
            return rightDis+1;
        } else{
            return leftDis+1;
        }
    }

    public static int findMinDis(Node root, int n1, int n2){
        Node lca = LCA(root, n1, n2);
        int dis1 = countDisFromLCA(lca, n1);
        int dis2 = countDisFromLCA(lca, n2);

        return dis1+dis2;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1=4, n2=5;
        System.out.println(findMinDis(root, n1, n2));
    }
}

