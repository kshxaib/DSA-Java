import java.util.*;

class Solution {
    public List<List<String>> findLaddersBrute(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);  // HashSet for O(1) word lookup
                                                    // also works as visited after level completion
        if(!set.contains(endWord)){
            return ans;
        }

        Queue<List<String>> queue = new LinkedList<>(); // Queue stores complete transformation paths
        queue.offer(Arrays.asList(beginWord));

        while(!queue.isEmpty()){     // BFS level by level
            int size = queue.size();

            // store words used in current level remove them only after level ends
            Set<String> used = new HashSet<>();

            for(int i=0; i<size; i++){  // process all paths of current level
                List<String> path = queue.poll();    
                String word = path.get(path.size()-1);

                if(word.equals(endWord)){   // shortest path reached endWord
                    ans.add(path);
                    continue;   // don't generate paths after endWord
                }

                char arr[] = word.toCharArray();

                for(int j=0; j<arr.length; j++){    // try changing every character position
                    char original = arr[j];

                    for(char ch='a'; ch<='z'; ch++){    // replace current character with a-z
                        arr[j] = ch;

                        String newWord = new String(arr);

                        if(set.contains(newWord)){
                            List<String> newPath = new ArrayList<>(path); // create new path from current path

                            newPath.add(newWord);   // add transformed word
                            queue.offer(newPath);   // push new path for next level
                            used.add(newWord);  // mark to remove after this level
                        }
                    }

                    arr[j] = original;   // restore original character
                }
            }

            // now remove visited words allows multiple shortest paths in same level
            for(String word : used){
                set.remove(word);
            }

            // all shortest paths are found next levels will be longer
            if(!ans.isEmpty()){
                break;
            }
        }

        return ans;
    }
}