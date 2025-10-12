import java.util.*;
import java.util.LinkedList;

// Problem: Implement Stack using Deque
/*
Problem Statement:
Implement a stack using a Deque (Double Ended Queue) in Java.  
The stack should follow the LIFO (Last In First Out) principle.

Operations to implement:
1. push(x) → Insert element x into the stack.
2. pop() → Remove the top element from the stack.
3. peek() → Return the top element without removing it.
4. isEmpty() → Check if the stack is empty.

Concept:
- A Deque allows insertion and deletion from both ends.
- To simulate a stack:
  - Use addLast() to push an element onto the stack.
  - Use removeLast() to pop the top element.
  - Use getLast() to peek the top element.
*/

public class StackUsingDeque {

    // Inner class representing the stack
    static class Stack {
        Deque<Integer> deque = new LinkedList<>(); // Deque used to store stack elements

        // Check if stack is empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }

        // Push element into stack
        public void push(int data) {
            deque.addLast(data); // Add element at the end (top of stack)
        }

        // Pop element from stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty, cannot remove.");
                return -1;
            }
            return deque.removeLast(); // Remove last element (top of stack)
        }

        // Peek top element without removing
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

        // Push elements into stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop and display all elements in LIFO order
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

/*
Dry Run:

Push sequence: 1, 2, 3

Step 1: push 1 → deque = [1]
Step 2: push 2 → deque = [1, 2]
Step 3: push 3 → deque = [1, 2, 3]

Pop sequence:
pop() → 3
pop() → 2
pop() → 1

Output:
3
2
1

Time Complexity:
- push() → O(1)
- pop() → O(1)
- peek() → O(1)

Space Complexity:
O(n) — Deque storing n elements

Concept Used:
Simulating Stack (LIFO) using Deque (double-ended queue)
*/
