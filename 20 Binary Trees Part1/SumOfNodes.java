// Problem: Calculate the Sum of All Nodes in a Binary Tree

public class SumOfNodes {

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

    public static int calcSum(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = calcSum(root.left);
        int rightSum = calcSum(root.right);

        int sum = leftSum + rightSum + root.data;
        return sum;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Sum of all nodes in the Binary Tree: " + calcSum(root));
    }
}

/*
Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(h)
- Due to recursion stack (h = height of the tree).
*/
