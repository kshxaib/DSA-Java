import java.util.*;

public class QueueUsingTwoStacks {
    static class Queue{
        static Stack<Integer> stack1 = new Stack<>();
        static Stack<Integer> stack2 = new Stack<>();

        public static boolean isEmpty(){
            return stack1.isEmpty();
        }

        public static void add(int data){
            if(isEmpty()){
                stack1.push(data);
                return;
            }
             // step1:
            while(!isEmpty()){
                int top = stack1.pop();
                stack2.push(top);
            }

            //step2:
            stack1.push(data);

            //step3:
            while (!stack2.isEmpty()) {
                int top = stack2.pop();
                stack1.push(top);
            }
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty, cannot remove.");
                return -1;
            }

            int front = stack1.pop();
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }

            int front = stack1.peek();
            return front;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }
    }    
}
