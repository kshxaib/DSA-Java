// Problem: Implement Queue using Two Stacks
/*
This program implements a Queue using two stacks in Java.
A Queue follows the FIFO (First In, First Out) principle:
- The first element added is the first one to be removed.

Operations supported:
1. add()    → Enqueue an element at the rear.
2. remove() → Dequeue an element from the front.
3. peek()   → Retrieve the front element without removing it.

Concept:
- Use two stacks (stack1 and stack2) to simulate a queue.
- To maintain FIFO order:
  1. Transfer all elements from stack1 to stack2.
  2. Push the new element into stack1.
  3. Transfer elements back from stack2 to stack1.
- stack1 always keeps the queue elements in correct order.
*/

import java.util.*;

public class QueueUsingTwoStacks {

    // Inner class for queue implementation
    static class Queue {
        static Stack<Integer> stack1 = new Stack<>();  // Main stack holding queue
        static Stack<Integer> stack2 = new Stack<>();  // Temporary stack for reversing order

        // Check if queue is empty
        public static boolean isEmpty() {
            return stack1.isEmpty();
        }

        // Enqueue operation
        public static void add(int data) {
            if (isEmpty()) {
                stack1.push(data);
                return;
            }

            // Step 1: Move all elements from stack1 to stack2
            while (!isEmpty()) {
                int top = stack1.pop();
                stack2.push(top);
            }

            // Step 2: Push new element into stack1
            stack1.push(data);

            // Step 3: Move back all elements from stack2 to stack1
            while (!stack2.isEmpty()) {
                int top = stack2.pop();
                stack1.push(top);
            }
        }

        // Dequeue operation
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove.");
                return -1;
            }
            return stack1.pop();  // Front element is always at top of stack1
        }

        // Peek operation
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }
            return stack1.peek();
        }
    }

    // Main method to test queue operations
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

Step 1: add(1) → stack1: [1]
Step 2: add(2) → move 1 to stack2, push 2 to stack1, move 1 back → stack1: [2,1]
Step 3: add(3) → move 2,1 to stack2, push 3 to stack1, move 1,2 back → stack1: [3,2,1]

Remove operations:
remove() → 1
remove() → 2
remove() → 3

Output:
1
2
3

Time Complexity:
- add()    → O(n) due to moving elements between stacks
- remove() → O(1)
- peek()   → O(1)

Space Complexity: O(n) — two stacks used
Concept Used: Stack to simulate Queue (FIFO)
*/
