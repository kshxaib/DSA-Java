public class Counting {
    public static void CountingSort(int arr[]){
        int maxElement = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(maxElement < arr[i]){
                maxElement = arr[i];
            }
        }

        int countArr[] = new int[maxElement +1];
        for(int i=0; i<arr.length; i++){
            countArr[arr[i]]++;
        }

        int j=0;
        for(int i=countArr.length -1; i>=0; i--){
            while (countArr[i] > 0) {
                arr[j] = i;
                countArr[i]--;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        CountingSort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
