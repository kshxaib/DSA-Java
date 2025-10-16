import java.util.*;

public class FractionalKnapsack {
    public static int findMaxValue(int value[], int weight[], int w) {
        double ratio[][] = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        double totalValue = 0;  
        int bagCapacity = w;

        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];

            if (bagCapacity >= weight[idx]) {
                totalValue += value[idx];
                bagCapacity -= weight[idx];
            } else {
                totalValue += ratio[i][1] * bagCapacity;
                bagCapacity = 0;
                break;
            }
        }

        return (int) totalValue;
    }

    public static void main(String args[]) {
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;

        System.out.println(findMaxValue(value, weight, w)); 
    }
}
