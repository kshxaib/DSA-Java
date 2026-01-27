class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];

            if(hm.containsKey(num)){
                int freq = hm.get(num);
                hm.put(num, freq +1);
            } else {
                hm.put(num, 1);
            }
        }

        int majorityElement = 0;
        for(Integer key: hm.keySet()){
            if(hm.get(key) > nums.length / 2){
                majorityElement = key;
            }
        }

        return majorityElement;
    }
}

// Time: O(n)
// Space: O(n)