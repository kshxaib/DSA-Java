import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)){
            return ans;
        }

        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(beginWord));

        while(!queue.isEmpty()){
            int size = queue.size();

            // words used in this level (new words added in this path)
            Set<String> used = new HashSet<>();

            for(int i=0; i<size; i++){
                List<String> path = queue.poll();    // ["", "", ""]
                String word = path.get(path.size()-1);

                if(word.equals(endWord)){
                    ans.add(path);
                    continue;
                }

                char arr[] = word.toCharArray();

                for(int j=0; j<arr.length; j++){
                    char original = arr[j];

                    for(char ch='a'; ch<='z'; ch++){
                        arr[j] = ch;

                        String newWord = new String(arr);

                        if(set.contains(newWord)){
                            List<String> newPath = new ArrayList<>(path);

                            newPath.add(newWord);
                            queue.offer(newPath);
                            used.add(newWord);
                        }
                    }

                    arr[j] = original;
                }
            }

            // remove after level ends
            for(String word : used){
                set.remove(word);
            }

            // shortest paths found
            if(!ans.isEmpty()){
                break;
            }
        }

        return ans;
    }
}