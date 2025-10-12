// Problem: Implement Queue using Java Collection Framework (JCF)
/*
This program demonstrates the use of Java's built-in Queue interface 
with LinkedList implementation.

A Queue follows the FIFO (First In, First Out) principle:
- Elements added first are removed first.

Operations used:
1. add()    → Enqueue (insert) an element at the rear of the queue.
2. remove() → Dequeue (remove) an element from the front of the queue.
3. peek()   → Retrieve the front element without removing it.

Concept:
- Java provides a Queue interface.
- LinkedList implements the Queue interface.
- This allows easy and efficient queue operations without manually managing nodes.
*/

import java.util.*;
import java.util.LinkedList;

public class QueueJCF {
    public static void main(String[] args) {
        // Queue declaration using LinkedList
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Display elements while removing them (FIFO order)
        while (!queue.isEmpty()) {
            System.out.println(queue.peek()); // Show front element
            queue.remove();                   // Remove front element
        }
    }    
}

/*
Dry Run:
Queue: []

add(1) → [1]
add(2) → [1, 2]
add(3) → [1, 2, 3]
add(4) → [1, 2, 3, 4]
add(5) → [1, 2, 3, 4, 5]

peek() → 1 → remove() → [2, 3, 4, 5]
peek() → 2 → remove() → [3, 4, 5]
peek() → 3 → remove() → [4, 5]
peek() → 4 → remove() → [5]
peek() → 5 → remove() → []

Output:
1
2
3
4
5

Time Complexity:
add()    → O(1)
remove() → O(1)
peek()   → O(1)

Space Complexity: O(n)

Concept Used:
Java Queue interface + LinkedList implementation (FIFO principle)
*/
