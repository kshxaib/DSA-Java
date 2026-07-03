/*
        TOP K FREQUENT ELEMENTS


Definition:
Given integer array nums[]
and integer k,

Return k most frequent elements.


Example 1

Input:
nums = [1,1,1,2,2,3]
k = 2

Output:
[1,2]


Example 2

Input:
nums = [1]
k = 1

Output:
[1]


=====================================================
1. BRUTE FORCE
=====================================================

Idea:

1. Count frequencies.
2. Repeat k times:
   Find current maximum frequency.
3. Mark it as used.


Time Complexity
Frequency Count = O(n)
Finding max frequency: O(k * uniqueElements)
Worst Case: O(n²)

Space Complexity: O(n)
*/

import java.util.*;

class Solution {

    public int[] topKFrequentBrute(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // count frequencies
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int result[] = new int[k];

        for (int i = 0; i < k; i++) {
            int maxFreq = -1;
            int element = -1;

            // find current max frequency
            for (int key : freq.keySet()) {
                if (freq.get(key) > maxFreq) {
                    maxFreq = freq.get(key);
                    element = key;
                }
            }

            result[i] = element;

            // mark as used
            freq.put(element, -1);
        }

        return result;
    }

    /*
     * =====================================================
     * 2. BUCKET SORT (OPTIMAL)
     * =====================================================
     * 
     * Idea:
     * Frequency can be at most n.
     * 
     * Create buckets:
     * bucket[i] = all numbers appearing i times
     * 
     * Then traverse buckets
     * from high frequency to low frequency.
     * 
     * 
     * Time Complexity
     * Frequency Count = O(n)
     * Bucket Fill = O(n)
     * Bucket Traversal = O(n)
     * Total = O(n)
     * 
     * Space Complexity: O(n)
     */

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] buckets = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int key : freq.keySet()) {
            int frequency = freq.get(key);
            buckets[frequency].add(key);
        }

        int result[] = new int[k];
        int count = 0;
        for (int i = buckets.length - 1; i >= 0 && count < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[count] = num;
                    count++;
                    if (count == k)
                        break;
                }
            }
        }

        return result;
    }
}
