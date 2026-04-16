/*
        MIN STACK (STACK WITH GET MIN IN O(1))

Definition:
Design a stack that supports:

• push(x)
• pop()
• top()
• getMin()

All operations must run in O(1) time.

-----------------------------------------------------

Example

push(5)
push(3)
push(7)

Stack:    [5, 3, 7]
MinStack: [5, 3]

getMin() → 3

-----------------------------------------------------

Core Idea

Use TWO STACKS:

1. stack → stores all elements
2. minStack → stores minimum elements

-----------------------------------------------------

Why This Works

minStack always keeps track of
the current minimum at each stage.

-----------------------------------------------------

Step-by-Step Approach

Push Operation

• Push value into main stack
• If:
    - minStack empty OR
    - val <= current min

→ push into minStack

-----------------------------------------------------

Pop Operation

• If top of stack == top of minStack
→ pop from minStack also

• Pop from main stack

-----------------------------------------------------

Top Operation

Return top of stack (without removing)

-----------------------------------------------------

getMin Operation

Return top of minStack

-----------------------------------------------------

Visualization

push(5)
stack = [5]
min   = [5]

push(3)
stack = [5,3]
min   = [5,3]

push(7)
stack = [5,3,7]
min   = [5,3]

-----------------------------------------------------

Dry Run

pop()

stack top = 7  
min top = 3 → no match  

→ only pop stack

-----------------------------------------------------

IMPORTANT BUG IN YOUR CODE 🚨

public int top() {
    return stack.pop(); ❌
}

-----------------------------------------------------

Problem:

top() should NOT remove element

But you are popping it → WRONG

-----------------------------------------------------

Correct:

return stack.peek();

-----------------------------------------------------

Time Complexity

push → O(1)  
pop → O(1)  
top → O(1)  
getMin → O(1)  

-----------------------------------------------------

Space Complexity

O(n)

-----------------------------------------------------

Key Interview Points

• Use auxiliary stack
• Maintain minimum efficiently
• Handle duplicates using <=
• Synchronize both stacks

-----------------------------------------------------

Common Mistakes

• Using pop instead of peek (YOU DID THIS ❌)
• Not handling duplicates properly
• Not syncing minStack with stack

-----------------------------------------------------

Corrected Code

-----------------------------------------------------
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