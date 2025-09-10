//Given an integer array nums, return true if any value appears at least twice in the
//array, and return false if every element is distinct.

import java.util.*;

public class Question1 {

    // Brute Force Approach
    // Time Complexity: O(n^2) -> because of nested loops
    // Space Complexity: O(1)  -> only a few variables used
    public static boolean checkDuplicates(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true; // duplicate found
                }
            }
        }
        return false; // no duplicates found
    }

    // Optimized Approach using HashSet
    // Use a HashSet (stores only unique values).
    // If we see the same number again -> it's a duplicate.
    // Time Complexity: O(n) -> each lookup/add in HashSet is O(1) on average
    // Space Complexity: O(n) -> HashSet stores up to n elements in worst case
    public static boolean checkDuplicatesOptimized(int numbers[]) {
        // Create a HashSet to store unique numbers
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            // If number already exists in set -> duplicate found
            if (set.contains(numbers[i])) {
                return true;
            } else {
                // Otherwise, add number to set
                set.add(numbers[i]);
            }
        }

        return false; // no duplicates found
    }

    public static void main(String[] args) {
        int numbers[] = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        // System.out.print(checkDuplicates(numbers)); 

        System.out.print(checkDuplicatesOptimized(numbers)); 
    }
}
