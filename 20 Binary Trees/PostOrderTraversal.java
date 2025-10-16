// Problem: Postorder Traversal of a Binary Tree
/*
This program constructs a Binary Tree from a given preorder array (where -1 represents nulls)
and performs a **Postorder Traversal**.

Goal:
- Build the binary tree from a preorder array
- Traverse it in Postorder (LEFT → RIGHT → ROOT)
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
3. Postorder Traversal:
   - Traverse left subtree recursively
   - Traverse right subtree recursively
   - Visit (print) the root node
*/
   
public class PostOrderTraversal {
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

        // Function to perform Postorder Traversal (LEFT → RIGHT → ROOT)
        public static void postorderTraversal(Node root) {
            if (root == null) {
                return; // Base case: null node
            }

            postorderTraversal(root.left);   // Step 1: Traverse left subtree
            postorderTraversal(root.right);  // Step 2: Traverse right subtree
            System.out.print(root.data + " "); // Step 3: Visit root node
        }
    }

    public static void main(String[] args) {

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree BT = new BinaryTree();
        Node root = BT.buildTree(nodes);
        System.out.println("Root node data: " + root.data);

        System.out.println("Postorder Traversal of the tree:");
        BT.postorderTraversal(root); 
    }
}

/*
-------------------------------------------
DRY RUN (Postorder Traversal Step-by-Step)
-------------------------------------------

Constructed Tree:
            1
          /   \
         2     3
        / \     \
       4   5     6

Postorder Traversal = LEFT → RIGHT → ROOT

Step-by-step:

1. Start at root = 1
   → Traverse left (2)

2. At node 2
   → Traverse left (4)

3. At node 4
   → Traverse left (null) → nothing printed
   → Traverse right (null) → nothing printed
   → Visit 4 → print 4

4. Back to 2
   → Traverse right (5)

5. At node 5
   → Traverse left (null) → nothing printed
   → Traverse right (null) → nothing printed
   → Visit 5 → print 5

6. Back to 2
   → Both subtrees done → Visit 2 → print 2

7. Back to root 1
   → Traverse right (3)

8. At node 3
   → Traverse left (null) → nothing printed
   → Traverse right (6)

9. At node 6
   → Traverse left (null) → nothing printed
   → Traverse right (null) → nothing printed
   → Visit 6 → print 6

10. Back to 3
    → Both subtrees done → Visit 3 → print 3

11. Back to 1
    → Both subtrees done → Visit 1 → print 1

-------------------------------------------
Final Postorder Output:
4 5 2 6 3 1
-------------------------------------------

Explanation:
- Postorder visits left subtree, then right subtree, then root node.
- Each node is visited only after visiting all its children.

Time Complexity: O(n)
- n = number of nodes

Space Complexity: O(n)
- Due to recursive stack (worst case: skewed tree)
-------------------------------------------
*/
