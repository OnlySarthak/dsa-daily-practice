public class Recursive_sorting {
    public static void bubbleSort(int[] arr, int n){
        if(n==0){
            for (int i : arr) {
                System.out.println(i);
            }
            return;
        }
        
        for (int j = 0; j < n-1; j++) 
        {
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            } 
        }

        bubbleSort(arr, n-1);
    }

    public static void insertionSort(int[] arr, int n){
        if(n==1)return;

        insertionSort(arr, n-1);

        for (int j = n-1 ; j >= 1 ; j--) {
            if(arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
            else break;
        }

        for (int i : arr) {
            System.out.print(i+" ");
        }

        System.out.println();

    }
    public static void main(String[] args) {
        int[] arr= {90,1,2,83,4,6,7,0};
        System.out.println("original array:");
         for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        // bubbleSort(arr,arr.length);
        insertionSort(arr,arr.length);
    }
}
