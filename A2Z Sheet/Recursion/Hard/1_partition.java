class Solution {
    public void findPartitions(String s, List<List<String>> ans, List<String> curr, int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                curr.add(s.substring(index, i+1));
                findPartitions(s, ans, curr,  i+1);
                curr.remove(curr.size() -1);
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