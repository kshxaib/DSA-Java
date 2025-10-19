import java.util.*;
import java.util.LinkedList;

public class KthLevel {
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

    public static void printKthLevel(Node root, int k, int level) {
        if(root == null){
            return;
        }

        if(level == k){
            System.out.print(root.data + " ");
        }

        printKthLevel(root.left, k, level +1);
        printKthLevel(root.right, k, level +1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Expected Output for level 3 → 4 5 6 7
        printKthLevel(root, 3, 1);
    }
}
