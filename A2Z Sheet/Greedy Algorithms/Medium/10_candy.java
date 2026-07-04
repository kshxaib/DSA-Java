class Solution {
    public int candyBrute(int[] ratings) {
        int n = ratings.length;

        int leftAns[] = new int[n];
        int candies = 1;
        leftAns[0] = candies;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies++;
                leftAns[i] = candies;
            } else {
                candies = 1;
                leftAns[i] = candies;
            }
        }

        int rightAns[] = new int[n];
        candies = 1;
        rightAns[n - 1] = candies;

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies++;
                rightAns[i] = candies;
            } else {
                candies = 1;
                rightAns[i] = candies;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(leftAns[i], rightAns[i]);
        }

        return ans;
    }

    public int candy(int[] ratings) {
        int n = ratings.length;

        int sum = 1;
        int i = 1;

        while (i < n) {
            // Same rating gets 1 candy
            if (ratings[i] == ratings[i - 1]) {
                sum++;
                i++;
                continue;
            }

            // Increasing slope
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // Decreasing slope
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                down++;
                i++;
            }

            // Peak counted in increasing side, adjust if decreasing side is bigger
            if (down > peak) {
                sum += down - peak;
            }
        }

        return sum;
    }
}