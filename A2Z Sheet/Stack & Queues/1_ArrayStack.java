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
        if(top == size -1){
            throw new RuntimeException("Stack Overflow");
        }

        top++;
        stack[top] = x;
    }

    public int pop() {
        if(top == -1){
            throw new RuntimeException("Stack Underflow");
        }

        int value = stack[top];
        top--;
        return value;
    }

    public int top() {
        if(top == -1){
            throw new RuntimeException("Stack Underflow");
        }

        int value = stack[top];
        return value;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
