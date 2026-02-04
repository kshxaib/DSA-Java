class Solution {
    public int maxLen(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int maxLen = 0;

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];

            if(sum == 0){
                maxLen = i+1;
            } else if (map.containsKey(sum)){
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
            } else if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
