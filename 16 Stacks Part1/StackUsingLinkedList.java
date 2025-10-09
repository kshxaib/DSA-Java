// Problem: Implement Stack using Linked List
/*
📌 Problem Statement:
We need to implement a Stack data structure using a **Linked List**.
Stack follows the **LIFO (Last In, First Out)** principle:
   - The last element pushed is the first one to be popped.

👉 Operations to implement:
1. push(x): Insert element at the top
2. pop(): Remove and return the top element
3. peek(): Return top element without removing
4. isEmpty(): Check if stack is empty

✅ We'll use a singly linked list where the **head** node represents 
   the **top** of the stack.
*/

public class StackUsingLinkedList {

    // 🔹 Node class represents a single element in the linked list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 🔹 Stack class implementing stack operations using linked list
    static class Stack {
        static Node head = null; // top of stack

        // ✅ Check if stack is empty
        public static boolean isEmpty() {
            return head == null;
        }

        // ✅ Push operation — insert element at top (head)
        public static void push(int data) {
            Node newNode = new Node(data); // create new node
            if (isEmpty()) {               // if stack is empty
                head = newNode;
                return;
            }

            newNode.next = head;           // link new node to old top
            head = newNode;                // make new node the top
        }

        // ✅ Pop operation — remove and return top element
        public static int pop() {
            if (isEmpty()) {               // underflow check
                System.out.println("Stack Underflow");
                return -1;
            }

            int top = head.data;           // get top data
            head = head.next;              // move head down
            return top;                    // return popped value
        }

        // ✅ Peek operation — return top element without removing
        public static int peek() {
            if (isEmpty()) {               // empty stack check
                System.out.println("Stack is Empty");
                return -1;
            }

            return head.data;              // return top element
        }
    }

    // 🔹 Main function to test stack operations
    public static void main(String[] args) {
        Stack s = new Stack();

        // Push elements
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // Pop and print all elements (LIFO order)
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}

/*
📌 Dry Run:
Push sequence: 1 → 2 → 3 → 4 → 5
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
O(n) → for n nodes in the linked list

✅ Advantage:
- No fixed size (dynamic memory allocation)
- No overflow unless memory is full
*/
