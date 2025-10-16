import java.util.*;

public class JobSquencing {
    public static ArrayList<Integer> findMaxValue(int jobs[][]){
        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[1]));

        ArrayList<Integer> jobTaken = new ArrayList<>();
        int time = 0;
        int maxValue = 0;

        for(int i=jobs.length -1; i>=0; i--){
            if(jobs[i][0] > time){
                jobTaken.add(jobs[i][1]);
                maxValue = maxValue + jobs[i][1];
                time++;
            }
        }
        System.out.println("Maximum profit: " + maxValue);

        return jobTaken;
    }

    public static void main(String[] args) {
        int jobs[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
        System.out.println(findMaxValue(jobs));
    }
}
