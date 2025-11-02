import java.util.*;

public class ReverseStack {

    public static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }

    public static void pushAtBottom(Stack<Integer> stack, int data) {
        // ✅ Base case: If stack is empty, push data
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        // Step 1: Pop top element
        int top = stack.pop();

        // Step 2: Recursively insert at bottom
        pushAtBottom(stack, data);

        // Step 3: Push popped element back
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack) {
        // ✅ Base case: If stack is empty, stop recursion
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop top element
        int top = stack.pop();

        // Step 2: Reverse remaining stack
        reverseStack(stack);

        // Step 3: Insert popped element at bottom
        pushAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverseStack(stack);

        printStack(stack);
    }
}
