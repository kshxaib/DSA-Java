import java.util.*;

public class StockSpan {
    public static void findStocksSpan(int stocks[], int spans[]){
        Stack<Integer> stack = new Stack<>();
        spans[0] = 1;
        stack.push(0);

        for(int i=1; i<stocks.length; i++){
            int currentPrice = stocks[i];

            while(!stack.isEmpty() && currentPrice > stocks[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                spans[i] = i+1;
            }else{
                int prevHighIndex = stack.peek();
                spans[i] = i - prevHighIndex;
            }

            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};  
        int spans[] = new int[stocks.length];
        findStocksSpan(stocks, spans);
        
        for(int i=0; i<spans.length; i++){
            System.out.println(spans[i] + " ");
        }
    }
}
