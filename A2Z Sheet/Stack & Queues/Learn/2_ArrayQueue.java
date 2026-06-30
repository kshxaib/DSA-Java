/*
        QUEUE IMPLEMENTATION USING ARRAY

Definition:
A Queue is a linear data structure that follows:

FIFO (First In First Out)


Example

Push: 1, 2, 3

Queue:
Front → 1 2 3 ← Rear

Pop → removes 1


Core Idea
We use:
• Array → to store elements
• front → points to first element
• rear → points to last element


Your Design

front = 0  
rear  = -1  


Operations
1. push(x)
2. pop()
3. peek()
4. isEmpty()


Push Operation
rear = (rear + 1) % size  
queue[rear] = x  


Pop Operation
value = queue[front]  
front++  


peek()
return queue[front]


isEmpty()
return front > rear

Time Complexity
push → O(1)  
pop → O(1)  
peek → O(1)  

Space Complexity: 
O(n)
*/

class ArrayQueue {
    int queue[];
    int front, rear, size;

    public ArrayQueue() {
        size = 10;
        queue = new int[size];
        front = 0;
        rear = 0;
    }

    public void push(int x) {
        // Queue is full.
        if ((rear + 1) % size == front) {
            throw new RuntimeException("Queue Overflow");
        }

        // Insert at rear.
        queue[rear] = x;

        // Move rear circularly.
        rear = (rear + 1) % size;
    }

    public int pop() {
        // Queue is empty.
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        // Remove front element.
        int value = queue[front];

        // Move front circularly.
        front = (front + 1) % size;

        return value;
    }

    public int peek() {
        // Queue is empty.
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        // Return front element.
        return queue[front];
    }

    public boolean isEmpty() {
        // Queue is empty when front == rear.
        return front == rear;
    }
}