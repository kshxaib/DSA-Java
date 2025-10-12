import java.util.*;
import java.util.LinkedList;

public class QueueJCF {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Display elements while removing them
        while (!queue.isEmpty()) {
            System.out.println(queue.peek()); // Show front element
            queue.remove();                   // Remove front element
        }
    }    
}
