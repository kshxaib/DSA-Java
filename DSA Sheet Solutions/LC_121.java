class Solution {
    public int maxProfit(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            if(buyingPrice < prices[i]){
                int profit = prices[i] - buyingPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else {
                buyingPrice = prices[i];
            }
        }

        return maxProfit;
    }
}

// Time: O(n)
// Space: O(1)