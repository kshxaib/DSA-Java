class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int freq[] = new int[26];
        
        int left = 0;
        int right = 0;

        int maxFreq = 0;
        int maxLen = 0;

        while(right < n){
            int currChar = s.charAt(right);
            freq[currChar - 'A']++;

            maxFreq = Math.max(maxFreq, freq[currChar - 'A']);

            while((right - left +1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left +1);
            right++;
        }

        return maxLen;
    }
}