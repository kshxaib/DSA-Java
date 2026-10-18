class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < n){
            char currChar = s.charAt(right);

            while(set.contains(currChar)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(currChar);
            maxLen = Math.max(maxLen, right - left + 1);  // Or set.size()
            right++;
        }

        return maxLen;
    }
}