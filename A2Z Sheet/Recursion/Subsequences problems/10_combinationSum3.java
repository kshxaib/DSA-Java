/*
        COMBINATION SUM III (FIXED SIZE + UNIQUE NUMBERS)

Definition:
Find all possible combinations of k numbers
that add up to n such that:

• Only numbers from 1 to 9 are used
• Each number is used at most once
• Combinations must have EXACTLY k elements


Example 1

Input:
k = 3, n = 7

Output:
[[1,2,4]]


Example 2

Input:
k = 3, n = 9

Output:
[[1,2,6], [1,3,5], [2,3,4]]


Core Idea (Backtracking)
At each number from 1 → 9,
we have 2 choices:

1. Pick the number
2. Skip the number


Why This Works

We explore all combinations of numbers 1–9
but restrict:

• total count = k
• total sum = n


Time Complexity: O(2^9) ≈ O(1)
Since numbers are fixed (1–9)

Space Complexity: O(k)
Recursion depth limited to k
*/

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