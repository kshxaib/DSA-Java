class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            freq.put(num, freq.getOrDefault(num, 0) +1);
        }

        int result[] = new int[k];
        for(int i=0; i<k; i++){
            int maxFreq = -1;
            int element = -1;

            for(int key : freq.keySet()){
                if(freq.get(key) > maxFreq){
                    maxFreq = freq.get(key);
                    element = key;
                }
            }

            result[i] = element;
            freq.put(element, -1);
        }

        return result;
    }
}