/*
        BEST TIME TO BUY AND SELL STOCK
            (SINGLE TRANSACTION)

Problem:
Given an array where arr[i] represents the price of a
stock on day i, determine the maximum profit that can
be achieved by buying once and selling once.

Constraints:
- Buy must happen before selling.
- Only one transaction allowed.

Example:
arr = [10,7,5,8,11,9]

Buy at 5
Sell at 11

Profit = 11 - 5 = 6

Core Idea:
To maximize profit, we want:
Sell Price - Buy Price to be maximum.

Instead of checking all pairs (O(n²)),
we track the minimum price seen so far.

For each day:
1. Check if current price is lower → update buying price.
2. Otherwise calculate profit if we sell today.
3. Track the maximum profit.

Algorithm Steps:
1. Initialize:
      buyingPrice = ∞
      maxProfit = 0

2. Traverse prices:
      if price < buyingPrice
            update buyingPrice

      else
            calculate profit = price - buyingPrice
            update maxProfit

Example Walkthrough:
arr = [10,7,5,8,11,9]

10 → buy=10
7  → buy=7
5  → buy=5
8  → profit=3
11 → profit=6 (max)
9  → profit=4

Answer = 6

Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- Single pass algorithm
- Greedy approach
- No extra memory required

Key Interview Points:
- Track minimum price so far
- Profit calculated on every step
- Works because buying must occur before selling
*/

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