class ArrayQueue {
    int queue[];
    int front, rear, size;

    public ArrayQueue() {
        size = 10;
        queue = new int[size];
        front = 0;
        rear = -1;
    }

    public void push(int x) {
       if(rear == size -1){
          throw new RuntimeException("Queue Overflow");
       }

        rear++;
        queue[rear] = x;
    }

    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow");
        }

        int value = queue[front];
        front++;
        return value;
    }

    public int peek() {
        if(isEmpty()){
            throw new RuntimeException("Queue Underflow");
        }

        int value = queue[front];
        return value;
    }

    public boolean isEmpty() {
        return front > rear;
    }
}
