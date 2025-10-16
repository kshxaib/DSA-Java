// Problem: Chocola Problem (Minimum Cost to Cut Chocolate)
/*
This program solves the "Chocola Problem" using a greedy algorithm.

Goal:
You are given a chocolate bar of size m × n.  
You need to cut it into 1×1 pieces, and each cut has a certain cost.  
You can only make cuts between pieces — horizontally or vertically.

Objective:
Minimize the total cost required to cut the entire chocolate into 1×1 squares.

Concept:
1. Each horizontal and vertical cut has a given cost.
2. Every time you make a cut, it affects multiple existing pieces.
3. Always make the *most expensive cut first* (greedy approach).
4. Maintain counters for:
   - `hp` → number of horizontal pieces
   - `vp` → number of vertical pieces
5. When a horizontal cut is made, it multiplies with current vertical pieces (vp).
   When a vertical cut is made, it multiplies with current horizontal pieces (hp).

Example:
Input:
Vertical cuts cost = [2, 1, 3, 1, 4]
Horizontal cuts cost = [4, 1, 2]

Output:
Minimum total cost = 42

Key Idea:
Sort both cost arrays in descending order, and repeatedly take the larger cost first.
*/

import java.util.*;

public class ChocolaProblem {

    // Function to find minimum total cutting cost
    public static int findMinCost(Integer costVer[], Integer costHor[]) {
        // Step 1: Sort both cost arrays in descending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        // Step 2: Initialize variables
        int h = 0, v = 0; // indices for cuts
        int hp = 1, vp = 1; // current number of horizontal & vertical pieces
        int totalCost = 0;  // total minimum cost

        // Step 3: Process cuts greedily
        while (h < costHor.length && v < costVer.length) {
            // If next horizontal cut cost is greater, make horizontal cut
            if (costVer[v] <= costHor[h]) {
                totalCost += (vp * costHor[h]); // multiply by current vertical pieces
                hp++;  // horizontal pieces increase
                h++;   // move to next horizontal cut
            } 
            // Otherwise, make vertical cut
            else {
                totalCost += (hp * costVer[v]); // multiply by current horizontal pieces
                vp++;  // vertical pieces increase
                v++;   // move to next vertical cut
            }
        }

        // Step 4: Process remaining horizontal cuts
        while (h < costHor.length) {
            totalCost += (vp * costHor[h]);
            hp++;
            h++;
        }

        // Step 5: Process remaining vertical cuts
        while (v < costVer.length) {
            totalCost += (hp * costVer[v]);
            vp++;
            v++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        System.out.println("Minimum total cost: " + findMinCost(costVer, costHor));
    }
}

/*
Dry Run:
Vertical = [4, 3, 2, 1, 1]
Horizontal = [4, 2, 1]

Step 1: Pick max → H(4): total = 4×1 = 4 (hp=2, vp=1)
Step 2: Next max → V(4): total = 4 + 4×2 = 12 (hp=2, vp=2)
Step 3: Next max → V(3): total = 12 + 3×2 = 18 (hp=2, vp=3)
Step 4: Next max → H(2): total = 18 + 2×3 = 24 (hp=3, vp=3)
Step 5: Next max → V(2): total = 24 + 2×3 = 30 (hp=3, vp=4)
Step 6: Next max → H(1): total = 30 + 1×4 = 34 (hp=4, vp=4)
Step 7: Remaining V(1,1): total = 34 + 1×4 + 1×4 = 42

Output:
Minimum total cost = 42

Time Complexity: O(n log n)
- Sorting vertical and horizontal arrays

Space Complexity: O(1)
- Constant auxiliary space

Concept Used:
- Greedy algorithm
- Sorting and optimal cut selection
- Multiplicative cost due to piece increase
*/
