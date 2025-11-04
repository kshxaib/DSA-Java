// Problem: Implement Queue using Java Collection Framework (JCF)

import java.util.*;
import java.util.LinkedList;

public class QueueJCF {
    public static void main(String[] args) {
        // Queue declaration using LinkedList
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();

        while (!queue.isEmpty()) {
            System.out.println(queue.peek()); 
            queue.remove();                  
        }
    }    
}

/*
Time Complexity:
add()    → O(1)
remove() → O(1)
peek()   → O(1)

Space Complexity: O(n)
*/
