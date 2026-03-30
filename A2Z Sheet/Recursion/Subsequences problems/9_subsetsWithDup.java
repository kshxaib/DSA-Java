import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); 

        findSubsets(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void findSubsets(int[] nums, List<List<Integer>> ans,
                            List<Integer> curr, int index) {

        ans.add(new ArrayList<>(curr)); // add at every step

        for (int i = index; i < nums.length; i++) {

            // skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);

            findSubsets(nums, ans, curr, i + 1);

            curr.remove(curr.size() - 1);
        }
    }
}