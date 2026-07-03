/*
        FRACTIONAL KNAPSACK

Definition:
Given:

val[i] = value of item
wt[i]  = weight of item

Knapsack capacity = cap

You can take:

• Full item
• Fraction of item

Goal:
Maximize total value inside the bag.


Example 1

Input:

val = [60,100,120]
wt  = [10,20,30]

cap = 50


Greedy Idea
Always take item having
maximum value per unit weight.

(value / weight)

Why?
Every unit of capacity should generate
maximum possible profit.


Algorithm

1. Compute ratio:

   value / weight

2. Sort items by ratio.

3. Pick highest ratio items first.

4. If item fits:
      take full item

5. Otherwise:
      take required fraction

6. Return total value.


Why This Works
Fractional Knapsack has
Greedy Property.

Best local choice
(highest ratio)

always contributes to
best global answer.


Time Complexity: O(n log n)
Compute Ratios: O(n)
Sorting: O(n log n)
Traversal: O(n)

Space Complexity: O(n)
Ratio array
*/
import java.util.*;

class Solution {

    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;

        // ratio[i][0] = index
        // ratio[i][1] = value/weight ratio
        double ratio[][] = new double[n][2];

        for(int i = 0; i < n; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) wt[i]; // value per unit weight
        }

        // sort by ratio ascending
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        double totalValue = 0;
        int bagCapacity = (int) cap;

        // traverse from largest ratio
        for(int i = n - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];

            // take whole item
            if(wt[idx] <= bagCapacity) {
                totalValue += val[idx];
                bagCapacity -= wt[idx];
            }

            // take fraction of item
            else {
                totalValue += ratio[i][1] * bagCapacity;
                bagCapacity = 0;
                break;
            }
        }

        return totalValue;
    }
}