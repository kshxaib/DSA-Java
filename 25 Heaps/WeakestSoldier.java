import java.util.*;

public class WeakestSoldier {
    static class Row implements Comparable<Row>{
        int soldiers;
        int index;

        public Row(int soldiers, int index){
            this.soldiers = soldiers;
            this.index = index;
        }

        @Override 
        public int compareTo(Row r2){
            if(this.soldiers == r2.soldiers){
                return this.index - r2.index;
            }else{
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static void findWeakestSoldier(int army[][], int k){
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i=0; i<army.length; i++){

            int count =0;
            for(int j=0; j<army[0].length; j++){
                if(army[i][j] == 1){
                    count++;
                }
            }

            pq.add(new Row(count, i));
        }

        for(int i=0; i<k; i++){
            System.out.println("R"+pq.remove().index);
        }
    }

    public static void main(String[] args) {
        int army[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };

        int k =2;
        findWeakestSoldier(army, k);
    }
}

/*
Time Complexity:
1. Counting soldiers in each row: O(n * m)
   n = number of rows
   m = number of columns

2. Adding n rows into PriorityQueue: O(n log n)

3. Removing k weakest rows: O(k log n)

Total Time Complexity: O(n * m + n log n + k log n)

Space Complexity:
PriorityQueue stores n Row objects → O(n)
*/