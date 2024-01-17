public class Sorting {
    static void swap(int[] ar,int A,int B){
        int t = ar[A];
        ar[A] = ar[B];
        ar[B] = t;
    }

    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n-1; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < i; j++) 
            {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    count++;
                }
                
            }
            if(count == 0)break;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void insertionSort(int[] arr) {
        int size = arr.length;


        for (int i = 1; i < size; i++) {
            for (int j = i ; j >= 1 ; j--) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else break;
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void insertionSort_bystriver(int[] arr){

        //best scenario to implement insertion sort

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int j = i;
            while(j!=0 && arr[j-1]>arr[j]){

                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;

            }
            
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void mergeSort(int[] arr, int left, int right){
        if(left == right)return;    //base

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int l, int mid, int r){
        int[] temp = new int[(r-l)+1];
        int left = l, right = mid+1, i = 0;

        //merge two array in temp in sorted manner
        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[i++] = arr[left++];
            }
            else{
                temp[i++] = arr[right++];
            }
        }

        //if left part of temp still remained then move to arr
        while (left <= mid) {
            temp[i++] = arr[left++];
        }
        //if left part of temp still remained then move to arr
        while (right <= r) {
            temp[i++] = arr[right++];
        }

        //copy(temp) paste(arr)
        i=0;
        for (int j = l; j <= r; j++) {
            arr[j] = temp[i++];
        }

        // for (int i1 : temp) {
        //     System.out.print(i1);
        // }                                //for observation only
        // System.out.println();
    }

    static void mergeSortPlatform(){
        int[] arr = {8,3,4,0,5,-1,7,2};
        mergeSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    static void QuickSort(int[] arr, int left, int right){
        if (left<right) {
            int pindex = Qpartition(arr,left,right);

            QuickSort(arr, left, pindex-1);
            QuickSort(arr, pindex+1, right);
        }
    }

    static int Qpartition(int[] arr,int low, int high){
        int l = low, r = high, pivot = low;

        while (l < r) {
            while (arr[l] <= arr[pivot] && arr[l]<=arr[high-1]) {
                l++;
            }
            while (arr[r] > arr[pivot] && arr[r] >= arr[low+1]) {
                r--;
            }
            if(l<r){
                swap(arr, l,r);
            }
        }

        swap(arr, r, pivot);

        return r;
    }

    static void QuickSortPlatform(){
        int[] arr3 = {8,3,4,0,5,-1,7,2};
        QuickSort(arr3, 0, arr3.length-1);
        for (int i : arr3) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        // int[] arr= {1,2,3,4,6,7,0};
        // bubbleSort(arr);
        // insertionSort(arr);
        // insertionSort_bystriver(arr);
    //    mergeSortPlatform();
    QuickSortPlatform();
    }
}
