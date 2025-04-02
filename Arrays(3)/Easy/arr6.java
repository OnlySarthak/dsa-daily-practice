import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class arr6 {
    //find union of two sorted array
    
    public static ArrayList<Integer> findUnion1(int a[], int b[]) {
        //Brute
        Set<Integer> sortedSet = new TreeSet<>();
        for(int i:a)sortedSet.add(i);
        for(int i:b)sortedSet.add(i);
        
        
        // Copy TreeSet to ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(sortedSet);
        
        return arrayList;
    }


    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int n1 = a.length, n2 = b.length;
        int i = 0, j = 0;
        ArrayList<Integer> arr = new ArrayList<>();   
        
        while(i!= n1 && j!= n2){
            if(a[i] < b[j] ){       //if a's element is smaller
                arr.add(a[i]);
                i++;
            }
            else if(a[i] > b[j] ){  //if b's element is smaller
                arr.add(b[j]);
                j++;
            }
            else{                   //if both same
                arr.add(a[i]);
                i++;j++;
            }
        }
        
        //remaining element
        if(i!=n1){
            for(int i1 = i; i1 <  n1; i1++)arr.add(a[i1]);
        }
        if(j!=n2){
            for(int j1 = j; j1 <  n2; j1++)arr.add(b[j1]);
        }
        
        return arr;
        
    }
}
