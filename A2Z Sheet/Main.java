import java.util.*;
class Solution {
    // count subarrays with at most k distinct
    public int atMost(int[] nums, int k) {
        if(k < 0) return 0;

        int n = nums.length;
        int left = 0, right = 0;

        int count = 0;

        Map<Integer,Integer> freq = new HashMap<>();

        while(right < n){
            // include right element
            freq.put(nums[right], freq.getOrDefault(nums[right],0) + 1);

            // shrink invalid window
            while(freq.size() > k){
                int val = nums[left];
                freq.put(val, freq.get(val) - 1);

                if(freq.get(val) == 0){
                    freq.remove(val);
                }

                left++;
            }

            
            // all subarrays ending at right from left...right valid
            count += (right - left + 1);
            right++;
        }

        return count;
    }
}