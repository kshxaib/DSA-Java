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
}