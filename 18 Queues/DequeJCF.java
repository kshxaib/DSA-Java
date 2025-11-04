// Problem: Demonstrate Deque (Double-Ended Queue) using Java Collection Framework

/*
Key Methods:
- addFirst(E e): Inserts element at the front.
- addLast(E e): Inserts element at the rear.
- removeFirst(): Removes element from the front.
- removeLast(): Removes element from the rear.
- getFirst(): Retrieves, but does not remove, the first element.
- getLast(): Retrieves, but does not remove, the last element.
*/

import java.util.*;
import java.util.LinkedList;

public class DequeJCF {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1);
        deque.addLast(2);  
        deque.getFirst();
        deque.getLast();
        deque.removeFirst();
        deque.removeLast();
    }
}

/*
Time Complexity: O(1) per operation

Space Complexity: - O(n) for storing elements in the deque.
*/
