class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWtr = Integer.MIN_VALUE;
        int i = 0;
        int j= height.length -1;

        while(i<j){
            int minHgt = Math.min(height[i], height[j]);
            int width = j-i;
            int wtr = width * minHgt;

            maxWtr = Math.max(wtr, maxWtr);

            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }

        return maxWtr;
    }
}

// Time: O(n)
// Space: O(1)