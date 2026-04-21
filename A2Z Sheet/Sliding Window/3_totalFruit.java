class Solution {
    // Time: O(n^2) Space: O(1)
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        for(int i=0; i<fruits.length; i++){

            Set<Integer> set = new HashSet<>();        
            for(int j=i; j<fruits.length; j++){
                set.add(fruits[j]);
                if(set.size() == 3) break;

                int len = j -i +1;
                maxFruits = Math.max(maxFruits, len);
            }
        }

        return maxFruits;
    }

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        while(right < n){
            int curr = fruits[right];
            map.put(curr, map.getOrDefault(curr, 0) +1);

                while(map.size() > 2){
                    map.put(fruits[left], map.get(fruits[left]) -1);

                    if(map.get(fruits[left]) == 0){
                        map.remove(fruits[left]);
                    }

                    left++;
                }

            int len = right - left +1;
            maxLen = Math.max(maxLen, len);

            right++;
        }

        return maxLen;
    }
}