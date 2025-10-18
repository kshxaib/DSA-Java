// Problem: Calculate the Sum of All Nodes in a Binary Tree
/*
This program constructs a Binary Tree manually and calculates the **sum of all nodes**
present in the tree using recursion.

Goal:
- Build a binary tree manually
- Use recursion to compute the sum of all node values

Concepts:
1. Node Sum Logic:
   - For each node → total sum = sum of left subtree + sum of right subtree + current node’s value
2. Base Case:
   - If the node is null → contribute 0 to the sum
3. Recursive Case:
   - Recursively calculate sums of left and right subtrees
   - Add current node’s data to total
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

    // Step 1: Function to calculate the sum of all nodes in the binary tree
    public static int calcSum(Node root) {
        // Base Case: Empty tree contributes 0 to the sum
        if (root == null) {
            return 0;
        }

        // Recursive calls to calculate sum of left and right subtrees
        int leftSum = calcSum(root.left);
        int rightSum = calcSum(root.right);

        // Step 2: Total sum = left sum + right sum + current node value
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
calcSum(1)
 → calcSum(2)
     → calcSum(4) → returns 4
     → calcSum(5) → returns 5
     → total = 4 + 5 + 2 = 11
 → calcSum(3)
     → calcSum(6) → returns 6
     → calcSum(7) → returns 7
     → total = 6 + 7 + 3 = 16
 → total = 11 + 16 + 1 = 28

-------------------------------------------
Final Output:
Sum of all nodes in the Binary Tree: 28
-------------------------------------------

Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(h)
- Due to recursion stack (h = height of the tree).
-------------------------------------------
*/
