class Solution {    
    public int[] singleNumber(int[] nums) {        
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
        }

        // first different bit
        int shift = 0;
        while(xor > 0){
            if((xor & 1) == 0){
                shift++;
                xor = xor >> 1;
            } else {
                break;
            }
        }

        int setBucket = 0;
        int unsetBucket = 0;

        for(int i=0; i<nums.length; i++){
            if(((nums[i] >> shift) & 1) == 1){
                setBucket = setBucket ^ nums[i];
            } else {
                unsetBucket = unsetBucket ^ nums[i];
            }
        }

        if(setBucket > unsetBucket){
            return new int[] {unsetBucket, setBucket};
        } else {
            return new int[] {setBucket, unsetBucket};
        }
    }
}