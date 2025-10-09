import java.util.*;

// Problem: Implement Stack using ArrayList
/*
📌 Problem Statement:
We need to implement a Stack data structure using Java's ArrayList.
A stack follows the **LIFO (Last In, First Out)** principle:
   - The last element pushed is the first one to be popped.

👉 Operations to implement:
1. push(x): Insert element on top of stack
2. pop(): Remove and return top element
3. peek(): Return top element without removing
4. isEmpty(): Check if stack is empty

✅ We'll use ArrayList because it allows dynamic resizing and 
   provides O(1) access to the last element.
*/

public class StackUsingArrayList {

    // Inner static class representing Stack
    public static class Stack {
        // Using ArrayList to store stack elements
        static ArrayList<Integer> list = new ArrayList<>();

        // ✅ Check if stack is empty
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // ✅ Push operation – add element to top (end of list)
        public static void push(int data) {
            list.add(data);
        }

        // ✅ Pop operation – remove and return top element
        public static int pop() {
            if (isEmpty()) {              // Stack Underflow check
                System.out.println("Stack Underflow");
                return -1;
            }

            int top = list.get(list.size() - 1);  // get top element
            list.remove(list.size() - 1);         // remove top
            return top;
        }

        // ✅ Peek operation – return top element without removing
        public static int peek() {
            if (isEmpty()) {              // Empty stack check
                System.out.println("Stack is Empty");
                return -1;
            }

            return list.get(list.size() - 1);     // return top element
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        // 🔹 Push elements onto stack
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // 🔹 Pop and print all elements (LIFO order)
        while (!s.isEmpty()) {
            System.out.println(s.peek()); // show top element
            s.pop();                      // remove top element
        }
    }
}

/*
📌 Dry Run:
Push sequence: [1, 2, 3, 4, 5]
Stack (top → bottom): 5, 4, 3, 2, 1

Pop sequence:
→ Peek = 5 → Pop 5
→ Peek = 4 → Pop 4
→ Peek = 3 → Pop 3
→ Peek = 2 → Pop 2
→ Peek = 1 → Pop 1

Output:
5
4
3
2
1

---

📊 Time Complexity:
push()  → O(1)
pop()   → O(1)
peek()  → O(1)
isEmpty() → O(1)

📊 Space Complexity:
O(n) — for storing n elements in the ArrayList
*/
