// Problem: Maximum Length Chain of Pairs (Greedy Algorithm)

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
Time Complexity: O(n log n)
- Sorting dominates (based on end values)
Space Complexity: O(1)
- Only a few variables used
*/
