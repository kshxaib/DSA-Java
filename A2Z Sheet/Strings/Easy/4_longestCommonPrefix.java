class Solution {    
    public String longestCommonPrefix(String[] str) {

        Arrays.sort(str);

        String first = str[0];
        String last = str[str.length - 1];

        int i = 0;
        while(i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)){
            i++;
        }

        return first.substring(0, i);
    }
}

Longest Common Prefix
Subscribe to TUF+

Hints
Company
Write a function to find the longest common prefix string amongst an array of strings.



If there is no common prefix, return an empty string "".


Example 1

Input : str = ["flowers" , "flow" , "fly", "flight" ]

Output : "fl"

Explanation :

All strings given in array contains common prefix "fl".

Example 2

Input : str = ["dog" , "cat" , "animal", "monkey" ]

Output : ""

Explanation :

There is no common prefix among the given strings in array. 

give notes