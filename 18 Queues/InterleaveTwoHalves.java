import java.util.*;
import java.util.LinkedList;

public class InterleaveTwoHalves {
    public static void InterleaveTH(Queue<Integer> queue){
        Queue<Integer> forFirstHalf = new LinkedList<>();
        int sizeHalf = queue.size() / 2;
        
        for(int i=0; i<sizeHalf; i++){
            int front = queue.remove();
            forFirstHalf.add(front);
        }

        while(!forFirstHalf.isEmpty()){
            queue.add(forFirstHalf.remove());
            int front = queue.remove();
            queue.add(front);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        InterleaveTH(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
