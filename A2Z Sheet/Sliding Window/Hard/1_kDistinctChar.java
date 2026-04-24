class Solution {
    public int kDistinctChar(String s, int k) {
        int maxLen = 0;

        for(int i=0; i<s.length(); i++){
            int len = 0;
            Map<Character, Integer> freq = new HashMap<>();

            for(int j=i; j<s.length(); j++){
                char ch = s.charAt(j);
                freq.put(ch, freq.getOrDefault(ch, 0) +1);

                if(freq.size() > k) break;

                len = j -i +1;
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }


    public int kDistinctChar(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        int left = 0;
        int right = 0;

        Map<Character, Integer> freq = new HashMap<>();

        while(right < n){
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) +1);

            while(freq.size() > k){
                freq.put(s.charAt(left), freq.get(s.charAt(left)) -1);

                if(freq.get(s.charAt(left)) == 0){
                    freq.remove(s.charAt(left));
                }

                left++;
            }

            int len = right - left +1;
            maxLen = Math.max(maxLen, len);

            right++;
        }

        return maxLen;
    }
}