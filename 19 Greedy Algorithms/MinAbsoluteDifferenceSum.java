import java.util.*;

public class MinAbsoluteDifferenceSum {
    public static int findMinAbsDiffSum(int A[], int B[]){
        int minSum = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++){
            minSum = minSum + Math.abs((A[i] - B[i]));
        }

        return minSum;
    }

    public static void main(String[] args) {
        int A[] = {1,2,3};
        int B[] = {2,1,3};

        System.out.println(findMinAbsDiffSum(A, B));
    }
}
