
import java.util.ArrayList;
import java.util.Iterator;

public class arr5 {
    //move zeros

    public void moveZeroes(int[] arr) {
        //brute forse

        ArrayList<Integer> result=new ArrayList<>();

        for (int elem : arr) {
            if(elem != 0)
                result.add(elem);
        }

        Iterator<Integer> it = result.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
    }

    public void moveZeroesClearVersion(int[] arr){
        int start = 0; 
        int end = arr.length -1;
        
        while(start < end){
        //move to next 0
        while(start < end && arr[start] != 0)start++;
        //move to next non 0
        while(start < end && arr[end] == 0)end--;

        swap(arr, start, end);
        }

        for(int ir:arr){
        System.out.println(ir);
        }
    }


    public void moveZeroes1(int[] arr){
          //optimal
          int l=0 , r;

          //find first zero
         for (int idx = 0; idx < arr.length; idx++) {
            if(arr[idx]==0){
              l = idx;
              break;
            }
         }
  
          //    swap with r
          r = l+1;
          while( r < arr.length) {
              if(arr[r] != 0 ){
                  swap(arr, l, r);
                  l++;
              }
              r++;
          }

          for(int ir:arr){
            System.out.println(ir);
          }
    }

    
    public static void main(String[] args) {
        arr5 a=new arr5();
        int[] arr={0,1,0,3,12};
        a.moveZeroes1(arr);
    }

    //other functs
    public void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
