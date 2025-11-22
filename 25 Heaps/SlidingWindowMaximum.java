import java.util.*;

public class SlidingWindowMaximum {
    public static void findGreater(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Step 1: Add first k elements
        for(int i = 0; i < k; i++){
            pq.add(arr[i]);
        }

        // Step 2: Print maximum of first window
        System.out.println(pq.peek());

        // Step 3: Slide the window
        for(int i = k; i < arr.length; i++) {
            
            // 3.1 Remove outgoing element (slow: O(n))
            pq.remove(arr[i - k]);

            // 3.2 Add incoming element
            pq.add(arr[i]);

            // 3.3 Print max of current window
            System.out.println(pq.peek());
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        findGreater(arr, k);
    }
}

/*
Explanation:
Time Complexity:
1. Inserting first k elements: O(k log k)
2. For each of remaining (n-k) windows:
      Removal = O(k)   [because pq.remove(value) is linear]
      Insertion = O(log k)
So total = O(n*k) in worst case

Space Complexity:
Max-heap stores at most k elements → O(k)
*/
