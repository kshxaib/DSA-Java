public class StringConversion {
    public static int lcs(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    /*
      String Conversion using only Insertions and Deletions

      Important Formula:
      Let L = LCS(str1, str2)

      deletions  = str1.length() - L
      insertions = str2.length() - L
      totalOps   = deletions + insertions

      Reason:
      - Delete characters from str1 that are not part of LCS
      - Insert characters into str1 to form str2 using remaining part
    */
    public static void SC(String str1, String str2) {
        int L = lcs(str1, str2);

        int deletions = str1.length() - L;
        int insertions = str2.length() - L;
        int totalOps = deletions + insertions;

        System.out.println("Deletions = " + deletions);
        System.out.println("Insertions = " + insertions);
        System.out.println("Total Operations = " + totalOps);
    }

    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";

        SC(str1, str2);
    }    
}
