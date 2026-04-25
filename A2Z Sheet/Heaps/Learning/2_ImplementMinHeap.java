/*
        MIN HEAP IMPLEMENTATION

Definition:
A Min Heap is a Complete Binary Tree where:

parent <= children
So smallest element is always at root.


Array Representation

For index i:

left child  = 2*i + 1
right child = 2*i + 2
parent      = (i - 1) / 2


Example Heap

        2
      /   \
     5     7
    / \
   9   10

Stored as:

[2,5,7,9,10]


Why Use Heap?

Efficient priority operations:
• insert()
• getMin()
• extractMin()
• update key

Used in:

• Priority Queue
• Dijkstra
• Prim's MST
• Scheduling
• Top K problems

-----------------------------------------------------

Core Operations
1. insert(key)
Add at end,
bubble upward until heap valid.


2. getMin()
Return root = heap[0]


3. extractMin()
Remove root.
Replace with last element.
Then heapify downward.


4. changeKey(index,newVal)
If decreased:
bubble up

If increased:
heapify down


5. heapify(i)
Fix heap downward from index i.


Time Complexity
insert      = O(log n)
extractMin  = O(log n)
changeKey   = O(log n)
getMin      = O(1)
heapSize    = O(1)

Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    ArrayList<Integer> heap;

    // initialize heap
    public void initializeHeap() {
        heap = new ArrayList<>();
    }

    // insert new key
    public void insert(int key) {
        // add at end
        heap.add(key);
        int i = heap.size() - 1;

        // bubble up
        while(i > 0){
            int parent = (i - 1) / 2;
            if(heap.get(parent) <= heap.get(i)){
                break;
            }

            swap(i, parent);
            i = parent;
        }
    }

    // update value at index
    public void changeKey(int index, int newVal) {
        if(index < 0 || index >= heap.size()){
            return;
        }

        int oldVal = heap.get(index);
        heap.set(index, newVal);

        // decreased value -> move up
        if(newVal < oldVal){
            while(index > 0){
                int parent = (index - 1) / 2;
                if(heap.get(parent) <= heap.get(index)){
                    break;
                }

                swap(index, parent);
                index = parent;
            }
        }

        // increased value -> move down
        else{
            heapify(index);
        }
    }

    // remove minimum element
    public void extractMin() {
        if(heap.isEmpty()){
            return;
        }

        int last = heap.size() - 1;
        // move last to root
        swap(0, last);
        heap.remove(last);

        // fix heap
        if(!heap.isEmpty()){
            heapify(0);
        }
    }

    // check empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // return minimum
    public int getMin() {
        if(heap.isEmpty()){
            return -1;
        }

        return heap.get(0);
    }

    // current size
    public int heapSize() {
        return heap.size();
    }

    // push down from index i
    private void heapify(int i) {
        int n = heap.size();

        while(true){
            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if(left < n &&
               heap.get(left) < heap.get(smallest)){
                smallest = left;
            }

            if(right < n &&
               heap.get(right) < heap.get(smallest)){
                smallest = right;
            }

            if(smallest == i){
                break;
            }

            swap(i, smallest);
            i = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}