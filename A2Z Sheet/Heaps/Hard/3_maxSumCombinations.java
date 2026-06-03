// Time Complexity: O(n * m + nmlog(nm)) ,We compute all n * m pairwise sums. Sorting takes O(nm log nm). Extracting top k is O(k).

// Space Complexity:O(n * m) , We store all pairwise sums explicitly before sorting 
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

    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        PriorityQueue<int[]> maxheap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        HashSet<String> visited = new HashSet<>();

        maxheap.add(new int[] {nums1[n -1] + nums2[n -1], n-1, n-1});
        visited.add((n - 1) + "#" + (n - 1));

        int ans[] = new int[k];
        int index = 0;

        while(index < k){
            int maxSum[] = maxheap.remove();
            int sum = maxSum[0];
            int i = maxSum[1];
            int j = maxSum[2];

            ans[index] = sum;
            index++;

            if(i -1 >= 0){
                String key = (i -1) + "#" + j;
                if(!visited.contains(key)){
                    maxheap.add(new int[] {nums1[i -1] + nums2[j], i-1, j});
                    visited.add(key);
                }
            }

            if(j -1 >= 0){
                String key = i + "#" + (j -1);
                if(!visited.contains(key)){
                    maxheap.add(new int[] {nums1[i] + nums2[j -1], i, j -1});
                    visited.add(key);
                }
            }
        }

        return ans;
    }
}