import java.util.*;
import java.util.LinkedList;

// Problem: Implement Queue using Deque

public class QueueUsingDeque {

    static class Queue {
        Deque<Integer> deque = new LinkedList<>(); // Deque used to store queue elements

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public void add(int data) {
            deque.addLast(data); // Add element at the end (rear of queue)
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove.");
                return -1;
            }
            return deque.removeFirst(); // Remove first element (front of queue)
        }

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

        queue.add(1);
        queue.add(2);
        queue.add(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

/*
Time Complexity:
- add() → O(1)
- remove() → O(1)
- front() → O(1)

Space Complexity:
O(n) — Deque storing n elements
*/
