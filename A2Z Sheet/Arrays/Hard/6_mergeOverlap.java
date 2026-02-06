class Solution {
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {
        int n = intervals.size();
        boolean[] used = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(used[i]) continue;

            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);

            for(int j=i+1; j<n; j++){
                if(used[j]) continue;

                int s = intervals.get(j).get(0);
                int e = intervals.get(j).get(1);

                if(start <= e && end >= s){
                    start = Math.min(start, s);
                    end = Math.max(end, e);
                    used[j] = true;
                }
            }

            ans.add(Arrays.asList(start, end));
        }

        return ans;
    }

    
}