class Solution {
    static long MOD = 1000000007;
    public int countGoodNumbers(long n) {

        long evenPositions = (n +1)/2;
        long oddPositions = n/2;

        long evenWays = power(5, evenPositions);
        long oddWays = power(4, oddPositions);

        int totalWays = (int) ((evenWays * oddWays) % MOD);
        return totalWays;
    }

    private long power(long x, long n){
        if(n == 0) return 1;

        long half = power(x, n/2);

        if(n%2 == 0){
            return ((half * half ) % MOD);
        } else {
            return ((half * half * x) % MOD);
        }
    }
}