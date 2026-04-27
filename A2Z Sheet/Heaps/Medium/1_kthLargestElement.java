/*
        KTH LARGEST ELEMENT IN ARRAY

Definition:
Given unsorted array nums[]
and integer k,

Return kth largest element.

Important:

kth largest in sorted order,
NOT kth distinct largest.


Example 1

Input:
nums = [3,2,1,5,6,4]
k = 2

Output:
5

Sorted descending:

[6,5,4,3,2,1]

2nd largest = 5


Example 2

Input:
nums = [3,2,3,1,2,4,5,5,6]
k = 4

Output:
4


Core Idea

Need top k largest numbers.


1. SORTING SOLUTION
Sort ascending.

Answer at:
nums[n - k]

Time Complexity: O(n log n)
Space depends on sort implementation.
*/

import java.util.*;

class Solution {

    public int kthLargestElementSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


/*
2. MIN HEAP SOLUTION
Maintain min heap of size k.
Heap stores current k largest elements.
Smallest among them at top.


Why This Works
If new element > heap top,

it deserves place in top k.
Remove smallest and insert new.

At end:
heap top = kth largest


Time Complexity: O(n log k)
Better when k << n


Space Complexity: O(k)
*/

    public int kthLargestElement(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // first k elements
        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }

        // process remaining
        for(int i = k; i < nums.length; i++){
            int ele = nums[i];

            if(ele > pq.peek()){
                pq.remove();
                pq.add(ele);
            }
        }

        return pq.peek();
    }
}