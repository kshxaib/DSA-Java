import java.util.*;

public class StackUsingArrayList {
    public static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int pop() {
            if (isEmpty()) {              
                System.out.println("Stack Underflow");
                return -1;
            }

            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);         
            return top;
        }

        public static int peek() {
            if (isEmpty()) {              
                System.out.println("Stack is Empty");
                return -1;
            }

            return list.get(list.size() - 1);   
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        while (!s.isEmpty()) {
            System.out.println(s.peek()); 
            s.pop();                      
        }
    }
}
