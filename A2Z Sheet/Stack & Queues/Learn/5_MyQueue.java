import java.util.*;

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(x);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    
    public int pop() {
        if (stack1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; 
        }

        int topElement = stack1.pop(); 

        return topElement;
    }
    
    public int peek() {
        if (stack1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; 
        }

        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}