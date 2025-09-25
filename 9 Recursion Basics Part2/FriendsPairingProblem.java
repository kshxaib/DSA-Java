// Problem: Friends Pairing Problem
/*
📌 Problem Statement:
You have n friends. Each friend can either:
    1. Stay single
    2. Pair up with exactly one other friend
Count the total number of ways these friends can stay single or pair up.

👉 Choices for nth friend:
   - Stay single → solve for (n-1) friends
   - Pair up with any of the (n-1) friends → then solve for (n-2) friends
     (because 2 friends are paired, so problem size reduces by 2)

So recurrence relation:
    f(n) = f(n-1) + (n-1) * f(n-2)
*/

public class FriendsPairingProblem {

    // Recursive function
    public static int findFriendsPairing(int n){
        // Base cases
        if(n == 1 || n == 2){
            return n;   // 1 friend → 1 way, 2 friends → 2 ways ({1,2} or single-single)
        }

        // Case 1: nth friend stays single
        int fnm1 = findFriendsPairing(n-1);

        // Case 2: nth friend pairs with (n-1) choices of friends
        int fnm2 = findFriendsPairing(n-2);
        int pairWays = (n-1) * fnm2;

        // Total ways = single case + pair case
        int totalWays = fnm1 + pairWays;
        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(findFriendsPairing(5));  
        // Expected output → 26
    }    
}

/*
📌 Dry Run (n=3):
    f(3) = f(2) + (2) * f(1)
          = 2 + 2*1
          = 4 ways
    Ways: {1}{2}{3}, {1,2}{3}, {1,3}{2}, {2,3}{1}

📌 Dry Run (n=5):
    f(5) = f(4) + 4 * f(3)
    f(4) = f(3) + 3 * f(2) = 4 + 3*2 = 10
    f(3) = 4
    f(5) = 10 + 4*4 = 26

✅ Final Answer for n=5 → 26 ways

✅ Time Complexity: O(2^n) → exponential recursion
✅ Space Complexity: O(n) → recursion stack

⚡ Optimization:
We can use Dynamic Programming (Memoization or Tabulation) to reduce to O(n).
*/
