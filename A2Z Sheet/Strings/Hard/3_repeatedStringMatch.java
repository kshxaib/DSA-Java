class Solution {
    public int repeatedStringMatchBrute(String a, String b) {
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

    public int repeatedStringMatch(String a, String b) {
        int requiredRepeats = (b.length() + a.length() - 1) / a.length();

        StringBuilder repeated = new StringBuilder();

        for (int i = 0; i < requiredRepeats; i++){
            repeated.append(a);

        }

        if(repeated.indexOf(b) != -1){
            return requiredRepeats;
        }

        repeated.append(a);
        if(repeated.indexOf(b) != -1){
            return requiredRepeats+1;
        }

        return -1;
    }
}