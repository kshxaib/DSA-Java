class Solution {
    public boolean checkIthBit(int n, int i) {
        int leftShift = 1 << i;
        int result = n & leftShift;

        if(result == 0){
            return false;
        }

        return true;
    }
}