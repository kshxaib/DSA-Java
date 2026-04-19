/*
        ASTEROID COLLISION (STACK)

Definition:
Given an array of asteroids:

• Positive value  → moving RIGHT
• Negative value  → moving LEFT
• Absolute value  → size

When two asteroids collide:

• Smaller one explodes
• If equal size → both explode
• Same direction → no collision

Return surviving asteroids.


Example 1

Input:
[5,10,-5]

Output:
[5,10]

Explanation:

10 and -5 collide

10 survives


Example 2

Input:
[8,-8]

Output:
[]

Both destroy each other


Example 3

Input:
[10,2,-5]

Output:
[10]

2 destroyed first,
then -5 destroyed by 10


Core Idea (STACK)

Use stack to keep surviving asteroids.
Only collision possible when:

Top of stack > 0
Current asteroid < 0

(Right meets Left)


Time Complexity: O(n)
Each asteroid pushed/popped once

Space Complexity: O(n)
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        // list used as stack
        List<Integer> st = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // moving right → push directly
            if (asteroids[i] > 0) {
                st.add(asteroids[i]);
            }

            // moving left → collision possible
            else {

                // destroy smaller right-moving asteroids
                while (!st.isEmpty()
                        && st.get(st.size() - 1) > 0
                        && st.get(st.size() - 1) < Math.abs(asteroids[i])) {

                    st.remove(st.size() - 1);
                }

                // equal size → both destroyed
                if (!st.isEmpty()
                        && st.get(st.size() - 1) == Math.abs(asteroids[i])) {

                    st.remove(st.size() - 1);
                }

                // current asteroid survives
                else if (st.isEmpty()
                        || st.get(st.size() - 1) < 0) {

                    st.add(asteroids[i]);
                }
            }
        }

        // convert list to array
        int[] result = new int[st.size()];

        for (int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }

        return result;
    }
}