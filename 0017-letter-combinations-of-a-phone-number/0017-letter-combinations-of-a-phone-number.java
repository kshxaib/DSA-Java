class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        findCombinations(ans, new StringBuilder(), digits, map, 0);
        return ans;
    }

    public void findCombinations(List<String> ans,  StringBuilder curr, String digits, String[] map, int index) {
        if (index == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        int currNum = digits.charAt(index) - '0';
        String letters = map[currNum];

        for (int i=0; i<letters.length(); i++) {
            curr.append(letters.charAt(i));
            findCombinations(ans, curr, digits, map, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}