// Problem: Pair Sum in a Sorted Array
/*
📌 Problem Statement:
Given a sorted array `list[]`, check if there exists a pair of elements 
whose sum equals the target value.

👉 Approaches:
1. Brute Force (O(N^2)):
   - Check all pairs (i, j) and see if their sum == target.
2. Optimized Two-Pointer (O(N)):
   - Use two pointers (left & right).
   - If sum < target → move left (increase sum).
   - If sum > target → move right (decrease sum).
   - If sum == target → return true.
*/

import java.util.*;

public class PairSum1 {

    // Brute Force Approach: O(N^2)
    public static boolean findPairSum(ArrayList<Integer> list, int target){
        // 🔹 Try every possible pair (i, j)
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                int sum = list.get(i) + list.get(j);

                // ✅ If sum matches target → return true
                if(target == sum){
                    return true;
                }
            }
        }
        return false; // No such pair found
    }

    // Optimized Approach: Two Pointers O(N)
    public static boolean findPairSumOptimize(ArrayList<Integer> list, int target){
        int leftPointer = 0;                  // Start pointer
        int rightPointer = list.size() - 1;   // End pointer

        // 🔹 Move pointers inward until they cross
        while (leftPointer < rightPointer) {
            int sum = list.get(leftPointer) + list.get(rightPointer);

            if(target == sum){
                return true; // ✅ Found the pair
            } 
            // If sum is smaller, move left pointer to increase sum
            else if(target > sum){
                leftPointer++;
            } 
            // If sum is greater, move right pointer to decrease sum
            else{
                rightPointer--;
            }
        }

        return false; // No such pair found
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 5;

        // ✅ Brute Force Output
        System.out.println(findPairSum(list, target)); 

        // ✅ Optimized Output
        System.out.println(findPairSumOptimize(list, target));
    }
}

/*
📌 Dry Run Example:
list = [1,2,3,4,5,6], target = 5

Brute Force:
- Check (1,2)=3, (1,3)=4, (1,4)=5 ✅ Found

Optimized Two-Pointer:
- left=0(1), right=5(6), sum=7 → decrease right
- left=0(1), right=4(5), sum=6 → decrease right
- left=0(1), right=3(4), sum=5 ✅ Found

✅ Output:
true
true

---
📊 Time Complexity:
- Brute Force → O(N^2)
- Optimized → O(N)

📊 Space Complexity:
- O(1) → only pointers/variables
*/
