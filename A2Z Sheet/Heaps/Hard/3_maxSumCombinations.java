class Solution {
    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {
        ArrayList<Integer> pairSum = new ArrayList<>();

        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                pairSum.add(nums1[i] + nums2[j]);
            }
        }

        Collections.sort(pairSum, Collections.reverseOrder());
        
        int result[] = new int[k];
        for(int i = 0; i<k; i++){
            result[i] = pairSum.get(i);
        }

        return result;
    }
}