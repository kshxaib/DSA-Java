import java.util.*;

class Solution {
    public int singleNumberBrute(int[] nums) {
        int ans = 0;
        
        for(int bitIdx = 0; bitIdx<31; bitIdx++){
            int countOfSetBits = 0;

            for(int i=0; i<nums.length; i++){
                if((nums[i] & (1 << bitIdx)) != 0){
                    countOfSetBits++;
                }
            }

            if(countOfSetBits % 3 == 1){
                ans = ans | (1 << bitIdx);
            }
        }

        return ans;
    }

    public int singleNumberBetter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int i=1;
        while(i<n){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }

            i = i+3;
        }

        return nums[n-1];
    }

    public int singleNumber(int[] nums) {
        int n = nums.length;
        
        int ones = 0;
        int twos = 0;

        for(int i=0; i<n; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }

        return ones;
    }
}

