import java.util.*;

public class PairSum2 {
    public static boolean findPairSum(ArrayList<Integer> list, int target){
        int n = list.size(); 
        int breakingPoint = -1;
        for(int i=0; i<n; i++){
            if(list.get(i) > list.get(i+1)){
                breakingPoint = i;
                break;
            }
        }

        int leftPointer = breakingPoint+1; 
        int rightPointer = breakingPoint;

        while (leftPointer != rightPointer) {
            int sum = list.get(leftPointer) + list.get(rightPointer);
            if(target == sum){
                return true;
            } else if(target > sum){
                leftPointer = (leftPointer +1) % n;
            } else{
                rightPointer = (n + rightPointer - 1) % n;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;

        System.out.println(findPairSum(list, target));
    }
}
