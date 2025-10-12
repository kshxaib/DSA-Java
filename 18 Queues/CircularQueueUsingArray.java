// ✅ Problem: Implement Circular Queue using Array
/*
📌 Problem Statement:
Implement a **Circular Queue** data structure using an array in Java.  
A Circular Queue overcomes the limitation of the Linear Queue where  
empty spaces at the front cannot be reused after dequeuing.

You need to perform the following operations:
1. **add()**   → Enqueue (insert) an element at the rear.
2. **remove()** → Dequeue (remove) an element from the front.
3. **peek()**   → Get the front element without removing it.

👉 Concept:
- Queue follows the **FIFO (First In, First Out)** principle.
- In a **Circular Queue**, the last position connects back to the first position.
- This allows efficient space utilization — all slots can be reused.
- Use **modulo (%)** to wrap indices when they reach the end of the array.

🔹 Key Formulas:
- Queue is **Full** when → `(rear + 1) % size == front`
- Queue is **Empty** when → `rear == -1 && front == -1`
*/

public class CircularQueueUsingArray {

    // Inner static class for queue implementation
    static class Queue {
        static int arr[];   // Array to store queue elements
        static int size;    // Maximum size of queue
        static int rear;    // Index of last inserted element
        static int front;   // Index of first element

        // 🔹 Constructor to initialize the queue
        Queue(int n) {
            arr = new int[n];
            this.size = n;
            this.rear = -1;  // Initially empty
            this.front = -1; // Initially empty
        }

        // 🔹 Check if queue is empty
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // 🔹 Check if queue is full
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // 🔹 Add (enqueue) element at the rear of the queue
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full."); // Overflow condition
                return;
            }

            // First element insertion
            if (front == -1) {
                front = 0;
            }

            // Move rear circularly
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // 🔹 Remove (dequeue) element from the front of the queue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove."); // Underflow condition
                return -1;
            }

            int frontValue = arr[front]; // Element to remove

            // If only one element is left
            if (rear == front) {
                rear = -1;
                front = -1;
            } else {
                // Move front circularly
                front = (front + 1) % size;
            }

            return frontValue;
        }

        // 🔹 Peek operation — returns front element without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }

            return arr[front]; // Return current front element
        }
    }

    // 🔹 Main method — testing Circular Queue
    public static void main(String args[]) {
        Queue queue = new Queue(5); // Create a circular queue of size 5

        // Enqueue elements
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Display and remove elements in FIFO order
        while (!queue.isEmpty()) {
            System.out.println(queue.peek()); // Show front element
            queue.remove();                   // Remove front element
        }

        // Reuse queue to demonstrate circular behavior
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
📌 Dry Run:

Queue size = 5

Initial state → front = -1, rear = -1

add(1) → front = 0, rear = 0 → [1]
add(2) → rear = 1 → [1, 2]
add(3) → rear = 2 → [1, 2, 3]
add(4) → rear = 3 → [1, 2, 3, 4]
add(5) → rear = 4 → [1, 2, 3, 4, 5]

Now remove:
→ peek() = 1 → remove() → front moves → [2, 3, 4, 5]
→ peek() = 2 → remove()
→ ...
→ queue becomes empty

Then reuse:
add(10), add(20), add(30)
(rear wraps around circularly using modulo)

✅ Output:
1
2
3
4
5
After reusing queue:
10
20
30

---

📊 Time Complexity:
- add()   → O(1)
- remove() → O(1)
- peek()   → O(1)

📊 Space Complexity:
O(n) — for the array.

✅ Concept Used:
Circular Queue using Array + Modulo Arithmetic
*/
