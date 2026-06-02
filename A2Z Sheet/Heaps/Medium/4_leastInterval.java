class Task implements Comparable<Task>{
    int frequency;
    int excuetionTime;

    Task(int f, int t){
        this.frequency = f;
        this.excuetionTime = t;
    }

    public int compareTo(Task t2){
        return t2.frequency - this.frequency;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) +1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>();

    for(Character ch : map.keySet()){
        int freq = map.get(ch);
        pq.add(new Task(freq, 0));
    }

    Queue<Task> queue = new LinkedList<>();
    int time = 0;

    while(!queue.isEmpty() || !pq.isEmpty()){
        time++;

        if(!pq.isEmpty()){
            Task task = pq.remove();
            task.frequency--;

            if(task.frequency > 0){
                task.excuetionTime = time + n;
                queue.add(task);
            }
        }

        if(!queue.isEmpty() && queue.peek().excuetionTime == time){
            pq.add(queue.remove());
        }
    }

    return time;
    }
}