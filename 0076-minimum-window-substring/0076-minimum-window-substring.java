class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        int startingIdx = -1;

        int hash[] = new int[256];
        int count = 0;

        int left = 0;
        int right = 0;

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        while(right < n){
            char rightChar = s.charAt(right);

            if(hash[rightChar] > 0){
                count++;
            }
            hash[rightChar]--;

            while(count == t.length()){
                int len = right - left +1;
                if(len < minLen){
                    minLen = len;
                    startingIdx = left;
                }

                char leftChar = s.charAt(left);
                hash[leftChar]++;

                if(hash[leftChar] > 0){
                    count--;
                }

                left++;
            }

            right++;
        }

        if(startingIdx == -1) return "";
        return s.substring(startingIdx, startingIdx + minLen);
    }
}