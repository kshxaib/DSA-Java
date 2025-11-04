import java.util.*;
import java.util.LinkedList;

// Problem: Implement Stack using Two Queues (Push O(n), Pop & Peek O(1))

public class StackUsingTwoQueues {

    static class Stack {
        static Queue<Integer> queue1 = new LinkedList<>();
        static Queue<Integer> queue2 = new LinkedList<>();

        public static boolean isEmpty() {
            return queue1.isEmpty();
        }

        public static void push(int data) {
            // Step 1: Add new element to empty queue2
            queue2.add(data);

            // Step 2: Move all elements from queue1 → queue2
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }

            // Step 3: Swap the names of queue1 and queue2
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty, cannot pop.");
                return -1;
            }

            return queue1.remove(); // The front of queue1 is the stack top
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty, cannot peek.");
                return -1;
            }

            return queue1.peek(); // Front element represents the top of stack
        }
    }

    public static void main(String args[]) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.peek()); 

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

/*
📊 Time Complexity:
- push() → O(n) (because we move all elements during insertion)
- pop()  → O(1)
- peek() → O(1)

📊 Space Complexity:
O(n) — For two queues storing all elements.
*/
