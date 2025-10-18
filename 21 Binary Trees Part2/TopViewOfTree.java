import java.util.*;
import java.util.LinkedList;

public class TopViewOfTree {

    static class Node {
        int data;       // Value of the node
        Node left;      // Pointer to left child
        Node right;     // Pointer to right child

        // Constructor to initialize node data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        Node node;
        int horizontalDis;

        public Info(Node node, int horizontalDis){
            this.node = node;
            this.horizontalDis = horizontalDis;
        }
    }

    public static void printTopView(Node root){
        //Level Order traversal
        Queue<Info> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min=0;
        int max=0;

        queue.add(new Info(root, 0));
        queue.add(null);

        while (!queue.isEmpty()) {
            Info curr = queue.remove();
            if(curr == null){
                if(queue.isEmpty()){
                    break;
                } else {
                    queue.add(null);
                }
            } else{
                if(!map.containsKey(curr.horizontalDis)){
                    map.put(curr.horizontalDis, curr.node);
                }

                if(curr.node.left != null){
                    queue.add(new Info(curr.node.left, curr.horizontalDis -1));
                    min = Math.min(min, curr.horizontalDis -1);
                }

                if(curr.node.right != null){
                    queue.add(new Info(curr.node.right, curr.horizontalDis +1));
                    max = Math.max(max, curr.horizontalDis +1);
                }
            }
        }

        for(int i=min; i<=max; i++){
            int data = map.get(i).data;
            System.out.println(data);
        }
    }

    public static void main(String[] args) {
        // Constructing the main tree:
        //            1
        //          /   \
        //         2     3
        //        / \   / \
        //       4  5  6  7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printTopView(root);
    }   
}

/*
-------------------------------------------
DRY RUN (Step-by-Step Execution)
-------------------------------------------

Main Tree (root):
            1
          /   \
         2     3
        / \   / \
       4  5  6  7

SubTree (subRoot):
         2
        / \
       4   5

Execution:
1. Start at root node (1)
   → 1 != 2 → move to left subtree.

2. Now at node (2)
   → 2 == 2 → check if identical trees.

3. Compare:
   Node(2) ↔ Node(2)
   → Left (4 ↔ 4) → true
   → Right (5 ↔ 5) → true
   → Both match → subtree found!

-------------------------------------------
Final Output:
Is subRoot a subtree of root? true
-------------------------------------------

Time Complexity: O(n * m)
- n = number of nodes in the main tree
- m = number of nodes in the subtree
- For every node in `root`, `isIdentical()` may run on `subRoot`.

Space Complexity: O(h)
- Due to recursion stack (h = height of main tree).
-------------------------------------------
*/
