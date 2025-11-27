import java.util.HashMap;

public class ValidAnagaram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        // Create a HashMap to store the frequency of each character in the first string
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        // Iterate through the second string and decrement the frequency of each character in the HashMap
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch) == null){
                return false;
            }
            map.put(ch, map.get(ch) -1);
        }

        // Check if all frequencies became zero
        for (int freq : map.values()) {
            if (freq != 0) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}


// Time Complexity: O(n)
// Space Complexity: O(n)
