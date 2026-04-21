class Solution {
    //Time: O(N^2)  Space: O(256)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        
        for(int i=0; i<n; i++){
            int map[] = new int[256];
            for(int j=i; j<n; j++){
                int val = s.charAt(j) - '0';
                if(map[val] == 1){
                    break;
                } else {
                    map[val] = 1;
                }

                int currLen = j - i +1;
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }

    //Time: O(N)  Space: O(256)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int hash[] = new int[256];
        Arrays.fill(hash, -1);

        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < n){
            int currChar = s.charAt(right);

            // it means this character is already in curr substring
            if(hash[currChar] >= left){ 
                left = hash[currChar] +1;
            }

            int len = right - left +1;

            maxLen = Math.max(maxLen, len);

            // store or update the index of current character
            hash[currChar] = right;

            right++;
        }

        return maxLen;
    }
} 