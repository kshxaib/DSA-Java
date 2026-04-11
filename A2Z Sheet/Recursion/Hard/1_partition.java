/*
        PALINDROME PARTITIONING

Problem:
Given a string s,
partition it such that every substring
in the partition is a PALINDROME.

Return all possible palindrome partitions.


Example 1

Input:
s = "aab"

Output:
[
 ["a","a","b"],
 ["aa","b"]
]


Example 2

Input:
s = "a"

Output:
[
 ["a"]
]


Core Idea (Backtracking)

We try to cut the string at every possible index,
but ONLY if the substring is a palindrome.


Why This Works
At every position:
we try all possible substrings starting from index.

If substring is palindrome:
→ include it
→ recursively solve remaining string


Time Complexity: O(2^n * n)
Explanation:
• 2^n possible partitions
• Each substring check takes O(n)

Space Complexity: O(n)
Recursion depth


Code Explanation

findPartitions:
→ tries all substring partitions
→ checks palindrome
→ builds answer using backtracking

isPalindrome:
→ checks substring validity

partition:
→ initializes recursion
*/

class Solution {

    public void findPartitions(String s, List<List<String>> ans, List<String> curr, int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < s.length(); i++){

            // check palindrome
            if(isPalindrome(s, index, i)){

                // pick substring
                curr.add(s.substring(index, i + 1));

                // recurse for remaining string
                findPartitions(s, ans, curr, i + 1);

                // backtrack
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int index, int i){
        while(index < i){
            if(s.charAt(index) != s.charAt(i)){
                return false;
            }
            index++;
            i--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        findPartitions(s, ans, curr, 0);
        return ans;
    }
}