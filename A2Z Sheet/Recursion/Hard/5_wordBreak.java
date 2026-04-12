class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Converting the dict to hashset for O(1) accessing
        Set<String> wordSet = new HashSet<>(wordDict);

        // finding max length to know till when we have to lookup for word
        int maxLen = 0;
        for(String word : wordDict){
            maxLen = Math.max(maxLen, word.length());
        }
        
        // dp[i] states if the substring dp[0..i] can be segmented
        int n = s.length();
        boolean dp[] = new boolean[n+1];

        // base case: empty string can be segmented
        dp[0] = true;

        for(int i=1; i<=n; i++){
            for(int j=i-1; j>= Math.max(0, i-maxLen); j--){
                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}