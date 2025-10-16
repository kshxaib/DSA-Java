import java.util.*;

public class ChocolaProblem {
    public static int findMinCost(Integer costVer[], Integer costHor[]) {
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; // cut
        int hp = 1, vp = 1; // pieces
        int totalCost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) { // horizontal cut
                totalCost = totalCost + (vp * costHor[h]);
                hp++;
                h++;
            } else {
                totalCost = totalCost + (hp * costVer[v]);
                vp++;
                v++;
            }
        }

        while (h < costHor.length) {
            totalCost = totalCost + (vp * costHor[h]);
            hp++;
            h++;
        }

        while (v < costVer.length) {
            totalCost = totalCost + (hp * costVer[v]);
            vp++;
            v++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        System.out.println(findMinCost(costVer, costHor));
    }
}