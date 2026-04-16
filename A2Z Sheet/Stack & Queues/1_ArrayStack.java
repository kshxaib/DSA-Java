/*
        STACK IMPLEMENTATION USING ARRAY

Definition:
A Stack is a linear data structure that follows:

LIFO (Last In First Out)


Example

Push: 1, 2, 3

Stack:
Top → 3
       2
       1

Pop → removes 3


Core Idea

We use:
• Array → to store elements
• top pointer → to track last inserted element


Structure
stack[] → stores elements  
top → index of last element  

Initially:
top = -1 (empty stack)


Operations

1. push(x)
2. pop()
3. top() / peek()
4. isEmpty()


Push Operation
Step:
• Check overflow
• Increment top
• Insert element


Pop Operation
Step:
• Check underflow
• Get top element
• Decrement top


Top / Peek Operation
Step:
• Return top element without removing


isEmpty
Check:
top == -1


Time Complexity
push → O(1)  
pop → O(1)  
top → O(1)  
isEmpty → O(1)  

Space Complexity: O(n)
*/

class ArrayStack {
    int stack[];
    int top;
    int size;

    public ArrayStack() {
        size = 10;
        stack = new int[size];
        top = -1;
    }

    public void push(int x) {
        if(top == size - 1){
            throw new RuntimeException("Stack Overflow");
        }

        stack[++top] = x;
    }

    public int pop() {
        if(top == -1){
            throw new RuntimeException("Stack Underflow");
        }

        return stack[top--];
    }

    public int peek() {
        if(top == -1){
            throw new RuntimeException("Stack Underflow");
        }

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}