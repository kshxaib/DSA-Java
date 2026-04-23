class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;

        for(int i=0; i<nums.length; i++){
            int odd = 0;

            for(int j=i; j<nums.length; j++){
                if(nums[j] % 2 == 1){
                    odd++;
                }

                if(odd > k){
                    break;
                }

                if(odd == k){
                    count++;
                }
            }
        }

        return count;
    }


    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
    public int atMost(int[] nums, int k) {
        int n = nums.length; 
        int count = 0;
        int odd = 0;

        int left = 0;
        int right = 0;

        while(right < n){
            if(nums[right] % 2 == 1){
                odd++;
            }

            while(odd > k){
                if(nums[left] % 2 == 1){
                    odd--;
                }

                left++;
            }

            count = count + (right - left +1);
            right++;
        }

        return count;
    }
}