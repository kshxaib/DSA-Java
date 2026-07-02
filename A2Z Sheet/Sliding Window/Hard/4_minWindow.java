class Solution {
    // Time: O(n² x m)
    public String minWindowBrute(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int startingIdx = -1;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int k = 0;
            for (int j = i; j < n; j++) {
                if (k < m && s1.charAt(j) == s2.charAt(k)) {
                    k++;
                }

                if (k == m) {
                    int len = j - i + 1;
                    if (len < minLen) {
                        minLen = len;
                        startingIdx = i;
                    }

                    break;
                }
            }
        }

        if (startingIdx == -1) {
            return "";
        }

        return s1.substring(startingIdx, startingIdx + minLen);
    }

    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int minLen = Integer.MAX_VALUE;
        int startingIdx = -1;

        int j = 0;
        for(int i=0; i<n; i++){
            if(j<m && s1.charAt(i) == s2.charAt(j)){
                j++;

                if(j == m){
                    int endingIdx = i; // i was not increased yet
                    j--; // because j was already went out of bound

                    while(j>=0){
                        if(s1.charAt(i) == s2.charAt(j)){
                            j--;
                        }
                        i--;
                    }
                    int windowStart = i+1;
                    int len = endingIdx - windowStart +1;

                    if(len < minLen){
                        minLen = len;
                        startingIdx = windowStart;
                    }

                    i++;
                    j=0;
                }
            }
        }

        return startingIdx == -1 ? "" : s1.substring(startingIdx, startingIdx + minLen);
    }
}
