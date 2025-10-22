/*
-------------------------------------------
Program: Insert an Element into a Heap
-------------------------------------------

Goal:
- Demonstrate how to insert elements into a **Max Heap**.
- Show how the **heap property** is maintained after each insertion.

Concepts:
1. **Heap:**
   - A **complete binary tree** where all levels are filled except possibly the last,
     and all nodes follow a specific order property.
   - Two main types:
       • Max-Heap → Parent ≥ Children
       • Min-Heap → Parent ≤ Children

2. **Array Representation of Heap:**
   - For a node at index `i`:
       • Left child index  = `2*i + 1`
       • Right child index = `2*i + 2`
       • Parent index      = `(i - 1) / 2`

3. **Insertion in Max Heap:**
   - Step 1: Insert the new element at the end of the array.
   - Step 2: Compare the inserted element with its parent.
   - Step 3: If it’s larger than the parent, **swap** them.
   - Step 4: Repeat this “up-heapify” process until the heap property is restored.

4. **Time Complexity:**
   - O(log n), where n is the number of elements in the heap.
   - Because at most the height of the heap is traversed during up-heapify.

-------------------------------------------
*/

import java.util.ArrayList;

public class InsertInHeap {

    // Step 1: Create a Heap class to handle heap operations
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>(); // Array representation of heap

        // Step 2: Add element to Max Heap
        public void add(int data) {
            // Step 2.1: Add element at the end (maintains complete tree property)
            arr.add(data);

            int myIdx = arr.size() - 1;         // Index of the newly inserted node
            int parentIdx = (myIdx - 1) / 2;    // Index of its parent

            // Step 2.2: Up-heapify process
            // Keep swapping while inserted element is greater than its parent
            while (myIdx > 0 && arr.get(myIdx) > arr.get(parentIdx)) {
                // Swap parent and child
                int temp = arr.get(parentIdx);
                arr.set(parentIdx, arr.get(myIdx));
                arr.set(myIdx, temp);

                // Move one level up
                myIdx = parentIdx;
                parentIdx = (myIdx - 1) / 2;
            }
        }

        // Step 3: Display current heap elements
        public void printHeap() {
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        // Step 4: Insert elements into the heap
        heap.add(10);
        heap.add(20);
        heap.add(5);
        heap.add(30);

        // Step 5: Print the heap after all insertions
        System.out.println("Heap after insertions (Max-Heap):");
        heap.printHeap();
    }
}

/*
-------------------------------------------
DRY RUN (STEP-BY-STEP)
-------------------------------------------

Insert sequence: 10, 20, 5, 30

Step 1: Insert 10
Heap = [10]
(No parent to compare, heap property maintained)

Step 2: Insert 20
Heap before up-heapify = [10, 20]
Compare 20 (child) with 10 (parent)
20 > 10 → Swap
Heap after swap = [20, 10]

Step 3: Insert 5
Heap before up-heapify = [20, 10, 5]
Compare 5 with 20 → No swap (heap property maintained)
Heap = [20, 10, 5]

Step 4: Insert 30
Heap before up-heapify = [20, 10, 5, 30]
Compare 30 with 10 → Swap → [20, 30, 5, 10]
Compare 30 with 20 → Swap → [30, 20, 5, 10]

Final Heap (Max-Heap):
            30
           /  \
         20    5
        /
      10

-------------------------------------------
OUTPUT:
-------------------------------------------
Heap after insertions (Max-Heap):
[30, 20, 5, 10]

-------------------------------------------
TIME COMPLEXITY ANALYSIS
-------------------------------------------
- Insert (add): O(log n)
  (Each new element may need to move up the height of the heap)
- Print: O(n)

Total → O(log n) per insertion

-------------------------------------------
SPACE COMPLEXITY ANALYSIS
-------------------------------------------
- ArrayList storage → O(n)
- Temporary variables during swap → O(1)

Total Space Complexity → **O(n)**
-------------------------------------------
*/
