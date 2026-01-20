import java.util.*;

public class TargetSumSubset {

    /*
      Target Sum Subset (Recursive)
      Goal: Check if there exists a subset whose sum = target

      Parameters:
      nums[]  -> given array
      tar     -> target sum
      tot     -> current sum formed
      i       -> current index
    */
    public static boolean TSS(int nums[], int tar, int tot, int i) {

        // If current sum becomes exactly target, subset found
        if (tot == tar) {
            return true;
        }

        // If we reached end of array, no subset possible from here
        if (i == nums.length) {
            return false;
        }

        // Option 1: Include current element (only if it doesn't exceed target)
        if (tot + nums[i] <= tar) {
            if (TSS(nums, tar, tot + nums[i], i + 1)) {
                return true;
            }
        }

        // Option 2: Exclude current element
        if (TSS(nums, tar, tot, i + 1)) {
            return true;
        }

        // If neither include nor exclude works
        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 2, 7, 1, 3 };
        int target = 10;

        boolean ans = TSS(nums, target, 0, 0);
        System.out.println(ans);
    }
}
