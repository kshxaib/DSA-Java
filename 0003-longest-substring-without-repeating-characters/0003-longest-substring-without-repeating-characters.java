class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        int maxLen = 0;
        int left = 0;
        int right = 0;

        while(right < n){
            char currChar = s.charAt(right);

            while(set.contains(currChar)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(currChar);
            int len = right - left +1;
            maxLen = Math.max(maxLen, len);

            right++;
        }

        return maxLen;
    }
}