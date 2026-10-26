class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.remove(beginWord);

        int steps = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                String curr = queue.poll();

                if(curr.equals(endWord)){
                    return steps;
                }

                char arr[] = curr.toCharArray();   
                for(int j=0; j<arr.length; j++){
                    char original = arr[j];

                    for(char ch='a'; ch<='z'; ch++){
                        arr[j] = ch;

                        String newWord = new String(arr);
                        if(set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }

                    arr[j] = original;
                }             
            }

            steps++;
        }

        return 0;
    }
}