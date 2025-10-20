/*
-------------------------------------------
Program: Merge Two Binary Search Trees (BSTs)
-------------------------------------------

Goal:
- Merge two Binary Search Trees (BSTs) into a single **balanced BST**.

Concepts:
1. Binary Search Tree (BST):
   - A binary tree where every node's left child has a smaller value,
     and the right child has a greater value than the node.

2. Task Overview:
   - Given two BSTs, we want to create one balanced BST that contains
     all elements from both trees in sorted order.

3. Step-by-Step Approach:
   - Step 1: Perform **inorder traversal** on both BSTs to get two sorted arrays.
   - Step 2: Merge these two sorted arrays into a single sorted list.
   - Step 3: Convert the merged sorted array into a balanced BST
             (using the same logic as "sorted array to BST").
   - Step 4: Print the preorder traversal of the final BST to verify structure.

4. Key Functions:
   • getInorder()   → Traverse BST in sorted (inorder) order.
   • mergeBSTs()    → Combine two BSTs into one.
   • createBST()    → Build a balanced BST from sorted array.
   • preorderTraversal() → Display final BST structure.

-------------------------------------------
*/

import java.util.ArrayList;

public class Merge2BSTs {

    // Step 1: Node structure definition
    static class Node {
        int data;       // Value of the node
        Node left;      // Pointer to left child
        Node right;     // Pointer to right child

        // Constructor
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Step 2: Get inorder traversal (sorted order) of a BST
    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        getInorder(root.left, arr);    // Traverse left subtree
        arr.add(root.data);            // Visit root
        getInorder(root.right, arr);   // Traverse right subtree
    }

    // Step 3: Convert a sorted array into a balanced BST
    public static Node createBST(ArrayList<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;   // Middle element becomes root
        Node newNode = new Node(arr.get(mid));

        // Recursively construct left and right subtrees
        newNode.left = createBST(arr, start, mid - 1);
        newNode.right = createBST(arr, mid + 1, end);

        return newNode;
    }

    // Step 4: Merge two BSTs into a balanced BST
    public static Node mergeBSTs(Node root1, Node root2) {
        // Get sorted (inorder) arrays of both BSTs
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Merge the two sorted arrays
        int i = 0, j = 0;
        ArrayList<Integer> mergedArr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                mergedArr.add(arr1.get(i));
                i++;
            } else {
                mergedArr.add(arr2.get(j));
                j++;
            }
        }

        // Add remaining elements from arr1 (if any)
        while (i < arr1.size()) {
            mergedArr.add(arr1.get(i));
            i++;
        }

        // Add remaining elements from arr2 (if any)
        while (j < arr2.size()) {
            mergedArr.add(arr2.get(j));
            j++;
        }

        // Create balanced BST from merged sorted array
        Node root = createBST(mergedArr, 0, mergedArr.size() - 1);
        return root;
    }

    // Step 5: Print preorder traversal (Root → Left → Right)
    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Step 6: Main method to test merging process
    public static void main(String[] args) {
        // First BST
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        // Second BST
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // Merge both BSTs and print preorder traversal
        Node root = mergeBSTs(root1, root2);
        System.out.println("Preorder Traversal of Merged Balanced BST:");
        preorderTraversal(root);
    }
}

/*
-------------------------------------------
DETAILED DRY RUN (FULL EXPLANATION)
-------------------------------------------

Input Trees:

Tree 1:
        2
       / \
      1   4

Tree 2:
        9
       / \
      3   12

-------------------------------------------
Step 1: Inorder Traversal of both trees
-------------------------------------------

BST 1 inorder → [1, 2, 4]
BST 2 inorder → [3, 9, 12]

-------------------------------------------
Step 2: Merge two sorted arrays
-------------------------------------------

Compare elements one by one:

arr1 = [1, 2, 4]
arr2 = [3, 9, 12]

Merged process:
- Compare 1 and 3 → take 1 → merged = [1]
- Compare 2 and 3 → take 2 → merged = [1, 2]
- Compare 4 and 3 → take 3 → merged = [1, 2, 3]
- Compare 4 and 9 → take 4 → merged = [1, 2, 3, 4]
(arr1 exhausted)

Add remaining arr2 → [9, 12]

Final merged array → [1, 2, 3, 4, 9, 12]

-------------------------------------------
Step 3: Create Balanced BST from merged array
-------------------------------------------

Array = [1, 2, 3, 4, 9, 12]
Indexes:  0  1  2  3  4  5

Call 1: createBST(0, 5)
- mid = (0+5)/2 = 2
- root = 3

Left subtree → createBST(0,1)
   mid = 0
   node = 1
   right → createBST(1,1) → node = 2

Right subtree → createBST(3,5)
   mid = 4
   node = 9
   left → createBST(3,3) → node = 4
   right → createBST(5,5) → node = 12

Final Balanced BST:

            3
          /   \
         1     9
          \   / \
           2 4  12

-------------------------------------------
Step 4: Preorder Traversal (Root → Left → Right)
-------------------------------------------

Output order:
3 1 2 9 4 12

-------------------------------------------
TIME COMPLEXITY ANALYSIS
-------------------------------------------
Let n = nodes in BST1, m = nodes in BST2

1. Inorder traversal of both trees → O(n + m)
2. Merging two sorted arrays → O(n + m)
3. Constructing balanced BST from merged array → O(n + m)
4. Traversal for printing → O(n + m)

Total Time Complexity → **O(n + m)**

-------------------------------------------
SPACE COMPLEXITY ANALYSIS
-------------------------------------------
1. Two inorder arrays → O(n + m)
2. Recursion stack during BST creation → O(log(n + m)) (balanced tree)
3. Merged array storage → O(n + m)

Total Space Complexity → **O(n + m)**

-------------------------------------------
*/
