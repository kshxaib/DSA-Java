// Problem: Chocola Problem (Minimum Cost to Cut Chocolate)

import java.util.*;

public class ChocolaProblem {

    public static int findMinCost(Integer costVer[], Integer costHor[]) {
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; 
        int hp = 1, vp = 1; 
        int totalCost = 0; 

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {
                totalCost += (vp * costHor[h]); 
                hp++; 
                h++;   
            } 
            else {
                totalCost += (hp * costVer[v]);
                vp++;  
                v++;   
            }
        }

        while (h < costHor.length) {
            totalCost += (vp * costHor[h]);
            hp++;
            h++;
        }

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
Time Complexity: O(n log n)
- Sorting vertical and horizontal arrays

Space Complexity: O(1)
- Constant auxiliary space
*/
