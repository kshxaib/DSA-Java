/*
        HAND OF STRAIGHTS

Definition:
Given an array hand[]
and integer groupSize,

Check whether cards can be divided into groups
of size groupSize such that:

Each group contains consecutive cards.

Return true if possible,
otherwise false.


Example 1

Input:
hand = [1,2,3,6,2,3,4,7,8]
groupSize = 3

Output:
true

Explanation:

Groups:

[1,2,3]
[2,3,4]
[6,7,8]


Example 2

Input:
hand = [1,2,3,4,5]
groupSize = 4

Output:
false

Explanation:

5 cards cannot form groups of 4.


Core Idea

Always start from the
SMALLEST available card.

Why?
Because smallest card must be
the beginning of some group.


Data Structure

TreeMap
Stores:
card -> frequency

Automatically keeps keys sorted.


Why This Works
Smallest remaining card
cannot belong to any earlier group.

So it MUST start a new group.

Greedy choice is always safe.



Time Complexity
Let:
n = number of cards
Each card removed once.

TreeMap operations: O(log n)
Total: O(n log n)

Space Complexity: O(n)
TreeMap frequencies
*/

class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        // total cards must form complete groups
        if(hand.length % groupSize != 0){
            return false;
        }

        // card -> frequency
        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for(int i = 0; i < hand.length; i++){
            int card = hand[i];
            freq.put(card, freq.getOrDefault(card, 0) + 1); 
        }

        // process smallest cards first
        while(!freq.isEmpty()){
            int start = freq.firstKey();

            // create one consecutive group
            for(int i = 0; i < groupSize; i++){
                int card = start + i;

                // required card missing
                if(!freq.containsKey(card)){
                    return false;
                }

                freq.put(card, freq.get(card) - 1);

                // remove exhausted card
                if(freq.get(card) == 0){
                    freq.remove(card);
                }
            }
        }

        return true;
    }
}