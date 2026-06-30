class Solution {
    public int sum(int a, int b) {
        while(b != 0){
            int temp = (a & b);
            a = a ^ b;
            b = temp << 1;
        }

        return a;
    }
}