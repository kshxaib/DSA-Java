public class TransformToSumTree {
     static class Node {
        int data;   // Value of the node
        Node left;  // Pointer to left child
        Node right; // Pointer to right child

        // Constructor to initialize node data and children
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }



    public static int transformTree(Node root){
        if(root == null){
            return 0;
        }

        int leftData = transformTree(root.left);
        int rightData = transformTree(root.right);

        int tempData = root.data;
        
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = (leftData + newLeft) + (rightData + newRight);

        return tempData;
    }

    public static void preorderTraversal(Node root){
        if(root == null){
            return;
        } 

        System.out.print(root.data + " ");

        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        /*
                    1
                  /   \
                 2     3
                / \   / \
               4  5  6  7
        */

        // Constructing the binary tree manually
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transformTree(root);
        preorderTraversal(root);
    }
}
