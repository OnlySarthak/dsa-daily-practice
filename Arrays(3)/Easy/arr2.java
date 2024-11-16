//Remove duplicates from Sorted array
import java.util.*;

public class arr2 {
    
    public void removeDuplicates1(int[] arr){       
        //using hashset to pick unique elements
        //by striver

        // Input array
        int[] inputArray = {4, 5, 9, 4, 2, 9, 7, 5, 2};
        
        // Create a HashSet to store unique elements
        Set<Integer> uniqueElements = new HashSet<>();
        
            // Add elements from the array to the HashSet
            for (int num : inputArray) {
                uniqueElements.add(num);
            }
    
            // Convert the HashSet back to an array
            int[] resultArray = new int[uniqueElements.size()];
            int index = 0;
            for (int num : uniqueElements) {
                resultArray[index++] = num;
            }
            
            // Print the resulting array
            System.out.println("Array after removing duplicates: " + Arrays.toString(resultArray));
            
    }

    public int removeDuplicates2(int[] arr) {
        //optimal solution
        int k=0;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[k] != arr[i]){
                k++;
                arr[k] = arr[i];
            }
        }

        return ++k;
    }
    public static void main(String[] args) {
        System.out.println("hello");
        // int[] arr = { 1, 2, 2, 3, 4, 5, 5, 6, 7, 8 };
        
    }


    public void removeDuplicatesX(int[] arr) {
    //robust soln for non sorted arry without using inbuild lib.
    //brute force by me
    
    
        boolean[] hash = new boolean[100];
        int i = 0, j = arr.length - 1;

        while (i < j) {
            if (!hash[arr[i]]) { // Check if current value is already processed
                hash[arr[i]] = true;
                i++;
            } else {
                boolean flag=false;
                do{
                    if (arr[i] != arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        flag = true;
                    }
                    j--;
                }while(!flag && i < j);
                
            }
        }

        for (int a : arr) {
            System.out.println(a);
        }
    }
}