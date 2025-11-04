// Problem: Implement Queue using Linked List

public class QueueUsingLL {

    public static class Node {
        int data;   
        Node next; 

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue {
        static Node head = null;  // Front of the queue
        static Node tail = null;  // Rear of the queue

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }

            // Otherwise, attach new node at the end and update tail
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove.");
                return -1;
            }

            int front = head.data;  // Store front value to return

            // If only one element exists, reset head and tail
            if (tail == head) {
                tail = null;
                head = null;
            } else {
                head = head.next;
            }

            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

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
Time Complexity:
add()   → O(1)
remove() → O(1)
peek()   → O(1)

Space Complexity: O(n)
*/  
