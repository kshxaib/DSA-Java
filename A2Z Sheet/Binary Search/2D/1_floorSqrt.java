class Solution {
    public int floorSqrt(int n) {
      int ans = 1;
      int start = 1;
      int end = n;

      while(start <= end){
        int mid = start + (end - start)/2;
        if(mid*mid <= n){
            ans = mid;
            start = mid +1;
        } else {
            end = mid -1;
        }
      }

      return ans;
    }
}

// Time: O(logn)
// Space: O(1)