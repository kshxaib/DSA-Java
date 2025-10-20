

public class SearchABST {

    // Step 1: Define structure of a tree node
    static class Node {
        int data;       
        Node left;      
        Node right;     // Reference to right child

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Step 2: Recursive function to insert a value into BST
    public static Node insert(Node root, int val) {
        // Base Case: If tree is empty, create a new node
        if (root == null) {
            root = new Node(val);
            return root;
        }

        // If value is smaller, insert in left subtree
        if (root.data > val) {
            root.left = insert(root.left, val);
        } 
        // If value is larger or equal, insert in right subtree
        else {
            root.right = insert(root.right, val);
        }

        // Return unchanged root node
        return root;
    }

    public static boolean isPresent(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            boolean leftSearch = isPresent(root.left, key);
            return leftSearch;
        } else {
             boolean rightSearch = isPresent(root.left, key);
            return rightSearch;
        } 
    }

    // Step 3: Inorder Traversal (Left → Root → Right)
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);           // Visit left subtree
        System.out.print(root.data + " ");     // Print current node
        inorderTraversal(root.right);          // Visit right subtree
    }

    // Step 4: Main function to build and print BST
    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};     // Values to insert into BST
        Node root = null;                      // Initially empty tree

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);    
        }

        System.out.print(isPresent(root, 1));
    }
}

