/*
-------------------------------------------
Program: Priority Queue in Java
-------------------------------------------

Goal:
- Demonstrate how to use a **Priority Queue** in Java.
- Show insertion, ordering (based on comparator), and removal operations.

Concepts:
1. **Priority Queue:**
   - A special type of queue where elements are ordered by priority.
   - The element with the **highest priority** (or smallest, depending on comparator)
     is removed first.
   - Implemented as a **heap** internally in Java.

2. **Default Behavior:**
   - By default, Java’s `PriorityQueue` is a **min-heap**, meaning the smallest element
     has the highest priority and is removed first.

3. **Custom Behavior (Max-Heap):**
   - We can reverse this behavior by using:
     `new PriorityQueue<>(Comparator.reverseOrder())`
   - This converts it into a **max-heap**, where the largest element has the highest priority.

4. **Common Operations:**
   • add(E e)     → Inserts an element. (O(log n))
   • remove()     → Removes and returns the head (highest priority element). (O(log n))
   • peek()       → Retrieves (but does not remove) the head element. (O(1))
   • isEmpty()    → Checks if queue is empty. (O(1))

-------------------------------------------
*/

import java.util.*;

public class PriorityQueues {
    public static void main(String[] args) {

        // Step 1: Create a Max-Heap (reverse order)
        // Default PriorityQueue is a Min-Heap; reverseOrder() makes it Max-Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Step 2: Insert elements into the queue
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);

        /*
        Internal Heap Structure (Max-Heap property):
        Elements get rearranged internally to maintain heap order.
        After all insertions → [7, 4, 1, 3] (heap view, not actual array)
        */

        // Step 3: Remove and print elements until the queue becomes empty
        System.out.println("Removing elements in priority order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

        /*
        Removal Order (since Max-Heap):
        7
        4
        3
        1
        */
    }
}

/*
-------------------------------------------
DRY RUN (STEP-BY-STEP)
-------------------------------------------

Initial Queue: (empty)

add(3) → [3]
add(4) → [4, 3]    // 4 is now highest
add(1) → [4, 3, 1]
add(7) → [7, 4, 1, 3]  // 7 is now the root

Now remove elements in priority order:
remove() → 7  → Queue = [4, 3, 1]
remove() → 4  → Queue = [3, 1]
remove() → 3  → Queue = [1]
remove() → 1  → Queue = []

-------------------------------------------
OUTPUT:
-------------------------------------------
Removing elements in priority order:
7
4
3
1

-------------------------------------------
TIME COMPLEXITY ANALYSIS
-------------------------------------------
Let n = number of elements in queue

1. add(E e) → O(log n)
2. remove() → O(log n)
3. peek() → O(1)
4. isEmpty() → O(1)

If we insert and then remove all n elements:
Total Time → O(n log n)

-------------------------------------------
SPACE COMPLEXITY ANALYSIS
-------------------------------------------
- Heap storage → O(n)
- Auxiliary variables → O(1)

Total Space Complexity → **O(n)**
-------------------------------------------
*/
