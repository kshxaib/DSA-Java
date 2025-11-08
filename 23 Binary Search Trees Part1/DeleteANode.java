//Program: Delete a Node from a Binary Search Tree (BST)

public class DeleteANode {

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

    public static Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } 
        else if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } 
        else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) { 
                return root.right;  
            } else if (root.right == null) {
                return root.left;   
            }

            Node inorderSuccessor = findInorderSuccessor(root.right);

            root.data = inorderSuccessor.data;

            root.right = deleteNode(root.right, inorderSuccessor.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;  
        }
        return root;
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
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};   
        Node root = null;                                

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);              
        }

        System.out.print("Inorder Traversal before Deletion: ");
        inorderTraversal(root);
        System.out.println();

        root = deleteNode(root, 1);

        System.out.print("Inorder Traversal after Deletion:  ");
        inorderTraversal(root);
    }
}

/*
Time Complexity:
- Insertion: O(h)
- Deletion: O(h)
- Inorder Traversal: O(n)

Space Complexity:
- O(h) due to recursion stack
*/
