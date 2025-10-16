import java.util.*;

public class ActivitySelection{
    public static ArrayList<Integer> findActivity(int start[], int end[]){
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function -> means shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        
        int maxAct = 0;
        ArrayList<Integer> ActIndex = new ArrayList<>();

        maxAct = 1;
        ActIndex.add(activities[0][0]);
        int prevAct = activities[0][2];

        for(int i=1; i<start.length; i++){
            if(activities[i][1] >= prevAct){
                maxAct++;
                ActIndex.add(activities[i][0]);
                prevAct = activities[i][2];
            }
        }

        return ActIndex;
    }

    // Already sorted
    public static ArrayList<Integer> findAct(int start[], int end[]){
        int maxAct = 0;
        ArrayList<Integer> ActIndex = new ArrayList<>();

        maxAct = 1;
        ActIndex.add(0);
        int prevAct = end[0];

        for(int i=1; i<start.length; i++){
            if(start[i] >= prevAct){
                maxAct++;
                ActIndex.add(i);
                prevAct = end[i];   
            }
        }

        return ActIndex;
    }

    public static void main(String args[]){
        int start[] = {0,1,3,5,8,5};
        int end[] = {6,2,4,7,9,9};

        System.out.println(findActivity(start, end));
    }
}