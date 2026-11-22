class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int maxProfit = 0;
        int buyingPrice = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int price = prices[i];

            if(price < buyingPrice){
                buyingPrice = price;
            } else {
                int profit = price - buyingPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}