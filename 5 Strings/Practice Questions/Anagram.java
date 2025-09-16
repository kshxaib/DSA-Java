public class Anagram {
    public static boolean checkAnagram(String str1, String str2) {
        // Step 1: Remove spaces and convert to lowercase
        str1 = str1.replace(" ", "").toLowerCase();
        str2 = str2.replace(" ", "").toLowerCase();

        // Step 2: If lengths differ → not an anagram
        if (str1.length() != str2.length()) {
            return false;
        }

        // Step 3: Frequency array for 26 lowercase English letters
        int freq[] = new int[26];

        // Step 4: Increase count for str1, decrease for str2
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a']++;
            freq[str2.charAt(i) - 'a']--;
        }

        // Step 5: If all counts are zero → valid anagram
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        String str1 = "listen";
        String str2 = "silent";

        if (checkAnagram(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are Anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are NOT Anagrams.");
        }
        // Total Time Complexity: O(n)
        // Space Complexity: O(1) (since freq array size = 26, constant space)
    }
}
