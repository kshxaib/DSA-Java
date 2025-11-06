// Problem: Find the Diameter of a Binary Tree
/*
This program constructs a Binary Tree manually and calculates its **diameter**
in an optimized way (O(n) time complexity).

Goal:
- Build a binary tree manually
- Find the diameter (longest path between any two nodes)

Concepts:
1. Diameter Definition:
   - Diameter = Number of nodes on the longest path between any two leaves.
2. Optimized Recursive Approach:
   - Instead of calling height() multiple times, use a single recursive function
     that returns both height and diameter at once.
3. Combined Result Class:
   - A helper class `Info` stores both:
       → `diam` (diameter of the subtree)
       → `height` (height of the subtree)
*/

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
