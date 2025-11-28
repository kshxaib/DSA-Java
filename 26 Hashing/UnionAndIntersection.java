import java.util.*;

public class UnionAndIntersection {
    public static void findUandI(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        // union
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }

        System.out.println("Union: " + set.size());

        set.clear();

        // intersection
        int count = 0;
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }

        System.out.println("Intersection: " + count);
    }

    public static void main(String[] args) {
        int arr1[] = {7, 3, 9}; 
        int arr2[] = {6, 3, 9, 2, 9, 4}; 

        findUandI(arr1, arr2);
    }
}

/*
Time Complexity:
O(n + m)
- Adding elements of arr1: O(n)
- Adding elements of arr2: O(m)
- Checking intersection: O(m) average with HashSet O(1) lookups

Space Complexity:
O(n)
- HashSet stores elements of arr1 for intersection check
- Union also uses HashSet that may store up to (n + m) unique elements, but auxiliary space is dominated by HashSet usage
*/
