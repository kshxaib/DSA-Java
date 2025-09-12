public class CountingSort {
    public static void CS(int arr[]){
        int largestNumber = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > largestNumber){
                largestNumber = arr[i];
            }
        }

        int count[] = new int[largestNumber + 1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }

        int j=0;
        for(int i=0; i<count.length; i++){
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--; 
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 1, 5, 2, 3};

        // Call Insertion Sort
        CS(arr);

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
