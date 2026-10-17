class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            int freq[] = new int[26];

            for(int i=0; i<s.length(); i++){
                freq[s.charAt(i) - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int count : freq){
                key.append(count).append("#");
            }

            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(s);
        } 

        return new ArrayList<>(map.values());
    }
}