class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = true;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            sign = false;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int ans = 0;
        while(a >= b){

            int shift = 0;
            while(a >= (b << (shift +1))){
                shift++;
            }

            a -= b << shift;
            ans += 1 << shift;
        }

        return sign ? ans : -ans;
    }
}