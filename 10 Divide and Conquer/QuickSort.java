// Problem: Quick Sort
/*
📌 Problem Statement:
Given an array of integers, sort it in ascending order using
the Quick Sort algorithm.

👉 Idea (Divide and Conquer):
   - Choose a pivot element.
   - Partition the array into two parts:
       Left  → elements smaller than or equal to pivot
       Right → elements greater than pivot
   - Recursively sort both parts.

Steps:
   1. Divide  → Partition the array around a pivot.
   2. Conquer → Recursively apply QuickSort on left & right partitions.
   3. Combine → Since elements are placed correctly during partitioning,
                no extra combine step is required.
*/

public class QuickSort {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int start, int end){
        if(start >= end){
            return;
        }

        int partitionIdx = partition(arr, start, end);
        quickSort(arr, start, partitionIdx -1);
        quickSort(arr, partitionIdx +1, end);
    }

    public static int partition(int arr[], int start, int end){
        int pivot = arr[end];
        int i = start-1;

        for(int j=start; j<end; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        arr[end] = arr[i];
        arr[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        int arr[] = {4, 6, 2, 5, 7, 9, 1, 3};
        quickSort(arr, 0, arr.length -1);
        printArr(arr); 
    }
}

/*
📊 Time Complexity Analysis:
   - Best / Average Case: O(n log n)
     (Array gets divided approximately in half at each step)
   - Worst Case: O(n²) 
     (If pivot is always smallest/largest → highly unbalanced split)

📊 Space Complexity:
   - O(log n) recursion stack (for balanced partitions).
   - In-place sorting → no extra array needed.
   - Overall → O(log n)
*/
