// Problem: Build Binary Tree from Preorder Traversal
/*
This program constructs a Binary Tree from a given preorder traversal array
where '-1' represents a null (no node).

Goal:
Given a preorder traversal array (root → left → right), build the binary tree structure.

Concept:
1. Preorder traversal visits nodes in the order:
   ROOT → LEFT → RIGHT
2. The array contains the node data in preorder form.
3. When we see '-1', it means there is no node (null child).
4. We use a static variable 'index' to keep track of the current position in the array.
5. The recursive function builds the tree using:
   - Create a node for the current element
   - Recursively build its left subtree
   - Recursively build its right subtree

Example Input:
nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}

Expected Tree Structure:
            1
          /   \
         2     3
        / \     \
       4   5     6
*/

public class BuiltTreePreorder {

    // Step 1: Define Node structure
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

    // Step 2: BinaryTree class for tree creation
    static class BinaryTree {
        static int index = -1;  // keeps track of array index

        // Recursive function to build tree
        public static Node buildTree(int nodes[]) {
            index++;  // move to the next element

            // Base case: if current element is -1, return null (no node)
            if (nodes[index] == -1) {
                return null;
            }

            // Create a new node with current data
            Node newNode = new Node(nodes[index]);

            // Recursively build the left subtree
            newNode.left = buildTree(nodes);

            // Recursively build the right subtree
            newNode.right = buildTree(nodes);

            // Return the constructed node
            return newNode;
        }
    }

    public static void main(String[] args) {
        // Preorder traversal input where -1 represents null
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree BT = new BinaryTree();

        // Build the tree and get the root node
        Node root = BT.buildTree(nodes);

        // Print the root data to confirm tree creation
        System.out.println("Root node data: " + root.data);
    }
}

/*
-------------------------------------------
DRY RUN (Step-by-Step Execution)
-------------------------------------------

Input: {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}

We will trace the recursive function calls and tree formation.

---------------------------------------------------------
index | nodes[index] | Action                        | Tree Building Progress
---------------------------------------------------------
 -1   |               | index initialized = -1       |
  0   | 1             | Create node(1)               | root = 1
      |               | build left subtree of 1      |
  1   | 2             | Create node(2)               | 2 is left of 1
      |               | build left subtree of 2      |
  2   | 4             | Create node(4)               | 4 is left of 2
      |               | build left subtree of 4      |
  3   | -1            | return null (no left)        | left of 4 = null
      |               | build right subtree of 4     |
  4   | -1            | return null (no right)       | right of 4 = null
      |               | return node(4)               |
      |               | back to node(2)              |
      |               | build right subtree of 2     |
  5   | 5             | Create node(5)               | 5 is right of 2
      |               | build left subtree of 5      |
  6   | -1            | return null (no left)        | left of 5 = null
      |               | build right subtree of 5     |
  7   | -1            | return null (no right)       | right of 5 = null
      |               | return node(5)               |
      |               | return node(2)               | left subtree of 1 done
      |               | build right subtree of 1     |
  8   | 3             | Create node(3)               | 3 is right of 1
      |               | build left subtree of 3      |
  9   | -1            | return null (no left)        | left of 3 = null
      |               | build right subtree of 3     |
 10   | 6             | Create node(6)               | 6 is right of 3
      |               | build left subtree of 6      |
 11   | -1            | return null (no left)        | left of 6 = null
      |               | build right subtree of 6     |
 12   | -1            | return null (no right)       | right of 6 = null
      |               | return node(6)               |
      |               | return node(3)               |
      |               | return node(1)               |

Final Tree Structure:
            1
          /   \
         2     3
        / \     \
       4   5     6

---------------------------------------------------------
Output:
Root node data: 1
---------------------------------------------------------

Explanation Summary:
- The recursive approach mimics preorder traversal (Root → Left → Right).
- Whenever '-1' is encountered, recursion returns null (no child).
- Each recursive return connects nodes properly to form the final tree.

---------------------------------------------------------
Time Complexity: O(n)
- Each element in the array is processed exactly once.

Space Complexity: O(n)
- Due to recursive call stack (in case of skewed tree).
---------------------------------------------------------
*/
