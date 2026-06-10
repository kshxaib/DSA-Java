class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        List<int []> meetings = new ArrayList<>();
        for(int i=0; i<n; i++){
            meetings.add(new int[]{end[i], start[i], i});
        }

        Collections.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int totalMeeting = 0;
        int lastEnd = -1;
        int i = 0;
        while(i < n){
            int currMeeting[] = meetings.get(i);
            if(lastEnd < currMeeting[1]){
                totalMeeting++;
                lastEnd = currMeeting[0];
            } 

            i++;
        }

        return totalMeeting;
    }
}