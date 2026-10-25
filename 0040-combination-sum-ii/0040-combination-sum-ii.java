class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        int index = 0;

        findCombinations(candidates, ans, curr, index, target);
        return ans;
    }

    public void findCombinations(int candidates[], List<List<Integer>> ans, List<Integer> curr, int index, int target){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }

            if(candidates[i] <= target){
                curr.add(candidates[i]);
                target = target - candidates[i];

                findCombinations(candidates, ans, curr, i +1, target);
                curr.remove(curr.size() -1);
                target = target + candidates[i];
            }
        }
    }
}