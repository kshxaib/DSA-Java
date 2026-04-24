class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for(int i=0; i<n; i++){
            Map<Integer, Integer> freq = new HashMap<>();

            for(int j=i; j<n; j++){
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) +1);

                if(freq.size() > k){
                    break;
                }

                if(freq.size() == k){
                    count++;
                }
            }
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int lessThanEqualsToK = atMost(nums, k);
        int lessThanEqualsToKMinus1 = atMost(nums, k -1);
        int count = lessThanEqualsToK - lessThanEqualsToKMinus1;
        return count;
    }
    public int atMost(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        int left = 0;
        int right = 0;
        
        Map<Integer, Integer> freq = new HashMap<>();

        while(right < n){
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) +1);

            while(freq.size() > k){
                int val = nums[left];
                freq.put(val, freq.get(val) -1);

                if(freq.get(val) == 0){
                    freq.remove(val);
                }

                left++;
            }

            count = count + (right - left +1);

            right++;
        }

        return count;
    }
}