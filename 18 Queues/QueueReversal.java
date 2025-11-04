// Problem: Reverse a Queue using Stack

import java.util.*;
import java.util.LinkedList;

public class QueueReversal {

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

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        QueueReverse(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

/*
Time Complexity: O(n)
- Each element is enqueued, dequeued, pushed, and popped once.

Space Complexity: O(n)
- Stack stores all elements temporarily.
*/  
