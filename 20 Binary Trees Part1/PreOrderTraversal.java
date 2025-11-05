// Problem: Preorder Traversal of a Binary Tree

public class PreOrderTraversal {

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

    static class BinaryTree {
        static int index = -1;  

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

        public static void preorderTraversal(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }

            System.out.print(root.data + " ");

            preorderTraversal(root.left);

            preorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree BT = new BinaryTree();

        Node root = BT.buildTree(nodes);

        System.out.println("Root node data: " + root.data);
        System.out.println("Preorder Traversal (with -1 for nulls):");

        BT.preorderTraversal(root);
    }
}

/*
Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(n)
- Due to recursive function call stack.
-------------------------------------------
*/
