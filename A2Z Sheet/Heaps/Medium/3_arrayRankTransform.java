class Solution {
    public int[] arrayRankTransform(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            int curr = arr[i];
            Set<Integer> set = new HashSet<>();

            for(int j=0; j<arr.length; j++){
                if(arr[j] < curr){
                    set.add(arr[j]);
                }
            }

            int rank = set.size() +1;
            list.add(rank);
        }

        int rank[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            rank[i] = list.get(i);
        }

        return rank;
    }


    public int[] arrayRankTransform(int[] arr) {
        int sortedArr [] = arr.clone();
        Arrays.sort(sortedArr);

        int rank = 1;
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        for(int i=0; i<sortedArr.length; i++){
            int curr = sortedArr[i];
            if(!rankMap.containsKey(curr)){
                rankMap.put(curr, rank);
                rank++;
            }
        }

        int[] result = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}