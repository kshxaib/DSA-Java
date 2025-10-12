import java.util.*;
import java.util.LinkedList;

// Problem: Implement Stack using Two Queues
/*
📌 Problem Statement:
Implement a stack using **two queues**.  
The stack must follow **LIFO (Last In First Out)** principle, while using only queue operations.

Operations to implement:
1. **push(x)** → Insert element x into the stack.
2. **pop()** → Remove the top element from the stack.
3. **peek()** → Return the top element without removing it.
4. **isEmpty()** → Check if the stack is empty.

 Concept:
- Maintain two queues: `queue1` and `queue2`.
- **Push operation:** Add element to the non-empty queue.
- **Pop operation:** Transfer elements from the non-empty queue to the empty queue **except the last element**, which is the top of the stack.
- **Peek operation:** Similar to pop, but after retrieving the last element, put it back into the other queue.
*/

public class StackUsingTwoQueues {

    // Inner class representing the Stack
    public static class Stack{
        static Queue<Integer> queue1 = new LinkedList<>();
        static Queue<Integer> queue2 = new LinkedList<>();

        // 🔹 Check if stack is empty
        public static boolean isEmpty(){
            return queue1.isEmpty() && queue2.isEmpty();
        }

        // 🔹 Push element into stack
        public static void push(int data){
            // Add to non-empty queue; if both empty, add to queue2 by default
            if(!queue1.isEmpty()){
                queue1.add(data);
            } else {
                queue2.add(data);
            }
        }

        // 🔹 Pop element from stack
        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty, cannot remove.");
                return -1;
            }

            int top = -1;

            // Transfer elements from non-empty queue to empty queue, leaving last element
            if(!queue1.isEmpty()){
                while(!queue1.isEmpty()){
                    top = queue1.remove();
                    if(queue1.isEmpty()){
                        break; // Last element found, this is top
                    }
                    queue2.add(top);
                }
            } else {
                while(!queue2.isEmpty()){
                    top = queue2.remove();
                    if(queue2.isEmpty()){
                        break; // Last element found
                    }
                    queue1.add(top);
                }
            }

            return top; // Return top element
        }

        // 🔹 Peek top element of stack without removing
        public static int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty, cannot remove.");
                return -1;
            }

            int top = -1;

            if(!queue1.isEmpty()){
                while(!queue1.isEmpty()){
                    top = queue1.remove();
                    queue2.add(top); // Put back all elements into the other queue
                }
            } else {
                while(!queue2.isEmpty()){
                    top = queue2.remove();
                    queue1.add(top); // Restore all elements
                }
            }

            return top; // Top element of stack
        }
    }

    public static void main(String args[]){
        Stack stack = new Stack();

        // Push elements into stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop and display all elements (LIFO order)
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}

/*
📌 Dry Run:

Push sequence: 1, 2, 3

Step 1: push 1 → queue2 = [1]
Step 2: push 2 → queue2 = [1, 2]
Step 3: push 3 → queue2 = [1, 2, 3]

Pop sequence:
- Transfer all but last from queue2 to queue1 → last element 3 is popped
- Next pop: transfer 1 → 2 from queue1 to queue2 → last element 2 popped
- Next pop: transfer 1 from queue2 to queue1 → last element 1 popped

Output:
3
2
1

---

📊 Time Complexity:
- push() → O(1)
- pop()  → O(n) (transfer elements)
- peek() → O(n) (transfer elements)

📊 Space Complexity:
O(n) — For two queues storing n elements

✅ Concept Used:
Simulating Stack (LIFO) using two Queues (FIFO)
*/
