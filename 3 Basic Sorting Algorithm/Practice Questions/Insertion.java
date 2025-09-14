public class Insertion {
    public static void InsertionSort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int currentElement = arr[i];
            int prevIdx = i-1;

            while (prevIdx >=0 && arr[prevIdx] < currentElement) {
                arr[prevIdx + 1] = arr[prevIdx];
                prevIdx--;
            }

            arr[prevIdx +1] = currentElement;
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        InsertionSort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
