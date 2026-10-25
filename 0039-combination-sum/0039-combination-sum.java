class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int index = 0;

        findCombinations(candidates, ans, curr, index, target);
        return ans;
    }

    public void findCombinations(int candidates[], List<List<Integer>> ans, List<Integer> curr, int index, int target){
        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if(candidates[index] <= target){
            curr.add(candidates[index]);
            target = target - candidates[index];

            findCombinations(candidates, ans, curr, index, target);
            curr.remove(curr.size() -1);
            target = target + candidates[index];
        }

        findCombinations(candidates, ans, curr, index +1, target);
    }
}