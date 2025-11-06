// Problem: Find the Diameter of a Binary Tree

public class DiameterOfTree2 {

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

    static class Info {
        int diam;   
        int height; 

        public Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }
    }

    public static Info findDiameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = findDiameter(root.left);
        Info rightInfo = findDiameter(root.right);

        int selfDiam = leftInfo.height + rightInfo.height + 1;

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), selfDiam);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diam, height);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Info info = findDiameter(root);

        System.out.println("Diameter of the Binary Tree: " + info.diam);
    }
}

/*
Time Complexity: O(n)
- Each node is visited exactly once (no redundant height calls).

Space Complexity: O(h)
- Due to recursion stack, where h = height of the tree.
-------------------------------------------
*/
