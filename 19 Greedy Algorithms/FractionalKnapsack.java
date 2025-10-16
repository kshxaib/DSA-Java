// Problem: Fractional Knapsack Problem
/*
This program solves the classic "Fractional Knapsack" problem using a greedy algorithm.

Goal:
Maximize the total value in a knapsack that has a weight limit (capacity), 
where you can take fractions of items if necessary.

Concept:
1. Each item has a value and a weight.
2. Compute value/weight ratio for each item.
3. Sort items in decreasing order of this ratio.
4. Pick items with the highest ratio first:
   - Take the whole item if it fits.
   - Otherwise, take the fractional part that fits in remaining capacity.

Example:
Input:
value  = [60, 100, 120]
weight = [10, 20, 30]
W = 50

Output:
Max value in knapsack = 240

Key Idea:
Use a greedy strategy — always choose the item with the highest value/weight ratio first.
*/

import java.util.*;

public class FractionalKnapsack {

    // Function to find maximum total value for given weight capacity
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

    // Main method to test the program
    public static void main(String args[]) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;

        System.out.println("Max value in knapsack = " + findMaxValue(value, weight, w));
    }
}

/*
Dry Run:
Items:
Index:   0   1   2
Value:  60 100 120
Weight: 10  20  30
Ratio:   6   5   4

Step 1: Sort by ratio (ascending):
[[2,4.0], [1,5.0], [0,6.0]]

Step 2: Start picking (from highest ratio):
- Take full item 0 → remaining capacity = 40 → total = 60
- Take full item 1 → remaining capacity = 20 → total = 160
- Take 2/3 of item 2 → remaining capacity = 0 → total = 240

Output:
Max value in knapsack = 240

Time Complexity:
- Sorting: O(n log n)
- Selection: O(n)
Total = O(n log n)

Space Complexity: O(n)
- For storing ratios

Concept Used:
- Greedy Algorithm
- Sorting by value-to-weight ratio
- Fractional item inclusion for optimal result
*/
