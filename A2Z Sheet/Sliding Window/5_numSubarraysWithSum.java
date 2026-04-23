class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum == goal){
                    ans++;
                }
            }
        }

        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(map.containsKey(sum - goal)){
                ans += map.get(sum - goal);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int lessThanGoal = (countSubarrays(nums, goal));
        int lessThanGoalMinus1 = (countSubarrays(nums, goal -1));
        int equalsToGoal = lessThanGoal - lessThanGoalMinus1;
        return equalsToGoal;
    }

    public int countSubarrays(int nums[], int goal){
        if(goal < 0) return 0;

        int n = nums.length;
        
        int left = 0;
        int right = 0;

        int sum = 0;
        int count = 0;

        while(right < n){
            sum += nums[right];

            while(sum > goal){
                sum -= nums[left];
                left++;
            }

            count = count + (right - left +1);
            right++;
        }

        return count;
    }
}