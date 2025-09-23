// Program to print numbers in increasing order using recursion
public class PrintNumberInIncreasing {

    // Recursive function to print numbers from 1 to n
    public static void printIncreasing(int n){
        // Base case: if n == 1, just print 1
        if(n == 1){
            System.out.println(n);
            return;  // End recursion
        }

        // Recursive call with (n-1), so it will first go till 1
        printIncreasing(n-1);

        // After recursion completes, print n (ensures increasing order)
        System.out.println(n);
    }

    public static void main(String[] args) {
        printIncreasing(10);
    }
}

/*
📌 Dry Run for n = 3:
    printIncreasing(3)
        -> printIncreasing(2)
            -> printIncreasing(1) → prints 1
        → prints 2
    → prints 3
Output: 1 2 3

✅ Time Complexity: O(n)  → each number from 1 to n is printed once
✅ Space Complexity: O(n) → recursive stack holds n calls in memory
*/
