/*
        SORT CHARACTERS BY FREQUENCY

Problem:
Given a string s, return the list of unique characters
sorted by highest frequency.

If two characters have the same frequency,
they must be sorted alphabetically.


Example
Input:
s = "tree"

Output:
['e', 'r', 't']

Explanation:
Frequency:
e → 2
r → 1
t → 1

Characters with same frequency (r,t)
are sorted alphabetically.

Core Idea
1. Count frequency of each character.
2. Group characters by their frequency.
3. Traverse frequencies from highest → lowest.
4. For same frequency, sort characters alphabetically.

This technique is called **Bucket Sort**.


Step-by-Step Approach

Step 1 — Count Frequency
Create array freq[26]

Example:

s = "tree"

freq:

t → 1
r → 1
e → 2


Step 2 — Create Buckets
Bucket index represents frequency.

Example:

bucket[1] → [t, r]
bucket[2] → [e]


Step 3 — Traverse Buckets
Start from highest frequency.

bucket[2] → e  
bucket[1] → r, t (sorted alphabetically)


Step 4 — Build Result
result = ['e','r','t']


Algorithm Steps

1. Create frequency array of size 26.
2. Count occurrences of each character.
3. Create bucket array of size (string length + 1).
4. Place characters into buckets by frequency.
5. Traverse buckets from high → low.
6. Sort characters inside same bucket.
7. Add them to result.


Complexities
Time Complexity  : O(n)

Explanation:
- Counting frequencies → O(n)
- Bucket traversal → O(n)

Space Complexity : O(n)

Explanation:
Bucket array of size n+1.


Key Interview Points
Character index mapping: c - 'a'

Bucket index = frequency.

Traverse buckets from high → low.
*/

class Solution {    

    public List<Character> frequencySort(String s) {

        int freq[] = new int[26];

        // Step 1: Count frequency
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        // Step 2: Create buckets
        List<Character>[] bucket = new ArrayList[s.length() + 1];

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){

                int f = freq[i];

                if(bucket[f] == null){
                    bucket[f] = new ArrayList<>();
                }

                bucket[f].add((char)(i + 'a'));
            }
        }

        // Step 3: Build result
        List<Character> result = new ArrayList<>();

        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){

                Collections.sort(bucket[i]);
                result.addAll(bucket[i]);
            }
        }

        return result;
    }
}

// Time: O(n)
// Space: O(n)