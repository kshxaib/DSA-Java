// Problem: Implement Circular Queue using Array

public class CircularQueueUsingArray {

    static class Queue {
        static int arr[];   // Array to store queue elements
        static int size;    // Maximum size of queue
        static int rear;    // Index of last inserted element
        static int front;   // Index of first element

        Queue(int n) {
            arr = new int[n];
            this.size = n;
            this.rear = -1;  
            this.front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full.");
                return;
            }

            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove."); 
                return -1;
            }

            int frontValue = arr[front]; 

            if (rear == front) {
                rear = -1;
                front = -1;
            } else {
                front = (front + 1) % size;
            }

            return frontValue;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }

            return arr[front]; 
        }
    }

    public static void main(String args[]) {
        Queue queue = new Queue(5); 

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek()); 
            queue.remove();                   
        }

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("After reusing queue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}

/*
📊 Time Complexity:
- add()   → O(1)
- remove() → O(1)
- peek()   → O(1)

📊 Space Complexity:
O(n) — for the array.
*/
