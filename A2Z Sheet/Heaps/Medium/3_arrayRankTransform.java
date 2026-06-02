/*
        RANK TRANSFORM OF AN ARRAY

Definition:
Given array arr[],

Replace each element with its rank.

Rules:

• Rank starts from 1
• Larger value → larger rank
• Equal values → same rank


Example 1

Input:
arr = [40,10,20,30]

Sorted Unique:
[10,20,30,40]

Ranks:
10 -> 1
20 -> 2
30 -> 3
40 -> 4

Output:
[4,1,2,3]


Example 2

Input:
arr = [100,100,100]

Output:
[1,1,1]


Example 3

Input:
arr = [37,12,28,9,100,56,80,5,12]

Output:
[5,3,4,2,8,6,7,1,3]


=====================================================
1. BRUTE FORCE
=====================================================

For every element:
Count distinct numbers smaller than it.
Rank = count + 1


Why Set?
Duplicates should get same rank.


Time Complexity: O(n²)
Space Complexity: O(n)
*/

import java.util.*;

class Solution {

    public int[] arrayRankTransformBrute(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            int curr = arr[i];
            Set<Integer> set = new HashSet<>();

            // count distinct smaller elements
            for(int j = 0; j < arr.length; j++){
                if(arr[j] < curr){
                    set.add(arr[j]);
                }
            }

            int rank = set.size() + 1;
            list.add(rank);
        }

        int result[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }


/*
=====================================================
2. OPTIMAL (SORT + HASHMAP)
=====================================================

Core Idea
1. Clone array
2. Sort it
3. Assign ranks to unique values
4. Replace using HashMap


Why This Works
Sorted order automatically gives ranks.

HashMap stores:
value -> rank


Example
arr = [40,10,20,30]
sorted = [10,20,30,40]

Map:
10 -> 1
20 -> 2
30 -> 3
40 -> 4


Time Complexity: O(n log n)
Sorting = O(n log n)
Mapping = O(n)

Space Complexity: O(n)
*/

    public int[] arrayRankTransform(int[] arr) {
        // create sorted copy
        int sortedArr[] = arr.clone();
        Arrays.sort(sortedArr);

        // value -> rank
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // assign ranks to unique values
        for(int i = 0; i < sortedArr.length; i++){
            int curr = sortedArr[i];

            if(!rankMap.containsKey(curr)){
                rankMap.put(curr, rank);
                rank++;
            }
        }

        // build answer
        int result[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}