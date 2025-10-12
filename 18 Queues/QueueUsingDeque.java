import java.util.*;
import java.util.LinkedList;

// Problem: Implement Queue using Deque
/*
Problem Statement:
Implement a queue using a Deque (Double Ended Queue) in Java.  
The queue should follow the FIFO (First In First Out) principle.

Operations to implement:
1. add(x) → Insert element x at the rear of the queue.
2. remove() → Remove the front element from the queue.
3. front() → Return the front element without removing it.
4. isEmpty() → Check if the queue is empty.

Concept:
- A Deque allows insertion and deletion from both ends.
- To simulate a queue:
  - Use addLast() to enqueue elements at the rear.
  - Use removeFirst() to dequeue elements from the front.
  - Use getFirst() to peek at the front element.
*/

public class QueueUsingDeque {

    // Inner class representing the queue
    static class Queue {
        Deque<Integer> deque = new LinkedList<>(); // Deque used to store queue elements

        // Check if queue is empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }

        // Add element to the rear of the queue
        public void add(int data) {
            deque.addLast(data); // Add element at the end (rear of queue)
        }

        // Remove element from the front of the queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove.");
                return -1;
            }
            return deque.removeFirst(); // Remove first element (front of queue)
        }

        // Peek at the front element without removing
        public int front() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }
            return deque.getFirst(); // Return first element (front of queue)
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue elements
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // Dequeue and display elements in FIFO order
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

/*
Dry Run:

Add sequence: 1, 2, 3

Step 1: add(1) → deque = [1]
Step 2: add(2) → deque = [1, 2]
Step 3: add(3) → deque = [1, 2, 3]

Remove sequence:
remove() → 1
remove() → 2
remove() → 3

Output:
1
2
3

Time Complexity:
- add() → O(1)
- remove() → O(1)
- front() → O(1)

Space Complexity:
O(n) — Deque storing n elements

Concept Used:
Simulating Queue (FIFO) using Deque (double-ended queue)
*/
