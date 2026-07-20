import java.util.*;

class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;

        Arrays.sort(position);
        int maxDis = position[n - 1] - position[0];

        int ans = 0;

        for (int dis = 1; dis <= maxDis; dis++) {
            if (canPlace(position, m, dis)) {
                ans = dis;
            } else
                break;
        }

        return ans;
    }

    private boolean canPlace(int[] position, int m, int dis) {
        int count = 1;
        int lastPosition = position[0];

        for (int i = 1; i < position.length; i++) {
            if ((position[i] - lastPosition) >= dis) {
                count++;
                lastPosition = position[i];
            }

            if (count >= m)
                return true;
        }

        return false;
    }
}