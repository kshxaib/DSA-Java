import java.util.*;

public class Knapsack {
    public static int knapsack(int val[], int wt[], int i, int W){  //Time: O(n)
        if(W == 0 || i == 0){
            return 0;
        }

        if(wt[i-1] <= W){
            int ans1 = val[i-1] + knapsack(val, wt, i-1, W-wt[i-1]);
            int ans2 = knapsack(val, wt, i-1, W);
            return Math.max(ans1, ans2);
        } else{
            return knapsack(val, wt, i-1, W);
        }
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        System.out.println(knapsack(val, wt, val.length, W));
    }    
}
