import java.util.*;

public class StockSpan {

    public static void findStocksSpan(int stocks[], int spans[]) {
        Stack<Integer> stack = new Stack<>();  // Stack to store indices
        spans[0] = 1;                          // Span of first element is always 1
        stack.push(0);                         // Push index 0

        // Traverse from 1 to end
        for (int i = 1; i < stocks.length; i++) {
            int currentPrice = stocks[i];

            // Step 1: Pop all indices where stock price is less than current price
            while (!stack.isEmpty() && currentPrice >= stocks[stack.peek()]) {
                stack.pop();
            }

            // Step 2: Calculate span based on stack status
            if (stack.isEmpty()) {
                // If stack is empty → all previous prices are smaller
                spans[i] = i + 1;
            } else {
                // Otherwise → current span = distance from last higher price
                int prevHighIndex = stack.peek();
                spans[i] = i - prevHighIndex;
            }

            // Step 3: Push current index into stack
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int spans[] = new int[stocks.length];

        findStocksSpan(stocks, spans);

        System.out.println("Stock Spans:");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}

/*
📊 Time Complexity:
O(n) — Each element is pushed and popped at most once.

📊 Space Complexity:
O(n) — Stack stores indices.
*/
