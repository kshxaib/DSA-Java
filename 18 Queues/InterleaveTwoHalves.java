// Problem: Interleave the Two Halves of a Queue

import java.util.*;
import java.util.LinkedList;

public class InterleaveTwoHalves {

    public static void InterleaveTH(Queue<Integer> queue) {
        Queue<Integer> forFirstHalf = new LinkedList<>(); // Temporary queue for the first half
        int sizeHalf = queue.size() / 2;                  // Size of each half

        // Step 1: Move first half elements into the temporary queue
        for (int i = 0; i < sizeHalf; i++) {
            int front = queue.remove();   // Remove element from main queue
            forFirstHalf.add(front);      // Add it to first half queue
        }

        // Step 2: Interleave elements from both halves
        while (!forFirstHalf.isEmpty()) {
            queue.add(forFirstHalf.remove()); // Add element from first half
            int front = queue.remove();       // Remove next element from second half
            queue.add(front);                 // Add it back to maintain alternating pattern
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        InterleaveTH(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

/*
Dry Run:
Initial queue: [1,2,3,4,5,6,7,8,9,10]
Step 1: Move first half to temp queue → forFirstHalf = [1,2,3,4,5], queue = [6,7,8,9,10]

Step 2: Interleave:
- Add 1, then 6 → queue = [7,8,9,10,1,6]
- Add 2, then 7 → queue = [8,9,10,1,6,2,7]
- Add 3, then 8 → queue = [9,10,1,6,2,7,3,8]
- Add 4, then 9 → queue = [10,1,6,2,7,3,8,4,9]
- Add 5, then 10 → queue = [1,6,2,7,3,8,4,9,5,10]

Final Output:
1
6
2
7
3
8
4
9
5
10

Time Complexity: O(n)
- Each element is added and removed at most once.

Space Complexity: O(n/2)
- Temporary queue stores half of the elements.
*/
