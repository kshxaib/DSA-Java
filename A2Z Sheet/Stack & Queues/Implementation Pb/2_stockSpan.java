// BRUTE FORCE
import java.util.*;

class StockSpannerBrute {
    List<Integer> prices;

    public StockSpannerBrute() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        // Store all stock prices.
        prices.add(price);

        int span = 1;

        // Count consecutive smaller/equal prices.
        for (int i = prices.size() - 2; i >= 0; i--) {

            if (prices.get(i) <= price) {
                span++;
            } else {
                break; // Stop at first greater price.
            }
        }

        return span;
    }
}

// OPTIMAL APPROACH
class StockSpanner {

    Stack<Integer> stack; // Stores indices.
    List<Integer> prices; // Stores prices.

    public StockSpanner() {
        stack = new Stack<>();
        prices = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);  // Store today's price.

        int currIdx = prices.size() - 1;

        // Remove all smaller/equal prices.
        while (!stack.isEmpty() && prices.get(stack.peek()) <= price) {
            stack.pop();
        }

        
        int pge = stack.isEmpty() ? -1 : stack.peek();  // Previous Greater Element index.
        stack.push(currIdx);    // Current index may become PGE for future prices.

        return currIdx - pge;   // Span = Distance from Previous Greater Element.
    }
}