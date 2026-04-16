class Solution {
    public int findRangeXOR(int l, int r) {
        int tillLMinus1 = findXorTillN(l -1);
        int tillR = findXorTillN(r);
        return tillLMinus1 ^ tillR;
    }

    public int findXorTillN(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0; // n % 4 == 3
    }
}