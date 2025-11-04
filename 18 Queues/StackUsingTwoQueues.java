import java.util.*;
import java.util.LinkedList;

// Problem: Implement Stack using Two Queues

public class StackUsingTwoQueues {

    public static class Stack{
        static Queue<Integer> queue1 = new LinkedList<>();
        static Queue<Integer> queue2 = new LinkedList<>();

        public static boolean isEmpty(){
            return queue1.isEmpty() && queue2.isEmpty();
        }

        public static void push(int data){
            // Add to non-empty queue; if both empty, add to queue2 by default
            if(!queue1.isEmpty()){
                queue1.add(data);
            } else {
                queue2.add(data);
            }
        }

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

        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}

/*
📊 Time Complexity:
- push() → O(1)
- pop()  → O(n) (transfer elements)
- peek() → O(n) (transfer elements)

📊 Space Complexity:
O(n) — For two queues storing n elements
*/
