class Solution {
    public int maxProfit(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;    // minimum buying price
        int maxProfit = 0;  // maximum profit

        for(int i=0; i<prices.length; i++){
            if(buyingPrice < prices[i]){    // better buying price found
                int profit = prices[i] - buyingPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else {                        // sell today
                buyingPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
