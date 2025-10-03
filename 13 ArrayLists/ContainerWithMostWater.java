// Problem: Container With Most Water
/*
📌 Problem Statement:
Given an array `height[]` where each element represents the height of a vertical line,
find the maximum amount of water a container can store between two lines.

👉 Idea (Brute Force):
- Consider every pair of lines (i, j).
- Water contained = min(height[i], height[j]) * (j - i)
- Take the maximum among all pairs.

⚠️ This is a brute-force O(N^2) approach.
Optimized solution exists using two pointers (O(N)).
*/

import java.util.*;

public class ContainerWithMostWater {

    // Function to calculate max water (Brute Force)
    public static int findCWM(ArrayList<Integer> height){
        int highestContainedWater = Integer.MIN_VALUE; // store max water found

        // 🔹 Outer loop → choose left boundary (i)
        for(int i=0; i<height.size(); i++){
            int boundary1 = height.get(i);

            // 🔹 Inner loop → choose right boundary (j)
            for(int j=i+1; j<height.size(); j++){
                int boundary2 = height.get(j);

                // 🔹 Water stored = lowest boundary × width
                int lowestBoundary = Math.min(boundary1, boundary2);
                int width = j - i; 
                int water = lowestBoundary * width;

                // 🔹 Update maximum water
                if(highestContainedWater < water){
                    highestContainedWater = water;
                }
            }
        }

        return highestContainedWater;
    }

    // Function to calculate max water (Optimized Two-Pointer Approach)
    public static int findCWMOptimized(ArrayList<Integer> height){
        int highestContainedWater = Integer.MIN_VALUE;

        // 🔹 Start with two pointers at both ends of the array
        int leftPointer = 0;
        int rightPointer = height.size() -1;

        // 🔹 Move pointers inward until they meet
        while (leftPointer < rightPointer) {
            // Calculate area with current boundaries
            int lowestHeight = Math.min(height.get(leftPointer), height.get(rightPointer));
            int width = rightPointer - leftPointer;
            int water = lowestHeight * width;

            // Update max water
            highestContainedWater = Math.max(highestContainedWater, water);

            /*
             👉 Logic for moving pointers:
             - The container’s capacity is limited by the *smaller line*.
             - To maximize water, we need a taller line.
             - So, move the pointer pointing to the smaller height.
            */
            if(height.get(leftPointer) < height.get(rightPointer)){
                leftPointer++;   // move left pointer inward
            }else{
                rightPointer--;  // move right pointer inward
            }
        }

        return highestContainedWater;
    }

    public static void main(String[] args) {
        // Input: heights of vertical lines
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // Expected output: 49
        System.out.println(findCWM(height));         // Brute force
        System.out.println(findCWMOptimized(height)); // Optimized
    }
}

/*
📌 Dry Run Example:
Input: [1,8,6,2,5,4,8,3,7]

Two-pointer approach:
- Start: left=0, right=8 → min(1,7)*8=8
- Move left (since 1 < 7)
- left=1, right=8 → min(8,7)*7=49 ✅ max
- Keep checking until pointers meet.

✅ Output = 49

---
📊 Time Complexity:
- Brute Force → O(N^2)
- Two Pointers → O(N)

📊 Space Complexity:
- O(1) → only variables
*/
