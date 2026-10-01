import java.util.HashMap;

public class highLowEstFreqElem {
    public static void engine(int[] arr,int max_possibility_elem){
        //by array hashing 
        int[] counter = new int[max_possibility_elem];
        int max =0, min =arr[0];

        //pre computation
        for (int i : arr) {
            counter[i]++;

            // max find
            if(counter[i] > counter[max])max = i;
            if(counter[i] < counter[min])min = i;
        }

        System.out.println("Maximum frequency element is : "+max);
        System.out.println("Minimum frequency element is : "+min);
    } 
    
    
    
    public static void getFrequencies(int []arr){
        HashMap<Integer, Integer> Hm = new HashMap<>(20);
        int maxCount = 0;
        int minCount = 50;
        int max = 0;
        int min = 0;

        for (int i : arr) {
            //counting array
            Hm.put(i, Hm.getOrDefault(i, 0) + 1);

            // find max counting
            if (Hm.get(i) >= maxCount){
                maxCount = Hm.get(i);
                max = i;
            } 

            //find min counting
            if (Hm.get(i) <= minCount){
                minCount = Hm.get(i);
                min = i;
            } 
        }   

        int M = 0, m = 0;
        for (int key : Hm.keySet()) {
            if(Hm.get(key)==maxCount)M++;
            if(Hm.get(key)==minCount)m++;
            if (Hm.get(key) == maxCount && key > max){   max = key; M++;
            // System.out.println("k="+key);
            }
        
            if (Hm.get(key) == minCount && key < min){  min = key;  m++;
            // System.out.println("k="+key);
            }
        }
        
        //final logic
        int[] result = {maxCount,minCount};
        if(M >0){
            result[0] =  max;
        }
        if (m>0) {
            result[1] = min;
        }

        for (int i : result) {
            System.out.println(i);
        }

        // System.out.println(Hm);
        // System.out.println("MaxCount = "+maxCount+"   MinCount="+minCount);
        // System.out.println("max = "+max+"   Min="+min);
        // System.out.println("M="+M+"  m="+m);
    } //something natak 
    

    public static void main(String[] args) {
        // int[] array = {10,5,10,15,10,5};
        int[] array = {1, 2 , 1 ,1 ,4,2,2,2,5,6,3};
        // int[] array = {1,2,2,3,1,1,4,9,4,4};
        // int[] a =(getFrequencies(array));
        getFrequencies(array);
        // for (int i = 0; i < a.length; i++) {
        //     System.out.println(a[i]);
        // }
    }
}
