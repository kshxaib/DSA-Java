//Program: Search a Key in a Binary Search Tree (BST)

public class SearchABST {

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

        // If value is smaller, insert into left subtree
        if (root.data > val) {
            root.left = insert(root.left, val);
        } 
        // If value is larger or equal, insert into right subtree
        else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean isPresent(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return isPresent(root.left, key);
        } 
        else {
            return isPresent(root.right, key);
        }
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);           
        System.out.print(root.data + " ");    
        inorderTraversal(root.right);         
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};    
        Node root = null;                     

        // Insert values one by one into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);    
        }

        System.out.print("Inorder Traversal of BST: ");
        inorderTraversal(root);
        System.out.println();

        int key = 1;
        System.out.println("Searching for key " + key + ": " + isPresent(root, key));
    }
}

/*
Time Complexity:
- Insertion: O(h)
- Searching: O(h)
  (where h = height of BST)
  → O(log n) for balanced tree, O(n) for skewed tree.

Space Complexity:
- O(h) due to recursion stack
*/
