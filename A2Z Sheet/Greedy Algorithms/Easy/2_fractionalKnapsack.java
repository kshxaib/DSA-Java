class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;

        double ratio[][] = new double[n][2];
        for(int i=0; i<n; i++){
            ratio[i][0] = i; // index
            ratio[i][1] = val[i] / (double) wt[i]; // compute ration per unit of wt
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); //sorting based on ratio

        double totalValue = 0;
        int bagCapacity =(int) cap;

        for(int i=n-1; i>=0; i--){
            int idx = (int) ratio[i][0];

            if(wt[idx] <= bagCapacity){
                totalValue += val[idx];
                bagCapacity -= wt[idx];
            } else {
                totalValue += ratio[i][1] * bagCapacity;
                bagCapacity = 0;
                break; 
            }
        }

        return totalValue;
    }
}