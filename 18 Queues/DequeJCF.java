// Problem: Demonstrate Deque (Double-Ended Queue) using Java Collection Framework
/*
This program shows how to use a **Deque** (Double-Ended Queue) in Java 
using the `LinkedList` class.

Concept:
- A **Deque** allows insertion and deletion from both ends.
- It can be used as both:
  1. **Queue (FIFO)** — using addLast() and removeFirst()
  2. **Stack (LIFO)** — using addFirst() and removeFirst()

Key Methods:
- addFirst(E e): Inserts element at the front.
- addLast(E e): Inserts element at the rear.
- removeFirst(): Removes element from the front.
- removeLast(): Removes element from the rear.
- getFirst(): Retrieves, but does not remove, the first element.
- getLast(): Retrieves, but does not remove, the last element.
*/

import java.util.*;
import java.util.LinkedList;

public class DequeJCF {
    public static void main(String[] args) {
        // Create a Deque using LinkedList
        Deque<Integer> deque = new LinkedList<>();

        // Add elements at the front
        deque.addFirst(1); // deque → [1]
        deque.addFirst(2); // deque → [2, 1]

        // Remove element from the front
        deque.removeFirst(); // deque → [1]

        // Print remaining elements in deque
        System.out.println(deque); // Output: [1]
    }
}

/*
Dry Run:
Initial: []
addFirst(1) → [1]
addFirst(2) → [2, 1]
removeFirst() → [1]

Output:
[1]

Time Complexity:
- addFirst(), addLast(), removeFirst(), removeLast() → O(1)

Space Complexity:
- O(n) for storing elements in the deque.

Concept Used:
- Deque (Double-Ended Queue) using Java’s LinkedList class.
*/
