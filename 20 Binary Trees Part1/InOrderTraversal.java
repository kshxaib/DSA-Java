// Problem: Inorder Traversal of a Binary Tree

public class InOrderTraversal {

    static class Node {
        int data;       
        Node left;      
        Node right;     

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {

        public static int index = -1; 

        public static Node buildTree(int nodes[]) {
            index++; 

            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void inorderTraversal(Node root) {
            if(root == null){
                return; 
            }

            inorderTraversal(root.left);   
            System.out.print(root.data + " ");
            inorderTraversal(root.right);  
        }
    }

    public static void main(String[] args) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree BT = new BinaryTree();

        Node root = BT.buildTree(nodes);
        System.out.println("Root node data: " + root.data);

        System.out.println("Inorder Traversal of the tree:");
        BT.inorderTraversal(root); 
    }
}

/*
Time Complexity: O(n)
- n = number of nodes

Space Complexity: O(n)
- Recursive stack for tree traversal (in worst case skewed tree)
*/
