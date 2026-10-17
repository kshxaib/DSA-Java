class Solution {
    public int maxArea(int[] height) {
        int maxWtr = 0;
       
        int left = 0;
        int right = height.length -1;

        while(left < right){
            int wtrLvl = Math.min(height[left], height[right]);
            int widht = right - left;
            int wtr = widht * wtrLvl;

            maxWtr = Math.max(maxWtr, wtr);

            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }

        return maxWtr;
    }
}