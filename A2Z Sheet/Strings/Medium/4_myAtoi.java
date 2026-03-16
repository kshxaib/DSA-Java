class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        // skip leading spaces
        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        // sign detection
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }

        // digit conversion
        while(i < n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            if(result > (max - digit) / 10){
                return sign == 1 ? max : min;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}