// Problem: Implement Queue using Array
public class QueueUsingArray {

    // Inner static class for Queue implementation
    static class Queue {
        static int arr[];   // Array to store queue elements
        static int size;    // Maximum size of the queue
        static int rear;    // Index of the last inserted element

        // Constructor to initialize the queue
        Queue(int n) {
            arr = new int[n];
            this.size = n;
            this.rear = -1; // Initially empty
        }

        // Check if the queue is empty
        public static boolean isEmpty() {
            return rear == -1;
        }

        // Add (enqueue) element at the rear of the queue
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full."); 
                return;
            }

            rear = rear + 1;     // Move rear forward
            arr[rear] = data;    // Insert data
        }

        // Remove (dequeue) element from the front of the queue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove."); 
                return -1;
            }

            int front = arr[0]; // Front element to return

            // Shift all remaining elements one position left
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }

            rear = rear - 1; // Reduce rear after removal
            return front;
        }

        // Peek operation — returns front element without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }

            return arr[0]; // Front element always at index 0
        }
    }

    public static void main(String args[]) {
        Queue queue = new Queue(5); 

        // Enqueue elements
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek()); 
            queue.remove();                  
        }
    }
}

/*
📊 Time Complexity:
- add()   → O(1)
- remove() → O(n)  (because of element shifting)
- peek()   → O(1)

📊 Space Complexity:
O(n) — for the array.
*/
