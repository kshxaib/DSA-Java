class Solution {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        int index = 0;

        findSubset(nums, ans, sum, index);
        return ans;
    }

    public void findSubset(int nums[], List<Integer> ans, int sum, int index){
        if(index == nums.length){
            ans.add(sum);
            return;
        }

        sum += nums[index];
        findSubset(nums, ans, sum, index +1);

        sum -= nums[index];
        findSubset(nums, ans, sum, index +1);
    }
}