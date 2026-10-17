class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean visited[] = new boolean[strs.length];

        for(int i=0; i<strs.length; i++){
            if(visited[i]){
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for(int j=i+1; j<strs.length; j++){
                if(!visited[j] && isAnagram(strs[i], strs[j])){
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }

            result.add(group);
        }

        return result;
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}