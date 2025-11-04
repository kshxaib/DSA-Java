// Problem: Implement Queue using Two Stacks

import java.util.*;

public class QueueUsingTwoStacks {

    static class Queue {
        static Stack<Integer> stack1 = new Stack<>();  // Main stack holding queue
        static Stack<Integer> stack2 = new Stack<>();  // Temporary stack for reversing order

        public static boolean isEmpty() {
            return stack1.isEmpty();
        }

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

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove.");
                return -1;
            }
            return stack1.pop();  
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }
            return stack1.peek();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

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
Time Complexity:
- add()    → O(n) due to moving elements between stacks
- remove() → O(1)
- peek()   → O(1)

Space Complexity: O(n) — two stacks used
*/
