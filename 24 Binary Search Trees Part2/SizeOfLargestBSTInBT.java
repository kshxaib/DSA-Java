/*
------------------------------------------------------------
Program: Find Size of Largest BST in a Binary Tree
------------------------------------------------------------

Goal:
- Given a Binary Tree (BT), find the size (number of nodes)
  of the largest subtree that is also a Binary Search Tree (BST).

Concepts:
1. Binary Search Tree (BST) Property:
   - For every node:
        Left subtree values < node’s value < Right subtree values

2. Problem Idea:
   - The given tree might not be a BST itself.
   - But some of its subtrees may satisfy the BST property.
   - We must find the largest such subtree (maximum size BST).

3. Approach:
   - Use **postorder traversal** (Left → Right → Node)
   - For each node, gather info about:
        • Whether its left & right subtrees are BSTs
        • Size of those subtrees
        • Minimum and maximum values in those subtrees

   - Then decide if the current node forms a BST with its children.

4. Define a Helper Class `Info`:
   Each call returns an Info object containing:
        - isBST: whether this subtree is a BST
        - size: number of nodes in this subtree
        - min: smallest value in this subtree
        - max: largest value in this subtree

5. Recursion Logic:
   - Base Case: null node → valid BST of size 0
   - Recursively calculate info for left and right subtrees
   - Combine results:
        if (left.isBST && right.isBST &&
            root.data > left.max && root.data < right.min)
            → It’s a BST. Update global maxBST.
        else → not a BST.

6. Time Complexity:
   - O(n): Each node is visited once.
7. Space Complexity:
   - O(h): Recursion stack (h = height of tree)
------------------------------------------------------------
*/

public class SizeOfLargestBSTInBT {

    // Define structure of a Binary Tree node
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Class to hold information about subtree
    static class Info {
        boolean isBST;  // Whether this subtree is a BST
        int size;       // Size of subtree (number of nodes)
        int min;        // Minimum value in subtree
        int max;        // Maximum value in subtree

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0; // Global tracker for largest BST size

    // Recursive function to find largest BST in a BT
    public static Info findLargestBST(Node root) {
        // Base Case: Empty tree is a valid BST
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Get info from left and right subtrees
        Info leftInfo = findLargestBST(root.left);
        Info rightInfo = findLargestBST(root.right);

        // Current subtree size = left.size + right.size + 1
        int size = leftInfo.size + rightInfo.size + 1;

        // Minimum and maximum values in current subtree
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // Check BST property violation
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        // If both subtrees are BSTs, current node can form a BST
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        // Otherwise, not a BST
        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        /*
                50
              /    \
            30      60
           / \     /  \
          5  20   45  70
                       / \
                     65  80
        */

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        findLargestBST(root);
        System.out.println("Size of Largest BST in given BT: " + maxBST);
    }
}

/*
------------------------------------------------------------
DETAILED DRY RUN (Step-by-Step Execution)
------------------------------------------------------------

Tree structure:
              50
             /  \
           30    60
          / \   / \
         5  20 45 70
                   / \
                 65  80

------------------------------------------------------------
Traversal Order → Postorder (Left → Right → Node)
------------------------------------------------------------

Start from root (50)

1. findLargestBST(5)
   - left = null → returns (true, 0, +∞, -∞)
   - right = null → returns (true, 0, +∞, -∞)
   - size = 0 + 0 + 1 = 1
   - min = 5, max = 5
   - Condition OK → valid BST
   => return (true, 1, 5, 5)
   maxBST = 1

2. findLargestBST(20)
   - Both children null → (true, 1, 20, 20)
   maxBST = 1

3. findLargestBST(30)
   - leftInfo = (true, 1, 5, 5)
   - rightInfo = (true, 1, 20, 20)
   - Check: 30 > left.max(5) and 30 < right.min(20) → FALSE (30 < 20 ❌)
   - So not BST
   => return (false, 3, min=5, max=30)

4. findLargestBST(45)
   - Leaf → (true, 1, 45, 45)
   maxBST = 1

5. findLargestBST(65)
   - Leaf → (true, 1, 65, 65)
   maxBST = 1

6. findLargestBST(80)
   - Leaf → (true, 1, 80, 80)
   maxBST = 1

7. findLargestBST(70)
   - leftInfo = (true, 1, 65, 65)
   - rightInfo = (true, 1, 80, 80)
   - Check: 70 > 65 && 70 < 80 → true
   => valid BST
   - size = 1 + 1 + 1 = 3
   - min = 65, max = 80
   => return (true, 3, 65, 80)
   maxBST = max(1, 3) = 3

8. findLargestBST(60)
   - leftInfo = (true, 1, 45, 45)
   - rightInfo = (true, 3, 65, 80)
   - Check: 60 > 45 && 60 < 65 → true
   => valid BST
   - size = 1 + 3 + 1 = 5
   - min = 45, max = 80
   => return (true, 5, 45, 80)
   maxBST = max(3, 5) = 5

9. findLargestBST(50)
   - leftInfo = (false, 3, 5, 30)
   - rightInfo = (true, 5, 45, 80)
   - Check: 50 > 30 && 50 < 45 → FALSE (50 < 45 ❌)
   => not BST
   => return (false, 9, 5, 80)
   maxBST remains 5

------------------------------------------------------------
FINAL ANSWER:
Size of Largest BST = 5

That BST is the subtree:
          60
         /  \
       45   70
            / \
           65  80
------------------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(h)
*/
