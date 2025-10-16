// Problem: Preorder Traversal of a Binary Tree
/*
This program performs a **Preorder Traversal** on a binary tree
constructed from a given preorder array (where -1 represents null).

Goal:
- Visit all nodes of a binary tree using Preorder traversal.
- Print the traversal order including -1 for null nodes (for clarity).

Concept:
1. Preorder Traversal Order: ROOT → LEFT → RIGHT
2. The traversal starts from the root node.
3. For every node:
   - Visit (print) the node’s data.
   - Recursively traverse the left subtree.
   - Recursively traverse the right subtree.
4. When the node is null, print `-1` to represent a missing child.

Example Tree used:
            1
          /   \
         2     3
        / \     \
       4   5     6

Expected Preorder Output:
1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1
*/

public class PreOrderTraversal {

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
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorderTraversal(Node root) {
            // Base case: if node is null, print -1 (no child)
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }

            // Step 1: Visit the root node (print data)
            System.out.print(root.data + " ");

            // Step 2: Traverse the left subtree
            preorderTraversal(root.left);

            // Step 3: Traverse the right subtree
            preorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree BT = new BinaryTree();

        Node root = BT.buildTree(nodes);

        System.out.println("Root node data: " + root.data);
        System.out.println("Preorder Traversal (with -1 for nulls):");

        BT.preorderTraversal(root);
    }
}

/*
-------------------------------------------
DRY RUN (Traversal Step-by-Step)
-------------------------------------------

Constructed Tree:
            1
          /   \
         2     3
        / \     \
       4   5     6

-------------------------------------------
Preorder Traversal = ROOT → LEFT → RIGHT
-------------------------------------------

Start from root = 1

1. Visit 1 → print "1"
   → Move to left (2)

2. Visit 2 → print "2"
   → Move to left (4)

3. Visit 4 → print "4"
   → Move to left (null) → print "-1"
   → Move to right (null) → print "-1"

4. Back to 2 → Move to right (5)
   Visit 5 → print "5"
   → Move to left (null) → print "-1"
   → Move to right (null) → print "-1"

5. Back to 1 → Move to right (3)
   Visit 3 → print "3"
   → Move to left (null) → print "-1"
   → Move to right (6)
      Visit 6 → print "6"
      → Move to left (null) → print "-1"
      → Move to right (null) → print "-1"

-------------------------------------------
Final Output:
1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1
-------------------------------------------

Explanation:
- The traversal exactly matches the input preorder array.
- The -1s confirm where null children exist.

-------------------------------------------
Time Complexity: O(n)
- Each node is visited exactly once.

Space Complexity: O(n)
- Due to recursive function call stack.
-------------------------------------------
*/
