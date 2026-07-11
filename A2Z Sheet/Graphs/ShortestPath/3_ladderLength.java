import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);  // dictionary + visited

        if(!set.contains(endWord)){ // impossible case
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.remove(beginWord);  // mark visited

        // BFS level
        int steps = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){      // process current level
                String word = queue.poll();

                if(word.equals(endWord)){   // reached target
                    return steps;
                }

                char arr[] = word.toCharArray();

                for(int j=0; j<arr.length; j++){    // change every position
                    char original = arr[j];

                    for(char ch='a'; ch<='z'; ch++){     // try a-z
                        arr[j] = ch;

                        String newWord = new String(arr);

                        if(set.contains(newWord)){  // valid unvisited word
                            queue.offer(newWord);
                            set.remove(newWord);    // mark visited
                        }
                    }

                    arr[j] = original;  // restore character
                }
            }

            steps++;    // next transformation
        }

        return 0;
    }
}