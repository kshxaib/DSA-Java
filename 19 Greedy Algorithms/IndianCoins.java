import java.util.*;

public class IndianCoins {
    public static ArrayList<Integer> findCoins(Integer coins[], int value) {
        Arrays.sort(coins, Comparator.reverseOrder());

        ArrayList<Integer> selectedCoins = new ArrayList<>();
        int count = 0;
        int remainingValue = value;
        for (int i = 0; i < coins.length; i++) {
             while (coins[i] <= remainingValue) {
                remainingValue = remainingValue - coins[i];
                selectedCoins.add(coins[i]);
                count++;
            }
        }
        return selectedCoins;
    }

    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        System.out.println(findCoins(coins, 590));
    }
}
