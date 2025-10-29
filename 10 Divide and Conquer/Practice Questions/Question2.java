/*
-------------------------------------------------------------
Program: Find Majority Element (3 Approaches)
-------------------------------------------------------------

📌 Problem Statement:
Given an integer array `nums`, find the element that appears 
more than ⌊ n/2 ⌋ times (the majority element).

Example:
   Input:  nums = [2,2,1,1,1,2,2]
   Output: 2

-------------------------------------------------------------
APPROACH 1: Brute Force
-------------------------------------------------------------
- For every element, count its occurrences using a nested loop.
- If its count > n/2 → it's the majority element.
- Otherwise, continue checking.

Time Complexity:  O(n²)
   (two nested loops: each element compared with all others)
Space Complexity: O(1)
   (no extra data structures used)
-------------------------------------------------------------
*/

public class Question2 {

    // Brute Force Approach
    public static int findMajority(int nums[]){
        int majority = -1;

        for(int i = 0; i < nums.length; i++){
            int count = 0;

            // Count occurrences of nums[i]
            for(int j = 0; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }

            // If frequency > n/2 → majority element found
            if(count > nums.length / 2){
                majority = nums[i];
                break;
            }
        }

        return majority;
    }


    /*
    -------------------------------------------------------------
    APPROACH 2: Better Approach (Using Frequency Array)
    -------------------------------------------------------------
    - First, find the maximum number in the array → maxNo.
    - Create a frequency array of size (maxNo + 1).
    - Increment frequency of each number.
    - Check which number has frequency > n/2 → majority.

    Time Complexity:
        Step 1 → O(n)   → to find max element
        Step 2 → O(n)   → to fill frequency array
        Step 3 → O(m)   → to check majority (m = max element value)
        => Total: O(n + m)

    Space Complexity: O(m)
        (extra frequency array of size = max element value + 1)
    -------------------------------------------------------------
    */
    public static int findMajorityBetter(int nums[]){
        int maxNo = Integer.MIN_VALUE;

        // Step 1: Find maximum number
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > maxNo){
                maxNo = nums[i];
            }
        }

        // Step 2: Create and fill frequency array
        int freq[] = new int[maxNo + 1];
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }

        // Step 3: Check which number has freq > n/2
        int majority = -1;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > nums.length / 2){
                majority = i;
                break;
            }
        }

        return majority;
    }


    /*
    -------------------------------------------------------------
    APPROACH 3: Optimized Approach (Boyer–Moore Voting Algorithm)
    -------------------------------------------------------------
    - Maintains a potential candidate and a count.
    - If count == 0, pick new element as candidate.
    - If next element == candidate → count++
      else → count--.
    - At the end, the remaining candidate is the majority element.

    Time Complexity:  O(n)
        (single traversal of array)

    Space Complexity: O(1)
        (only two variables used: element, count)

    ⚠ Note:
    This assumes that a majority element always exists.
    -------------------------------------------------------------
    */
    public static int findMajorityOptimized(int nums[]){
        int element = -1;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                element = nums[i];
                count = 1;
            } 
            else if(nums[i] == element){
                count++;
            } 
            else {
                count--;
            }
        }

        return element;
    }


    // Driver Code
    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Brute Force: " + findMajority(nums));          // O(n²)
        System.out.println("Better: " + findMajorityBetter(nums));         // O(n + m)
        System.out.println("Optimized: " + findMajorityOptimized(nums));   // O(n)
    }
}
