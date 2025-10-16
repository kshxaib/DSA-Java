// Problem: Indian Coin Change Problem (Greedy Algorithm)

/*
This program solves the "Indian Coin Change" problem using a Greedy approach.

Goal:
To make a given amount using the minimum number of Indian currency coins/notes.

Concept:
1. We are given different denominations of coins (or currency notes).
2. We need to find the least number of coins that sum up to a given value.
3. Greedy Strategy: Always choose the largest possible denomination 
   that does not exceed the remaining amount.

Steps:
1. Sort all denominations in descending order.
2. Pick the highest denomination coin that fits into the remaining value.
3. Subtract that coin’s value from the remaining amount.
4. Repeat until the remaining value becomes 0.

Example:
Input:
coins = [1, 2, 5, 10, 20, 50, 100, 500, 2000]
value = 590

Output:
[500, 50, 20, 20]

Explanation:
590 = 500 + 50 + 20 + 20 → minimum 4 coins/notes

Key Idea:
Use the Greedy method — always pick the highest denomination first.
*/

import java.util.*;

public class IndianCoins {

    // Function to find minimum coins for the given value
    public static ArrayList<Integer> findCoins(Integer coins[], int value) {
        // Step 1: Sort coins in descending order (largest to smallest)
        Arrays.sort(coins, Comparator.reverseOrder());

        ArrayList<Integer> selectedCoins = new ArrayList<>(); // Stores selected coins
        int remainingValue = value;  // Amount still to be covered

        // Step 2: Pick coins greedily
        for (int i = 0; i < coins.length; i++) {
            // While current coin can fit into remaining value
            while (coins[i] <= remainingValue) {
                remainingValue -= coins[i];   // Subtract coin value
                selectedCoins.add(coins[i]);  // Store selected coin
            }
        }

        // Step 3: Return list of selected coins
        return selectedCoins;
    }

    // Main method to test the program
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        System.out.println("Coins used: " + findCoins(coins, 590));
    }
}

/*
Dry Run:
Input:
coins = [1, 2, 5, 10, 20, 50, 100, 500, 2000]
value = 590

Step 1: Sort descending → [2000, 500, 100, 50, 20, 10, 5, 2, 1]
Step 2: Pick coins:
- 2000 > 590 → skip
- 500 ≤ 590 → select 500 → remaining = 90
- 100 > 90 → skip
- 50 ≤ 90 → select 50 → remaining = 40
- 20 ≤ 40 → select 20 → remaining = 20
- 20 ≤ 20 → select 20 → remaining = 0

Output: [500, 50, 20, 20]

Time Complexity: O(n log n)
- Sorting takes O(n log n)
- Selection loop takes O(n * (value/coin))

Space Complexity: O(n)
- To store selected coins

Concept Used:
- Greedy Algorithm
- Sorting in descending order
- Repeated subtraction for minimal selection
*/
