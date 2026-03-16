class Solution {    
    public List<Character> frequencySort(String s) {
        int freq[] = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        List<Character>[] bucket = new ArrayList[s.length() +1];
        for(int i=0; i<26; i++){
            if(freq[i] > 0){
                
                int f = freq[i];
                if(bucket[f] == null){
                    bucket[f] = new ArrayList<>();
                }

                bucket[f].add((char)(i + 'a'));
            }
        }

        List<Character> result = new ArrayList<>();

        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                Collections.sort(bucket[i]);
                result.addAll(bucket[i]);
            }
        }

        return result;
    }
}