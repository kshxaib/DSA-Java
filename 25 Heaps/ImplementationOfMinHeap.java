/*
-------------------------------------------
Program: Min Heap - Insert and Remove Elements
-------------------------------------------

Goal:
- Demonstrate how to **insert** and **remove** elements from a **Min Heap**.
- Maintain heap order during both insertion (up-heapify) and deletion (down-heapify).
- Final output will be in **ascending order** when all elements are removed.

-------------------------------------------
CONCEPTS:
-------------------------------------------

1. **Heap Definition:**
   - A **complete binary tree** where:
     • All levels are completely filled except possibly the last.
     • Nodes follow a specific order property (Min or Max).

   - **Min Heap Property:** 
     Each parent node is **less than or equal to** its children.

   - **Max Heap Property:** 
     Each parent node is **greater than or equal to** its children.

-------------------------------------------
2. **Array Representation of Heap:**
-------------------------------------------
If node index = i
    → Left Child  = 2*i + 1  
    → Right Child = 2*i + 2  
    → Parent      = (i - 1)/2  

-------------------------------------------
3. **Insertion (Up-Heapify):**
-------------------------------------------
Step 1: Add the element at the end (maintains complete tree).
Step 2: Compare it with its parent.
Step 3: If the new element < parent → Swap.
Step 4: Repeat until heap property is restored.

Time Complexity: O(log n)

-------------------------------------------
4. **Deletion (Down-Heapify):**
-------------------------------------------
Step 1: Replace the root with the last element.
Step 2: Remove the last element.
Step 3: Compare new root with its children.
Step 4: If greater than any child → Swap with smaller child.
Step 5: Repeat until heap property is restored.

Time Complexity: O(log n)

-------------------------------------------
*/

import java.util.ArrayList;

public class ImplementationOfMinHeap {

    // Inner class to represent a Min Heap
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>(); // Using ArrayList for dynamic array behavior

        // Add an element to the Min Heap
        public void add(int data) {
            // Step 1: Add new element at the end
            arr.add(data);

            int myIdx = arr.size() - 1;        // Current index
            int parentIdx = (myIdx - 1) / 2;   // Parent index

            // Step 2: Up-heapify process
            while (myIdx > 0 && arr.get(myIdx) < arr.get(parentIdx)) {
                // Swap child and parent
                int temp = arr.get(parentIdx);
                arr.set(parentIdx, arr.get(myIdx));
                arr.set(myIdx, temp);

                // Move up one level
                myIdx = parentIdx;
                parentIdx = (myIdx - 1) / 2;
            }
        }

        // Returns the minimum element (root of the heap)
        public int peek() {
            return arr.get(0);
        }

        // Helper function: Restore heap property after deletion
        private void heapify(int idx) {
            int leftIdx = 2 * idx + 1;
            int rightIdx = 2 * idx + 2;
            int smallestIdx = idx;

            // Compare with left child
            if (leftIdx < arr.size() && arr.get(leftIdx) < arr.get(smallestIdx)) {
                smallestIdx = leftIdx;
            }

            // Compare with right child
            if (rightIdx < arr.size() && arr.get(rightIdx) < arr.get(smallestIdx)) {
                smallestIdx = rightIdx;
            }

            // If the smallest element is not the current node
            if (smallestIdx != idx) {
                // Swap and continue heapify
                int temp = arr.get(idx);
                arr.set(idx, arr.get(smallestIdx));
                arr.set(smallestIdx, temp);

                // Recursive call
                heapify(smallestIdx);
            }
        }

        // Remove and return the minimum element (root)
        public int remove() {
            if (arr.size() == 0) return -1; // Base case: Empty heap

            // Step 1: Swap root with last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step 2: Remove last element (previous root)
            int removedValue = arr.remove(arr.size() - 1);

            // Step 3: Heapify from root to restore heap property
            heapify(0);

            // Return removed root (minimum element)
            return temp;
        }

        // Check if heap is empty
        public boolean isEmpty() {
            return arr.size() == 0;
        }

        // Print heap elements
        public void printHeap() {
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        // Insert elements into the heap
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);

        // Print current heap
        System.out.println("Heap after insertion:");
        heap.printHeap();

        // Remove elements one by one
        System.out.println("\nRemoving elements from Min Heap:");
        while (!heap.isEmpty()) {
            System.out.println(heap.remove());
        }
    }
}

/*
-------------------------------------------
DRY RUN (STEP-BY-STEP)
-------------------------------------------

Insertion sequence: 3, 4, 1, 5

Step 1: Insert 3  
Heap = [3]

Step 2: Insert 4  
→ Compare 4 (child) with 3 (parent)  
→ 4 > 3 → No swap  
Heap = [3, 4]

Step 3: Insert 1  
→ Compare 1 (child) with 3 (parent)  
→ 1 < 3 → Swap  
Heap = [1, 4, 3]

Step 4: Insert 5  
→ Compare 5 (child) with 4 (parent)  
→ 5 > 4 → No swap  
Heap = [1, 4, 3, 5]

Final Min Heap:
            1
           / \
         4    3
        /
       5

-------------------------------------------
REMOVAL (Delete root one by one)
-------------------------------------------

Initial Heap = [1, 4, 3, 5]

Step 1: Remove root (1)
→ Swap 1 with last element (5)
→ Remove last → [5, 4, 3]
→ heapify(0): Compare 5 with 3 → Swap
→ [3, 4, 5]
Output = 1

Step 2: Remove root (3)
→ Swap 3 with 5
→ Remove last → [5, 4]
→ heapify(0): Compare 5 with 4 → Swap
→ [4, 5]
Output = 3

Step 3: Remove root (4)
→ Swap 4 with 5
→ Remove last → [5]
Output = 4

Step 4: Remove root (5)
→ Heap empty
Output = 5

Final Output Order: 1, 3, 4, 5 (Ascending)

-------------------------------------------
TIME COMPLEXITY
-------------------------------------------
Insertion:  O(log n)
Deletion:   O(log n)
Peek:       O(1)
Print:      O(n)

-------------------------------------------
SPACE COMPLEXITY
-------------------------------------------
ArrayList storage: O(n)
Temporary variables: O(1)

Total Space: O(n)
-------------------------------------------
*/
