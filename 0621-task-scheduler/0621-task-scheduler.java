class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);   
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int count : map.values()){
            maxHeap.add(count);
        }

        int time = 0;
        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();

            // if we add A then we can place A again at n+1 place
            for(int i = 1; i <= n+1; i++){
                if(!maxHeap.isEmpty()){
                    int freq = maxHeap.poll();
                    freq--;

                    temp.add(freq);
                }
            }

            for(int i = 0; i < temp.size(); i++){
                if(temp.get(i) > 0){
                    maxHeap.add(temp.get(i));
                }
            }

            time += maxHeap.isEmpty() ? temp.size() : n +1;
        }

        return time;
    }
}