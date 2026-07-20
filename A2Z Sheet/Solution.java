import java.util.*;

/**
 * Main
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }

        for (int i = 1; i <= max; i++) {
            int hours = calculateTotalHours(piles, i);

            if (hours <= h) {
                return i;
            }
        }

        return max;
    }

    private int calculateTotalHours(int piles[], int h) {
        int totalHr = 0;

        for (int i = 0; i < piles.length; i++) {
            totalHr += Math.ceil((double) piles[i] / h);
        }

        return totalHr;
    }
}