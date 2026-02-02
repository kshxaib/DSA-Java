class Solution {
    public int stockBuySell(int[] arr, int n) {
        int maxProfit = 0;
        int buyingPrice = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            int currPrice = arr[i];
            if(currPrice < buyingPrice){
                buyingPrice = currPrice;
            } else {
                int currProfit = currPrice - buyingPrice;
                maxProfit = Math.max(currProfit, maxProfit);
            }
        }
 
        return maxProfit;
    }
}

// Time: O(n)
// Space: O(1)