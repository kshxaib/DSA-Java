class Solution {
    public int minAddToMakeValid(String s) {

        while (true) {
            String newStr = s.replace("()", "");
            if (newStr.equals(s))
                break;
            s = newStr;
        }

        return s.length();
    }
}


