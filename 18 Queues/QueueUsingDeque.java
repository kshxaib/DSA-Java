import java.util.*;
import java.util.LinkedList;

public class QueueUsingDeque {
    static class Queue{
        Deque<Integer> deque = new LinkedList<>();

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public void add(int data) {
            deque.addLast(data); 
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot remove.");
                return -1;
            }
            return deque.removeFirst();
        }

        public int front() {
            if (isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }
            return deque.getFirst(); 
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
