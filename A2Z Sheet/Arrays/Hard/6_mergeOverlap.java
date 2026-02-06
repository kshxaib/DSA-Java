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

    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {
        int n = intervals.size();
        List<List<Integer>> ans = new ArrayList<>();

        if (n == 0) return ans;

        intervals.sort(Comparator.comparingInt(a -> a.get(0)));

        List<Integer> newInterval = new ArrayList<>(intervals.get(0));
        ans.add(newInterval);

        for (int i = 1; i < n; i++) {
            List<Integer> curr = intervals.get(i);

            if (curr.get(0) <= newInterval.get(1)) {
                newInterval.set(1, Math.max(newInterval.get(1), curr.get(1)));
            } else {
                newInterval = new ArrayList<>(curr);
                ans.add(newInterval);
            }
        }

        return ans;
    }
}

// Time: O(nlogn)
// Space: O(1)
