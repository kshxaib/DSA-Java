// Problem: Pair Sum in a Sorted & Rotated Array
/*
📌 Problem Statement:
Given a sorted and rotated array, check if there exists a pair of elements 
whose sum equals the target value.

👉 Idea:
- In a sorted & rotated array, the smallest element comes after a "breaking point" (rotation point).
- Find that breaking point.
- Use a modified two-pointer approach:
   - Left pointer = element after breaking point (smallest element).
   - Right pointer = breaking point element (largest element).
   - Move pointers circularly (using modulo).

✅ Works in O(N) time.
*/

import java.util.*;

public class PairSum2 {

    // Function to check if pair with given sum exists
    public static boolean findPairSum(ArrayList<Integer> list, int target){
        int n = list.size(); 
        int breakingPoint = -1; // 🔹 where the array is rotated

        // Step 1: Find the breaking point (rotation index)
        for(int i=0; i<n-1; i++){ // upto n-1 to avoid IndexOutOfBounds
            if(list.get(i) > list.get(i+1)){
                breakingPoint = i;
                break;
            }
        }

        // Step 2: Initialize two pointers
        int leftPointer = breakingPoint+1; // 🔹 smallest element
        int rightPointer = breakingPoint;  // 🔹 largest element

        // Step 3: Traverse in circular manner until pointers meet
        while (leftPointer != rightPointer) {
            int sum = list.get(leftPointer) + list.get(rightPointer);

            // ✅ Found the pair
            if(target == sum){
                return true;
            } 
            // If sum is smaller → move left pointer forward (circularly)
            else if(target > sum){
                leftPointer = (leftPointer + 1) % n;
            } 
            // If sum is larger → move right pointer backward (circularly)
            else{
                rightPointer = (n + rightPointer - 1) % n;
            }
        }

        return false; // No such pair found
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;

        // ✅ Expected Output: true (because 6 + 10 = 16)
        System.out.println(findPairSum(list, target));
    }
}

/*
📌 Dry Run Example:
list = [11,15,6,8,9,10], target = 16

- Breaking Point = index 1 (15 > 6)
- leftPointer = 2 (element 6, smallest)
- rightPointer = 1 (element 15, largest)

Check sums:
6+15=21 > 16 → move right backward
6+11=17 > 16 → move right backward
6+10=16 ✅ Found → return true

✅ Output: true

---
📊 Time Complexity:
- O(N) → scanning + two-pointer traversal
📊 Space Complexity:
- O(1) → constant extra space
*/
