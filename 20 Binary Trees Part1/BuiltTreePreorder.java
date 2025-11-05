// Problem: Build Binary Tree from Preorder Traversal

public class BuiltTreePreorder {

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

            // Base case: if current element is -1, return null (no node)
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree BT = new BinaryTree();

        Node root = BT.buildTree(nodes);
        System.out.println("Root node data: " + root.data);
    }
}

/*
Time Complexity: O(n)
- Each element in the array is processed exactly once.

Space Complexity: O(n)
- Due to recursive call stack (in case of skewed tree).
*/
