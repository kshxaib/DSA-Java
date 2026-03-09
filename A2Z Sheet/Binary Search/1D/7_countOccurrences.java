/*
        COUNT OCCURRENCES IN SORTED ARRAY
      (BINARY SEARCH / LOWER + UPPER BOUND)

Problem:
Given a sorted array arr and a target value,
count how many times the target appears.

Example 1:
arr = [0,0,1,1,1,2,3]
target = 1

Output: 3

Explanation:
1 appears at indices 2,3,4.


Example 2:
arr = [5,5,5,5,5,5]
target = 5

Output: 6

Explanation:
All elements are 5.


Core Idea:
In a sorted array, duplicate elements appear
contiguously.

So the count can be calculated using:
count = lastIndex - firstIndex + 1

Instead of scanning linearly,
we use Binary Search to find:

1. First occurrence (Lower Bound)
2. Last occurrence (Upper Bound - 1)


Definitions:
Lower Bound: first index where arr[i] ≥ target
Upper Bound: first index where arr[i] > target

Therefore:
firstIndex = lowerBound(target)
lastIndex  = upperBound(target) - 1

Count Formula:
count = upperBound(target) - lowerBound(target)

Algorithm Steps:

1. Find first occurrence using lower bound.

2. If target does not exist:

        return 0

3. Find upper bound.

4. Count occurrences:

        count = upperBound - lowerBound


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Works only on sorted arrays
- Uses binary search twice
- Efficient for large arrays

Key Interview Points:
Lower Bound  → arr[i] ≥ target
Upper Bound  → arr[i] > target

Count formula:
occurrences = upperBound - lowerBound
*/

class Solution {
    public int countOccurrences(int[] arr, int target) {
        int n = arr.length;

        int start = starting(arr, target);
        if(start == n || arr[start] != target){
            return 0;
        }

        int end = ending(arr, target);

        int count = end - start;
        return count;
    }

    private int starting(int arr[], int target){
        int start = 0;
        int end = arr.length -1;
        int ans = arr.length;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] >= target){
                ans = mid;
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return ans;
    }

    private int ending(int arr[], int target){
        int start = 0;
        int end = arr.length -1;
        int ans = arr.length;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] > target){
                ans = mid;
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return ans;
    }
}

// Time: O(log n)
// Space: O(1)