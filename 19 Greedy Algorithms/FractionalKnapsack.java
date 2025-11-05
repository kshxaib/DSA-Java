// Problem: Fractional Knapsack Problem

import java.util.*;

public class FractionalKnapsack {

    public static int findMaxValue(int value[], int weight[], int w) {
        // Step 1: Store each item's index and value/weight ratio
        double ratio[][] = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;                       // Store index
            ratio[i][1] = value[i] / (double) weight[i]; // Compute ratio
        }

        // Step 2: Sort items based on ratio in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        double totalValue = 0;  // Total value (can include fractional part)
        int bagCapacity = w;    // Remaining capacity of knapsack

        // Step 3: Pick items starting from highest ratio
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];

            if (bagCapacity >= weight[idx]) {
                // If the full item fits, take it entirely
                totalValue += value[idx];
                bagCapacity -= weight[idx];
            } else {
                // Otherwise, take the fractional part that fits
                totalValue += ratio[i][1] * bagCapacity;
                bagCapacity = 0;
                break; // Knapsack is full
            }
        }

        // Step 4: Return total value as integer
        return (int) totalValue;
    }

    public static void main(String args[]) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;

        System.out.println("Max value in knapsack = " + findMaxValue(value, weight, w));
    }
}

/*
Time Complexity:
- Sorting: O(n log n)
- Selection: O(n)
Total = O(n log n)

Space Complexity: O(n)
- For storing ratios
*/
