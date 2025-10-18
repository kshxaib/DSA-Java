// Problem: Count the Total Number of Nodes in a Binary Tree
/*
This program constructs a Binary Tree manually and counts the **total number of nodes**
present in the tree using recursion.

Goal:
- Build a binary tree manually
- Use recursion to count all nodes (including root, internal, and leaf nodes)

Concepts:
1. Node Counting Logic:
   - For each node → total nodes = left subtree nodes + right subtree nodes + 1 (for the current node)
2. Base Case:
   - If the node is null → count = 0
3. Recursive Case:
   - Recursively count nodes in left and right subtrees
   - Add 1 for the current node
*/

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

    // Step 1: Function to count total nodes in the binary tree
    public static int calcSum(Node root){
        if(root  == null){
            return 0;
        }

        int leftSum = calcSum(root.left);
        int rightSum = calcSum(root.right);

        int sum = (leftSum + rightSum) + root.data;
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

        System.out.println("Total number of nodes in the Binary Tree: " + calcSum(root));
    }
}

/*
-------------------------------------------
DRY RUN (Step-by-Step Execution)
-------------------------------------------

Tree Structure:
            1
          /   \
         2     3
        / \   / \
       4  5  6  7

Recursive Process:
countNodes(1)
 → countNodes(2)
     → countNodes(4) → returns 1
     → countNodes(5) → returns 1
     → total = 1 + 1 + 1 = 3
 → countNodes(3)
     → countNodes(6) → returns 1
     → countNodes(7) → returns 1
     → total = 1 + 1 + 1 = 3
 → total = 3 + 3 + 1 = 7

-------------------------------------------
Final Output:
Total number of nodes in the Binary Tree: 7
-------------------------------------------

Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(h)
- Due to recursion stack (h = height of the tree).
-------------------------------------------
*/
