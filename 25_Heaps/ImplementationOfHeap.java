import java.util.*;

public class ImplementationOfHeap {

    static class Heap {
        // Using ArrayList to store heap elements (complete binary tree)
        ArrayList<Integer> list = new ArrayList<>();

        // Insert a new element into the Min-Heap
        public void insert(int data) {
            // Step 1: Insert at the last index
            list.add(data);

            // Step 2: Fix the heap using "bubble up"
            int childIdx = list.size() - 1;
            int parentIdx = (childIdx - 1) / 2;

            // Continue swapping until heap property is restored
            while (childIdx > 0 && list.get(childIdx) < list.get(parentIdx)) {

                // Swap child and parent
                int temp = list.get(childIdx);
                list.set(childIdx, list.get(parentIdx));
                list.set(parentIdx, temp);

                // Move upward
                childIdx = parentIdx;
                parentIdx = (childIdx - 1) / 2;
            }
        }

        // Return the minimum element (root) without removing it
        public int peek() {
            return list.get(0);
        }

        // Heapify function (fixes heap property starting from index i)
        // Used during removal
        public void heapify(int i) {
            int left = 2 * i + 1;   // index of left child
            int right = 2 * i + 2;  // index of right child

            int minIdx = i;  // assume current index is smallest

            // Check if left child exists and is smaller
            if (left < list.size() && list.get(minIdx) > list.get(left)) {
                minIdx = left;
            }

            // Check if right child exists and is smaller
            if (right < list.size() && list.get(minIdx) > list.get(right)) {
                minIdx = right;
            }

            // If a smaller child is found, swap and continue heapifying
            if (minIdx != i) {
                int temp = list.get(i);
                list.set(i, list.get(minIdx));
                list.set(minIdx, temp);

                // Recursively heapify downward
                heapify(minIdx);
            }
        }

        // Remove and return the smallest element (root) from the heap
        public int remove() {
            // Step 1: Swap first and last elements
            int first = list.get(0);
            int last = list.get(list.size() - 1);
            list.set(0, last);
            list.set(list.size() - 1, first);

            // Step 2: Remove the last element (previous root)
            list.remove(list.size() - 1);

            // Step 3: Fix heap using heapify downward
            heapify(0);

            // Return the original root value
            return first;
        }

        // Print heap array representation
        public void printHeap() {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        Heap hp = new Heap();

        hp.insert(2);
        hp.insert(3);
        hp.insert(4);
        hp.insert(5);
        hp.insert(10);
        hp.insert(1);

        hp.printHeap();
    }
}

/*
Time Complexity:
 insert -> O(log n)
 remove -> O(log n)
 peek -> O(1)

Reason:
 - Insertion and deletion involve adjusting tree height (log n levels)
 - Peek only returns root
*/
