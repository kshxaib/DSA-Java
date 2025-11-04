import java.util.*;
import java.util.LinkedList;

// Problem: Implement Stack using Deque

public class StackUsingDeque {

    static class Stack {
        Deque<Integer> deque = new LinkedList<>(); // Deque used to store stack elements

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public void push(int data) {
            deque.addLast(data); // Add element at the end (top of stack)
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty, cannot remove.");
                return -1;
            }
            return deque.removeLast(); // Remove last element (top of stack)
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty, cannot peek.");
                return -1;
            }
            return deque.getLast(); // Return last element (top of stack)
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

/*
Time Complexity:
- push() → O(1)
- pop() → O(1)
- peek() → O(1)

Space Complexity:
O(n) — Deque storing n elements
*/
