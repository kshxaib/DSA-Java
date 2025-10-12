// ✅ Problem: Implement Queue using Array
/*
📌 Problem Statement:
Implement a **Queue** data structure using an array in Java.  
A Queue follows the **FIFO (First In, First Out)** principle —  
the element inserted first is removed first.

You need to perform the following operations:
1. **add()**  → Enqueue (insert) an element at the rear.
2. **remove()** → Dequeue (remove) an element from the front.
3. **peek()**  → Get the front element without removing it.

👉 Concept:
- Queue maintains two ends: **Front** and **Rear**.
- Elements are added from the **rear** and removed from the **front**.
- When the queue becomes full, no more insertions are allowed.
- When the queue becomes empty, no deletions are possible.

⚠️ This is a **Linear Queue** implementation.
After several removals, empty spaces at the front are not reused.
A **Circular Queue** is a more efficient alternative.
*/

public class CircularQueueUsingArray {

    // Inner static class for Queue implementation
    static class Queue {
        static int arr[];   // Array to store queue elements
        static int size;    // Maximum size of the queue
        static int rear;    // Index of the last inserted element
        static int front;

        // 🔹 Constructor to initialize the queue
        Queue(int n) {
            arr = new int[n];
            this.size = n;
            this.rear = -1; // Initially empty
            this.front = -1;
        }

        // 🔹 Check if the queue is empty
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear + 1) % size == front;
        }

        // 🔹 Add (enqueue) element at the rear of the queue
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full."); // Overflow condition
                return;
            }

            if(front == -1){
                front = front +1;
            }

            rear = (rear +1) % size;
            arr[rear] = data;
        }

        // 🔹 Remove (dequeue) element from the front of the queue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove."); // Underflow condition
                return -1;
            }

            int frontValue = arr[front];
             
            // last 
            if(rear == front){
                rear = -1;
                front = -1;
            } else {
                front = (front +1) % size; // Front element to return
            }
            return frontValue;
        }

        // 🔹 Peek operation — returns front element without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }

            return arr[front]; // Front element always at index 0
        }
    }

    // 🔹 Main method — testing the Queue implementation
    public static void main(String args[]) {
        Queue queue = new Queue(5); // Create a queue of size 5

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
    }
}

/*
📌 Dry Run:
Queue size = 5

Operations:
add(1) → [1]
add(2) → [1, 2]
add(3) → [1, 2, 3]
add(4) → [1, 2, 3, 4]
add(5) → [1, 2, 3, 4, 5]

Now remove:
→ peek() = 1 → remove() → [2, 3, 4, 5]
→ peek() = 2 → remove() → [3, 4, 5]
→ peek() = 3 → remove() → [4, 5]
→ peek() = 4 → remove() → [5]
→ peek() = 5 → remove() → []

✅ Output:
1
2
3
4
5

---

📊 Time Complexity:
- add()   → O(1)
- remove() → O(n)  (because of element shifting)
- peek()   → O(1)

📊 Space Complexity:
O(n) — for the array.

✅ Concept Used:
Linear Queue using Array (FIFO principle)
*/
