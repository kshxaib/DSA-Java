
/*
        SORT CHARACTERS BY FREQUENCY

Problem:
Given a string s, return the list of unique characters
sorted by highest frequency.

If two characters have the same frequency,
they must be sorted alphabetically.


Example
Input:
s = "tree"

Output:
['e', 'r', 't']

Explanation:
Frequency:
e → 2
r → 1
t → 1
*/
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        pq.addAll(map.entrySet());

        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.remove();

            char ch = entry.getKey();
            int freq = entry.getValue();

            while(freq > 0){
                ans.append(ch);
                freq--;
            }
        }

        return ans.toString();
    }
}

// Time: O(n)
// Space: O(n)