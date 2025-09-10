public class BuyAndSell {

    // ---------------- Brute Force Approach ----------------
    // Try all possible pairs of (buy day, sell day) and find maximum profit.
    // Time Complexity: O(n^2) -> two nested loops (i, j)
    // Space Complexity: O(1) -> only a few variables used
    public static int findMaxProfit(int prices[]) {
        int buyingPrice;                // stores the chosen buying price
        int sellingPrice;               // stores the chosen selling price
        int profit = Integer.MIN_VALUE; // maximum profit found so far

        // Outer loop -> pick a day to buy stock
        for (int i = 0; i < prices.length; i++) {
            buyingPrice = prices[i]; // assume we buy on day i

            // Inner loop -> pick a day to sell stock
            for (int j = i + 1; j < prices.length; j++) {
                sellingPrice = prices[j]; // assume we sell on day j

                // Calculate profit and check if it's the maximum
                if (sellingPrice - buyingPrice > profit) {
                    profit = sellingPrice - buyingPrice;
                }
            }
        }

        return profit; // return the maximum profit found
    }

    // ---------------- Optimized Approach ----------------
    // Use one pass to track the minimum buying price and maximum profit.
    // Time Complexity: O(n) -> single loop over prices
    // Space Complexity: O(1) -> only two variables used
    public static int findMaxProfitOptimize(int prices[]) {
        int buyingPrice = Integer.MAX_VALUE; // minimum price seen so far
        int maxProfit = 0;                   // maximum profit found

        // Loop through all days
        for (int i = 0; i < prices.length; i++) {
            // If we can make a profit today
            if (buyingPrice < prices[i]) {
                int profit = prices[i] - buyingPrice;    // potential profit
                maxProfit = Math.max(profit, maxProfit); // update max profit
            } else {
                // Update buyingPrice if today's price is lower
                buyingPrice = prices[i];
            }
        }

        return maxProfit; // return the maximum profit found
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};

        // Brute Force: Time O(n^2), Space O(1)
        // System.out.print(findMaxProfit(prices)); // Output: 5

        // Optimized: Time O(n), Space O(1)
        System.out.print(findMaxProfitOptimize(prices)); // Output: 5
    }
}
