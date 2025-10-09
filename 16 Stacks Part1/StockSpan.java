import java.util.*;

// Problem: Stock Span Problem
/*
📌 Problem Statement:
Given the daily prices of a stock, find the **span** of each day’s price.  
The span of a stock's price on a given day is the **number of consecutive days before it**
(including the current day) where the price of the stock was **less than or equal to** today’s price.

Example:
Input  → [100, 80, 60, 70, 60, 85, 100]
Output → [1, 1, 1, 2, 1, 4, 7]

👉 Concept:
- For each stock price, we need to check how many previous days had lower or equal prices.
- Instead of checking each day manually (which is O(n²)),
  we use a **stack** to store indices of the previous **higher** stock prices.
- This way, we efficiently compute spans in **O(n)** time.

✅ Key Idea:
Use a stack to maintain indices of previous higher stock prices.
Whenever the current price is higher, we pop smaller prices from the stack.
*/

public class StockSpan {

    // 🔹 Function to calculate span of stock prices
    public static void findStocksSpan(int stocks[], int spans[]) {
        Stack<Integer> stack = new Stack<>();  // Stack to store indices
        spans[0] = 1;                          // Span of first element is always 1
        stack.push(0);                         // Push index 0

        // Traverse from 1 to end
        for (int i = 1; i < stocks.length; i++) {
            int currentPrice = stocks[i];

            // 🔹 Step 1: Pop all indices where stock price is less than current price
            while (!stack.isEmpty() && currentPrice > stocks[stack.peek()]) {
                stack.pop();
            }

            // 🔹 Step 2: Calculate span based on stack status
            if (stack.isEmpty()) {
                // If stack is empty → all previous prices are smaller
                spans[i] = i + 1;
            } else {
                // Otherwise → current span = distance from last higher price
                int prevHighIndex = stack.peek();
                spans[i] = i - prevHighIndex;
            }

            // 🔹 Step 3: Push current index into stack
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        // Input stock prices
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int spans[] = new int[stocks.length];

        // Calculate spans
        findStocksSpan(stocks, spans);

        // Print spans
        System.out.println("Stock Spans:");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}

/*
📌 Dry Run:
Stocks: [100, 80, 60, 70, 60, 85, 100]

Step 1: 100 → No previous → span = 1
Step 2: 80  < 100 → span = 1
Step 3: 60  < 80  → span = 1
Step 4: 70  > 60  → pop(60) → span = 2
Step 5: 60  < 70  → span = 1
Step 6: 85  > 60,70,80 → pop all → span = 4
Step 7: 100 > all previous → span = 7

✅ Output → [1, 1, 1, 2, 1, 4, 7]

---

📊 Time Complexity:
O(n) — Each element is pushed and popped at most once.

📊 Space Complexity:
O(n) — Stack stores indices.

✅ Concept Used:
Stack + Previous Greater Element logic
*/
