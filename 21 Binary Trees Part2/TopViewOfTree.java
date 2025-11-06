// Problem: Print the Top View of a Binary Tree

import java.util.*;
import java.util.LinkedList;

public class TopViewOfTree {

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
        Node node;           
        int horizontalDis;   

        public Info(Node node, int horizontalDis) {
            this.node = node;
            this.horizontalDis = horizontalDis;
        }
    }

    public static void printTopView(Node root) {
        if (root == null) return;

        Queue<Info> queue = new LinkedList<>();

        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        queue.add(new Info(root, 0));
        queue.add(null); 

        while (!queue.isEmpty()) {
            Info curr = queue.remove();

            if (curr == null) {
                // End of current level
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                if (!map.containsKey(curr.horizontalDis)) {
                    map.put(curr.horizontalDis, curr.node);
                }

                if (curr.node.left != null) {
                    queue.add(new Info(curr.node.left, curr.horizontalDis - 1));
                    min = Math.min(min, curr.horizontalDis - 1);
                }

                if (curr.node.right != null) {
                    queue.add(new Info(curr.node.right, curr.horizontalDis + 1));
                    max = Math.max(max, curr.horizontalDis + 1);
                }
            }
        }

        System.out.println("Top View of the Binary Tree:");
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);  
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        printTopView(root);
    }
}

/*
Time Complexity: O(n)
- Each node is processed exactly once in level order traversal.

Space Complexity: O(n)
- Queue and map may hold up to ‘n’ nodes.
*/
