/*
        MAXIMUM SUM COMBINATIONS

Definition:
Given two arrays nums1[] and nums2[]
of size n,

Find the top k maximum values of:

nums1[i] + nums2[j]

Return the k largest pair sums.


Example

Input:

nums1 = [1,4,2,3]
nums2 = [2,5,1,6]

k = 4


All Pair Sums

1+2=3
1+5=6
1+1=2
1+6=7

4+2=6
4+5=9
4+1=5
4+6=10

2+2=4
2+5=7
2+1=3
2+6=8

3+2=5
3+5=8
3+1=4
3+6=9


Largest 4:

10, 9, 9, 8

Output:

[10,9,9,8]


=====================================================
1. BRUTE FORCE
=====================================================

Generate all pair sums.
Store them.
Sort descending.

Take first k.


Why This Works
All possible sums are explicitly computed.
Then sorting gives largest sums.


Time Complexity
Generate sums: O(n²)
Sort: O(n² log(n²))
≈ O(n² log n)

Space Complexity: O(n²)
Store all pair sums
*/

import java.util.*;

class Solution {

    public int[] maxSumCombinationsBrute(
            int[] nums1,
            int[] nums2,
            int k) {

        ArrayList<Integer> pairSum = new ArrayList<>();

        // generate all pair sums
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                pairSum.add(nums1[i] + nums2[j]);
            }
        }

        // descending order
        Collections.sort(pairSum, Collections.reverseOrder());

        int result[] = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pairSum.get(i);
        }

        return result;
    }


/*
=====================================================
2. OPTIMAL (MAX HEAP)
=====================================================

Core Idea

After sorting arrays:
Largest sum must be: nums1[n-1] + nums2[n-1]

Use Max Heap.


Observation

If (i,j) gives current maximum sum,
Next candidates can only be: (i-1,j) or (i,j-1)


Why?
Arrays are sorted.
Moving left decreases sum.


Data Stored In Heap
[sum, i, j]
sum = nums1[i] + nums2[j]


Need Visited Set

Without visited:

Same pair can enter heap
multiple times.


Time Complexity
Sorting: O(n log n)

Heap operations: k extractions
Each: O(log k)

Total: O(n log n + k log k)


Space Complexity: O(k)
Heap + visited
*/

    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // sort arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // max heap by sum
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        // avoid duplicate states
        HashSet<String> visited = new HashSet<>();

        // largest possible pair
        maxHeap.add(new int[]{nums1[n-1] + nums2[n-1], n-1, n-1});
        visited.add((n-1) + "#" + (n-1));

        int ans[] = new int[k];
        int index = 0;

        while(index < k){
            int curr[] = maxHeap.remove();

            int sum = curr[0];
            int i = curr[1];
            int j = curr[2];

            ans[index++] = sum;

            if(i - 1 >= 0){
                String key =(i - 1) + "#" + j;

                if(!visited.contains(key)){
                    maxHeap.add(new int[]{nums1[i-1] + nums2[j], i-1, j});
                    visited.add(key);
                }
            }

            if(j - 1 >= 0){
                String key = i + "#" + (j - 1);

                if(!visited.contains(key)){
                    maxHeap.add(new int[]{nums1[i] + nums2[j-1], i, j-1});
                    visited.add(key);
                }
            }
        }

        return ans;
    }
}
