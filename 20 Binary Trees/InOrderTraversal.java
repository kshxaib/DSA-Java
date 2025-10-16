// Problem: Inorder Traversal of a Binary Tree
/*
This program constructs a Binary Tree from a given preorder array (where -1 represents nulls)
and performs an **Inorder Traversal**.

Goal:
- Build the binary tree from a preorder array
- Traverse it in Inorder (LEFT → ROOT → RIGHT)
- Print the traversal result

Concepts:
1. Preorder Array with -1:
   - The array represents a preorder traversal of the binary tree
     (ROOT → LEFT → RIGHT)
   - -1 indicates a null node (no child)
2. Binary Tree Construction:
   - Use a static index variable to track the current position in the array
   - Recursively create nodes for non -1 values
   - For -1, return null
3. Inorder Traversal:
   - Traverse left subtree recursively
   - Visit (print) the root
   - Traverse right subtree recursively
*/

public class InOrderTraversal {

    static class Node {
        int data;       
        Node left;      
        Node right;     

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {

        public static int index = -1; 

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

        // Function to perform Inorder Traversal (LEFT → ROOT → RIGHT)
        public static void inorderTraversal(Node root) {
            if(root == null){
                return; // Base case: null node, nothing to print
            }

            inorderTraversal(root.left);   // Step 1: Traverse left subtree
            System.out.print(root.data + " "); // Step 2: Visit root node
            inorderTraversal(root.right);  // Step 3: Traverse right subtree
        }
    }

    public static void main(String[] args) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree BT = new BinaryTree();

        Node root = BT.buildTree(nodes);
        System.out.println("Root node data: " + root.data);

        System.out.println("Inorder Traversal of the tree:");
        BT.inorderTraversal(root); 
    }
}

/*
-------------------------------------------
DRY RUN (Inorder Traversal Step-by-Step)
-------------------------------------------

Constructed Tree:
            1
          /   \
         2     3
        / \     \
       4   5     6

Inorder Traversal = LEFT → ROOT → RIGHT

Step-by-step:

1. Start at root = 1
   → Traverse left (2)

2. At node 2
   → Traverse left (4)

3. At node 4
   → Traverse left (null) → nothing printed
   → Visit 4 → print 4
   → Traverse right (null) → nothing printed

4. Back to 2
   → Visit 2 → print 2
   → Traverse right (5)

5. At node 5
   → Traverse left (null) → nothing printed
   → Visit 5 → print 5
   → Traverse right (null) → nothing printed

6. Back to root 1
   → Visit 1 → print 1
   → Traverse right (3)

7. At node 3
   → Traverse left (null) → nothing printed
   → Visit 3 → print 3
   → Traverse right (6)

8. At node 6
   → Traverse left (null) → nothing printed
   → Visit 6 → print 6
   → Traverse right (null) → nothing printed

-------------------------------------------
Final Inorder Output:
4 2 5 1 3 6
-------------------------------------------

Explanation:
- Traversal visits left child first, then root, then right child.
- Each node is visited exactly once.

Time Complexity: O(n)
- n = number of nodes

Space Complexity: O(n)
- Recursive stack for tree traversal (in worst case skewed tree)
-------------------------------------------
*/
