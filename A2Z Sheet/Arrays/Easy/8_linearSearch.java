class Solution {
    public int linearSearch(int nums[], int target) {
      int idx = -1;

      for(int i=0; i<nums.length; i++){
        if(nums[i] == target){
          idx = i;
          break;
        }
      }

      return idx;
    }
}

// Time: O(n)
// Space: O(1)