/*
        WORD BREAK (DYNAMIC PROGRAMMING)

Definition:
Given a string s and a dictionary wordDict,
return true if s can be segmented into
space-separated sequence of dictionary words.

• Words can be reused multiple times


Example 1

Input:
s = "leetcode"
wordDict = ["leet","code"]

Output:
true

Explanation:
"leet code"


Example 2

Input:
s = "applepenapple"
wordDict = ["apple","pen"]

Output:
true

Explanation:
"apple pen apple"


Example 3

Input:
s = "catsandog"
wordDict = ["cats","dog","sand","and","cat"]

Output:
false


Core Idea (Dynamic Programming)
We check:
Can we break string from 0 → i ?

dp[i] = true
→ if substring s[0..i-1] can be formed


Why This Works

Instead of checking all partitions recursively,
we store results of smaller substrings.


Time Complexity: O(n * maxLen)
Worst case substring check + lookup

Space Complexity: O(n)
DP array
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // Step 1: Convert list to set for fast lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // Step 2: Find max word length
        int maxLen = 0;
        for(String word : wordDict){
            maxLen = Math.max(maxLen, word.length());
        }
        
        int n = s.length();

        // Step 3: DP array
        boolean dp[] = new boolean[n+1];

        // Step 4: Base case
        dp[0] = true;

        // Step 5: Fill DP
        for(int i = 1; i <= n; i++){

            // limit checking using maxLen
            for(int j = i-1; j >= Math.max(0, i-maxLen); j--){

                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        // Step 6: Answer
        return dp[n];
    }
}