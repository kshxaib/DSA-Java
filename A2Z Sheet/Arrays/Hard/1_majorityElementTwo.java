/*
                MAJORITY ELEMENT II
        (EXTENDED BOYER–MOORE VOTING ALGORITHM)

Problem:
Given an integer array nums of size n, return all elements
that appear more than ⌊ n/3 ⌋ times.

Example:
nums = [1,2,1,1,3,2]

n = 6
n/3 = 2

Elements appearing more than 2 times → [1]

Key Observation:
At most TWO elements can appear more than n/3 times.

Core Idea:
Use an extended Boyer–Moore Voting Algorithm.
Maintain two candidates and their counts:

ele1, ele2 → candidate elements
count1, count2 → their frequencies

While traversing the array:

1. If count1 == 0 and current element != ele2
      assign ele1

2. If count2 == 0 and current element != ele1
      assign ele2

3. If nums[i] == ele1
      count1++

4. If nums[i] == ele2
      count2++

5. Otherwise
      count1--
      count2--

This effectively cancels out different elements.


Why cancellation works?
Non-majority elements cancel each other out.
Majority elements survive because their frequency
is greater than all other elements combined.


Phase 2 (Verification):
The first pass only finds possible candidates.
We must verify if they actually appear > n/3 times.
So we count their frequencies again.


Complexities:
Time Complexity  : O(n)
Space Complexity : O(1)

Properties:
- Uses Boyer–Moore voting principle
- Only two candidates are possible
- Requires verification pass

Key Interview Points:
• Maximum elements appearing > n/k times = k−1
• For n/3 → maximum 2 elements
• Algorithm generalizes Boyer–Moore majority voting
*/

class Solution {
    public List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        int count1 = 0;
        int count2 = 0;
        int ele1 = 0;
        int ele2 = 0;

        // Phase 1: Find candidates
        for(int i=0; i<nums.length; i++){
            if(count1 == 0 && nums[i] != ele2){
                ele1 = nums[i];
                count1 = 1;
            } else if(count2 == 0 && nums[i] != ele1){
                ele2 = nums[i];
                count2 = 1;
            } else if(nums[i] == ele1){
                count1++;
            } else if(nums[i] == ele2){
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Phase 2: Verify candidates
        count1 = 0;
        count2 = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == ele1){
                count1++;
            } else if(nums[i] == ele2){
                count2++;
            }
        }

        int mini = nums.length / 3 + 1;

        if(count1 >= mini){
            ans.add(ele1);
        }

        if(count2 >= mini){
            ans.add(ele2);
        }

        return ans;
    }
}

// Time: O(n)
// Space: O(1)