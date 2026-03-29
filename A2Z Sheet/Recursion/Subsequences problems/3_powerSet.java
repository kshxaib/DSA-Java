class Solution {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateAns(ans, curr, 0, nums);
        return ans;
    }

    public void generateAns(List<List<Integer>> ans, List<Integer> curr, int index, int nums[]) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr)); 
            return;
        }

        // pick
        curr.add(nums[index]);
        generateAns(ans, curr, index + 1, nums);

        // backtrack
        curr.remove(curr.size() - 1);

        // not pick
        generateAns(ans, curr, index + 1, nums);
    }
}