import java.util.*;

public class MaxLengthChairOfPairs {
    public static int findMaxLength(int pairs[][]){
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int lenght =1;
        int prevSelected = pairs[0][1];

        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0] >= prevSelected){
                lenght++;
                prevSelected = pairs[i][1];
            }
        }

        return lenght;
    }

    public static void main(String[] args) {
        int pairs[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}}; 
        System.out.println(findMaxLength(pairs));
    }
}
