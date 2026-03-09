class Solution {
    public int NthRoot(int N, int M) {
       int start = 1;
       int end = M;

       while(start <= end){
         int mid = start + (end - start)/2;
         long sq = findSq(mid, N);

        if(sq == M) return mid;

         if(sq < M){
            start = mid +1;
         } else {
            end = mid -1;
         }
       } 

       return -1;
    }

    private long findSq(int n, int N){
        long ans = 1;
        for(int i=0; i<N; i++){
            ans = ans * n;
        }
        return ans;
    }
}

// Time: O(N logM)
// Space: O(1)
// Time: O(N logM)
