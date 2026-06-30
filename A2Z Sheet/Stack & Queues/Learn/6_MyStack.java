import java.util.*;

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        int s = q.size();

        // Insert new element.
        q.add(x);

        // Move old elements behind the new element.
        for (int i = 0; i < s; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        // Remove and return top element.
        int n = q.peek();
        q.poll();
        return n;
    }

    public int top() {
        // Return top element.
        return q.peek();
    }

    public boolean empty() {
        // Stack is empty when queue is empty.
        return q.isEmpty();
    }
}