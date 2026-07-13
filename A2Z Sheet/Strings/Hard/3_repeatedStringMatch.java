class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder repeated = new StringBuilder();
        int count = 0;

        while(repeated.length() < b.length()){
            repeated.append(a);
            count++;
        }

        if(repeated.indexOf(b) != -1){
            return count;
        }

        repeated.append(a);
        if(repeated.indexOf(b) != -1){
            return count+1;
        }

        return -1;
    }
}