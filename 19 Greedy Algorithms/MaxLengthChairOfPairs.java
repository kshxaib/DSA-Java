// Problem: Maximum Length Chain of Pairs (Greedy Algorithm)

/*
This program solves the "Maximum Length Chain of Pairs" problem using a Greedy Algorithm.

Goal:
Find the longest chain of pairs (a, b) that can be formed such that 
for every pair (a, b) followed by (c, d), we have b < c.

Concept:
1. Each pair represents a start and end value.
2. A valid chain means the next pair’s start value must be greater than or equal to
   the previous pair’s end value.
3. Greedy Strategy: Always select the pair that finishes earliest 
   (smallest end value) — this leaves more room for upcoming pairs.

Steps:
1. Sort all pairs based on their second element (end value).
2. Select the first pair and initialize chain length as 1.
3. For each subsequent pair:
   - If its start value ≥ end value of the previously selected pair,
     include it in the chain and update the end value.

Example:
Input:
pairs = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}}

Output:
Max length of chain = 3

Explanation:
One possible chain: (5,24) → (27,40) → (50,90)

Key Idea:
Use a Greedy strategy — always choose the pair that ends earliest.
*/

import java.util.*;

public class MaxLengthChairOfPairs {

    // Function to find the maximum chain length
    public static int findMaxLength(int pairs[][]){
        // Step 1: Sort pairs based on the second element (end value)
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int length = 1;                   // At least one pair can be included
        int prevSelected = pairs[0][1];   // End value of the first selected pair

        // Step 2: Iterate over remaining pairs
        for(int i = 1; i < pairs.length; i++){
            // If the current pair’s start value >= end value of the last selected pair
            if(pairs[i][0] >= prevSelected){
                length++;                        // Include this pair
                prevSelected = pairs[i][1];       // Update last selected end value
            }
        }

        // Step 3: Return the total chain length
        return length;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int pairs[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}}; 
        System.out.println("Max length of chain = " + findMaxLength(pairs));
    }
}

/*
Dry Run:
Input Pairs: {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}}

Step 1: Sort by end value → 
{{5,24}, {5,28}, {27,40}, {39,60}, {50,90}}

Step 2: Pick pairs greedily:
- Select (5,24)
- (5,28) rejected → start < 24
- (27,40) selected → start = 27 ≥ 24
- (39,60) rejected → start < 40
- (50,90) selected → start = 50 ≥ 40

Result: (5,24) → (27,40) → (50,90)
Max chain length = 3

Time Complexity: O(n log n)
- Sorting dominates (based on end values)
Space Complexity: O(1)
- Only a few variables used

Concept Used:
- Greedy Algorithm
- Sorting by the second element (end time)
- Activity Selection pattern (similar logic)
*/
