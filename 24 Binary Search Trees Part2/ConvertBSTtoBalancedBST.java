import java.util.*;

public class ConvertBSTtoBalancedBST {

    // Step 1: Define structure of a tree node
    static class Node {
        int data;       // Value of the node
        Node left;      // Reference to left child
        Node right;     // Reference to right child

        // Constructor: initializes node value and sets children to null
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node balancedBST(Node root){
        ArrayList<Integer> nodesData = new ArrayList<>();
        getInorderNodes(root, nodesData);

        root = createBalancedBST(nodesData, 0 , nodesData.size()-1);
        return root;
    }

   public static Node createBalancedBST(ArrayList<Integer> nodesData, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end)/2;
        Node root = new Node(nodesData.get(mid));

        root.left = createBalancedBST(nodesData, start, mid -1);
        root.right = createBalancedBST(nodesData, mid +1, end);

        return root;
   }

    // Step 3: Inorder Traversal (Left → Root → Right)
    public static void getInorderNodes(Node root, ArrayList<Integer> nodesData) {
        if (root == null) {
            return;
        }

        getInorderNodes(root.left, nodesData);
        nodesData.add(root.data);
        getInorderNodes(root.right, nodesData);
    }


    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }

        System.err.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // Step 4: Main function to build and test the balanced BST
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balancedBST(root);
        preOrderTraversal(root);
    }
}
