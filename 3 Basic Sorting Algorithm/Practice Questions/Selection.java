public class Selection {
    public static void SelectionSort(int arr[]){
        for(int i=0; i<arr.length -1; i++){
            int assumeMaxElementIdx = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[assumeMaxElementIdx] < arr[j]){
                    assumeMaxElementIdx = j;
                }
            }
            
            int temp = arr[assumeMaxElementIdx]; // max element
            arr[assumeMaxElementIdx] = arr[i];
            arr[i] = temp;
        }
    }

        public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        SelectionSort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
