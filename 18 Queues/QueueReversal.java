import java.util.*;
import java.util.LinkedList;

public class QueueReversal {
    public static void QueueReverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()){
            int front = queue.remove();
            stack.push(front);
        }

        while(!stack.isEmpty()){
            int top = stack.pop();
            queue.add(top);
        }
    }

    public static void main(String[] args) {
       Queue<Integer> queue = new LinkedList<>();
       queue.add(1); 
       queue.add(2); 
       queue.add(3); 
       queue.add(4); 
       queue.add(5); 

       QueueReverse(queue);

       while(!queue.isEmpty()){
        System.out.println(queue.remove());
       }
    }    
}
