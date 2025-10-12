import java.util.*;
import java.util.LinkedList;

public class StackUsingDeque {
    static class Stack{
        Deque<Integer> deque = new LinkedList<>();

        public boolean isEmpty(){
            return deque.isEmpty();
        }

        public void push(int data){
            deque.addLast(data);
        }

        public int pop(){
            return deque.removeLast();
        }

        public int peek(){
            return deque.getLast();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }   
    }
}
