/*
                    TWO SUM
Problem:
Given an array of integers nums and a target value,
return the indices of two numbers such that they add
up to the target.

Assumption:
Exactly one valid pair exists.

Example:
nums = [2,7,11,15], target = 9

2 + 7 = 9

Output → [0,1]

Core Idea (HashMap / Complement Method):

Instead of checking every pair (O(n²)),
we store previously seen numbers in a HashMap.

For each element:
remaining = target - nums[i]

If remaining already exists in the map,
we found the pair.

Map stores:
value → index

Algorithm Steps:
1. Traverse the array.
2. For each number compute remaining = target - nums[i].
3. Check if remaining exists in map.
4. If yes → return indices.
5. Otherwise store nums[i] in the map.

Example Walkthrough:

nums = [2,7,11,15], target = 9

i=0 → num=2 → remaining=7
store {2:0}

i=1 → num=7 → remaining=2
2 exists → answer = [0,1]

Complexities:
Time Complexity  : O(n)
Space Complexity : O(n)

Properties:
- Uses HashMap for constant lookup
- Avoids nested loops
- Works with unsorted arrays

Key Interview Points:
- Complement technique
- HashMap lookup is O(1) average
- Much better than brute force O(n²)
*/
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int remaining = target - nums[i];

            if(map.containsKey(remaining)){
                return new int[]{map.get(remaining), i};
            }    
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}

// Time Complexity: O(N) because we traverse the array only once, and each lookup or insertion in the hash map takes O(1) on average, where N is the size of the array.

// Space Complexity: O(N) since in the worst case we may store all elements of the array in the hash map.

