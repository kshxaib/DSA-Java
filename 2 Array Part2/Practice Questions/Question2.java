// Problem: Search in Rotated Sorted Array
// Given a rotated sorted array and a target value,
// return the index of target if present, otherwise -1.

public class Question2 {

    public static int findIndexOfElement(int nums[], int target) {
        int start = 0, end = nums.length - 1;

        // Binary Search (modified for rotated array)
        while (start <= end) {
            int mid = (start + end) / 2;

            // Case 1: Target found at mid
            if (nums[mid] == target) {
                return mid;
            }

            // Case 2: Left half is sorted
            if (nums[start] <= nums[mid]) {
                // Check if target lies within left sorted half
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1; // search left
                } else {
                    start = mid + 1; // search right
                }
            }
            // Case 3: Right half is sorted
            else {
                // Check if target lies within right sorted half
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1; // search right
                } else {
                    end = mid - 1; // search left
                }
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.print(findIndexOfElement(nums, target)); 
        // Expected Output: 4 (since nums[4] = 0)
    }
}
