class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;

        for(int i=0; i<s.length(); i++){
            boolean hasA = false;
            boolean hasB = false;
            boolean hasC = false;

            for(int j=i; j<s.length(); j++){
                if(s.charAt(j) == 'a') hasA = true;
                if(s.charAt(j) == 'b') hasB = true;
                if(s.charAt(j) == 'c') hasC = true;

                if(hasA && hasB && hasC){
                    count++;
                }
            }

        }
        return count;
    }

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int freq[] = new int[3];
        int count = 0;

        int left = 0;
        int right = 0;

        while(right < n){
            freq[s.charAt(right) - 'a']++;

            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                count += (n - right);
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return count;
    }
}