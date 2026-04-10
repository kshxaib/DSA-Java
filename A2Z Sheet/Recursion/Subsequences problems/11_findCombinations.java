class Solution {

    public void findCombinations(List<String> ans, String curr, String digits, String[] map, int index) {

        if (index == digits.length()) {
            ans.add(curr);
            return;
        }

        int currNum = digits.charAt(index) - '0';
        String letters = map[currNum];

        for (int i=0; i<letters.length(); i++) {
            findCombinations(ans, curr + letters.charAt(i), digits, map, index + 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        findCombinations(ans, "", digits, map, 0);

        return ans;
    }
}