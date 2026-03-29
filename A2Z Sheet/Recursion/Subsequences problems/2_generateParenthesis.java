class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateAns(ans, "", 0, 0, n);
        return ans;
    }

    public void generateAns(List<String> ans, String s, int open, int close, int n){
        if(s.length() == 2 *n){
            ans.add(s);
            return;
        }

        if(open < n){
            generateAns(ans, s+"(", open +1, close, n);
        }

        if(close < open){
            generateAns(ans, s+")", open, close +1, n);
        }
    }
}