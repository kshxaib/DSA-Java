public class RodCutting{
    public static int RC(int lenght[], int price[], int totRod){
        int n = lenght.length;
        int dp[][] = new int[n+1][totRod+1];

        for(int i=0; i<n+1; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<totRod+1; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<totRod+1; j++){
                int prc = price[i-1];
                int lg = lenght[i-1];
                if(lg <= j){
                    dp[i][j] = Math.max(prc + dp[i][j-lg], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][totRod];
    }

    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int totalRod = 8;

        System.out.println(RC(length, price, totalRod));
    }
}