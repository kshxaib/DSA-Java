/*
        FRUIT INTO BASKETS

Definition:
Given array fruits[],

Each element = fruit type on a tree.

You have only 2 baskets,
each basket can hold only ONE fruit type
but unlimited quantity.

Pick fruits from a continuous subarray.

Return maximum fruits you can collect.


Example 1

Input:
fruits = [1,2,1]

Output:
3

Explanation:
Pick all trees:
[1,2,1]


Example 2

Input:
fruits = [0,1,2,2]

Output:
3

Explanation:
Pick:
[1,2,2]


Example 3

Input:
fruits = [1,2,3,2,2]

Output:
4

Explanation:
Pick:
[2,3,2,2]


Core Idea
Need longest subarray
with AT MOST 2 distinct numbers.


BRUTE FORCE

Try every start index.
Expand until distinct fruits become 3.
Time = O(n²)


OPTIMAL IDEA (SLIDING WINDOW + HASHMAP)
Maintain window with:
at most 2 fruit types.

Use map:
fruitType -> frequency


Why This Works

If window has >2 types,
it becomes invalid.

Shrink from left until valid again.


Time Complexity
Brute Force = O(n²)
Optimal = O(n)
Each pointer moves once.

Space Complexity
O(2) ≈ O(1)
(HashMap stores max 3 types temporarily)
*/


class Solution {

    /*
        BRUTE FORCE
        Time: O(n²)
        Space: O(1) / O(3)
    */
    public int totalFruitBrute(int[] fruits) {
        int maxFruits = 0;

        for(int i = 0; i < fruits.length; i++){
            Set<Integer> set = new HashSet<>();

            for(int j = i; j < fruits.length; j++){
                set.add(fruits[j]);

                // invalid if 3 fruit types
                if(set.size() == 3){
                    break;
                }

                int len = j - i + 1;
                maxFruits = Math.max(maxFruits, len);
            }
        }

        return maxFruits;
    }



    /*
        OPTIMAL
        Sliding Window + HashMap
        Time: O(n)
        Space: O(1)
    */
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        while(right < n){
            int curr = fruits[right];

            // include current fruit
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            // shrink window if >2 types
            while(map.size() > 2){
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit) - 1);

                // remove if count becomes zero
                if(map.get(leftFruit) == 0){
                    map.remove(leftFruit);
                }

                left++;
            }

            // valid window
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);

            right++;
        }

        return maxLen;
    }
}