class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int startingIdx = -1;

        for(int i=0; i<s.length(); i++){
            int hash[] = new int[256];
            for(int k=0; k<t.length(); k++){
                hash[t.charAt(k)]++;
            }
            
            int count = 0;
            for(int j=i; j<s.length(); j++){
                if(hash[s.charAt(j)] > 0){
                    count++;
                }
                hash[s.charAt(j)]--;

                if(count == t.length()){
                    int len = j -i +1;
                    if(len < minLen){
                        minLen = len;
                        startingIdx = i;
                        break;
                    } 
                }
            }
        }   

        if(startingIdx == -1) return "";

        return s.substring(startingIdx, startingIdx + minLen);
    }


    public String minWindow(String s, String t) {
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        int startingIdx = -1;

        int hash[] = new int[256];
        int count = 0;

        int left = 0;
        int right = 0;

        for(int i=0; i<t.length(); i++){
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