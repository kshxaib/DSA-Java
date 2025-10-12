// Problem: Reverse a Queue using Stack
/*
This program reverses the elements of a given queue using a stack.

Concept:
- A Queue follows FIFO (First In, First Out)
- A Stack follows LIFO (Last In, First Out)
By transferring elements from queue → stack → queue, 
we effectively reverse the order of elements.

Steps:
1. Remove all elements from the queue and push them onto a stack.
   - This reverses the order because stack stores them in LIFO manner.
2. Pop all elements from the stack and add them back into the queue.
   - This results in a reversed queue.
*/

import java.util.*;
import java.util.LinkedList;

public class QueueReversal {

    // Function to reverse a queue
    public static void QueueReverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();  // Temporary stack for reversal

        // Step 1: Move all elements from queue to stack
        while (!queue.isEmpty()) {
            int front = queue.remove(); // Remove from front of queue
            stack.push(front);          // Push onto stack
        }

        // Step 2: Move all elements back from stack to queue
        while (!stack.isEmpty()) {
            int top = stack.pop();  // Pop from stack (LIFO)
            queue.add(top);         // Add back to queue (FIFO)
        }
    }

    // Main method to test queue reversal
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Reverse the queue
        QueueReverse(queue);

        // Display reversed queue
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

/*
Dry Run:
Initial Queue: [1, 2, 3, 4, 5]

Step 1: Move all to stack
Stack: [5, 4, 3, 2, 1]
Queue: []

Step 2: Move all back to queue
Queue: [5, 4, 3, 2, 1]
Stack: []

Final Output:
5
4
3
2
1

Time Complexity: O(n)
- Each element is enqueued, dequeued, pushed, and popped once.

Space Complexity: O(n)
- Stack stores all elements temporarily.

Concept Used:
- Stack reversal principle to reverse a queue.
*/  
