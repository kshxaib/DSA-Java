// Problem: Indian Coin Change Problem (Greedy Algorithm)

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

    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        System.out.println("Coins used: " + findCoins(coins, 590));
    }
}

/*
Time Complexity: O(n log n)
- Sorting takes O(n log n)
- Selection loop takes O(n * (value/coin))

Space Complexity: O(n)
- To store selected coins
*/
