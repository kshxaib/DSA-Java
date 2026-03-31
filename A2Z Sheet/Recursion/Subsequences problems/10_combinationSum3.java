class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int num = 1;

        findCombinations(ans, curr, num, k, n);
        return ans;
    }

    public void findCombinations(List<List<Integer>> ans, List<Integer> curr, int num, int k, int n){
        if(n == 0 && curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(n < 0 || curr.size() > k || num > 9){
            return;
        }

        curr.add(num);
        findCombinations(ans, curr, num +1, k, n - num);

        curr.remove(curr.size() -1);
        findCombinations(ans, curr, num +1, k, n);
    }
}