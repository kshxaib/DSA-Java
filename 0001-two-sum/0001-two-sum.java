class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int valueIndexPairs [][] = new int[n][2];
        for(int i=0; i<n; i++){
            valueIndexPairs[i][0] = nums[i];
            valueIndexPairs[i][1] = i;
        }

        Arrays.sort(valueIndexPairs, Comparator.comparingInt(pair -> pair[0]));

        int left = 0;
        int right = n -1;

        while(left<right){
            int sum = valueIndexPairs[left][0] + valueIndexPairs[right][0];

            if(sum == target){
                return new int[] {valueIndexPairs[left][1], valueIndexPairs[right][1]};
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}

// Time: O(n)
// Space: O(1)