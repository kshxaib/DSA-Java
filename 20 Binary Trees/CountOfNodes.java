public class CountOfNodes {
    static class Node {
        int data;       // Stores the value of the node
        Node left;      // Pointer to left child
        Node right;     // Pointer to right child

        // Constructor to initialize node with given data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        int nodes = (leftNodes + rightNodes) + 1;
        return nodes;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(countNodes(root));
    }
}
