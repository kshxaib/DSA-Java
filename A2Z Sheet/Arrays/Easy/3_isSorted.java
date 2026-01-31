class Solution {
    public boolean isSorted(ArrayList<Integer> nums) {
        for(int i=0; i<nums.size() -1; i++){
            int curr = nums.get(i);
            int next = nums.get(i+1);
            if(curr > next){
                return false;
            }
        }

        return true;
    }
}

// Time: O(n)
// Space: O(1)