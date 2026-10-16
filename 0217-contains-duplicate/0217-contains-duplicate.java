class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        HashSet<Integer> hash = new HashSet<>();

        for(int i=0; i<n; i++){
            if(hash.contains(nums[i])){
                return true;
            } else {
                hash.add(nums[i]);
            }
        }

        return false;
    }
}