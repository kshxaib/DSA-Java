class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWtr = 0;

        int i = 0, j = n -1;

        while(i < j){
            int wtrLvl = Math.min(height[i], height[j]);
            int widht = j - i;
            int wtr = widht * wtrLvl;

            maxWtr = Math.max(maxWtr, wtr);

            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }

        return maxWtr;
    }
}