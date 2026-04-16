/*
        MIN STACK (STACK WITH GET MIN IN O(1))

Definition:
Design a stack that supports:

• push(x)
• pop()
• top()
• getMin()

All operations must run in O(1) time.


Example

push(5)
push(3)
push(7)

Stack:    [5, 3, 7]
MinStack: [5, 3]

getMin() → 3


Core Idea

Use TWO STACKS:
1. stack → stores all elements
2. minStack → stores minimum elements


Why This Works
minStack always keeps track of
the current minimum at each stage.


Time Complexity
push → O(1)  
pop → O(1)  
top → O(1)  
getMin → O(1)  

Space Complexity: O(n)
*/

class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(minStack.peek().equals(stack.peek())){
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return minStack.peek();
    }
}