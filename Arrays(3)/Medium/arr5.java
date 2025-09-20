public class arr5 {

    public static int[] rearrangeArrayM(int[] arr) {
        //my solution by modify array without using additional array memory space
        int n = arr.length, i = 0;
    
        while (i < n) {
            // Find the next positive element
            for (int j = i; j < n; j++) {
                if (arr[j] >= 0) {
                    int temp = arr[j];
                    for (int k = j; k > i; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[i] = temp;
                    break;
                }
            }
    
            i++;
    
            // Find the next negative element
            for (int j = i; j < n; j++) {
                if (arr[j] < 0) {
                    int temp = arr[j];
                    for (int k = j; k > i; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[i] = temp;
                    break;
                }
            }
    
            i++;
        }
    
        return arr;
    }

    public static int[] rearrangeArrayM2(int[] arr) {
        //my solution V1
        int n = arr.length, i = 0;
        int[] res = new int[n];
        int pos = 0, neg = 0;
    
        while(i < n){
            while(arr[pos] < 0)pos++;
            res[i] = arr[pos];
            pos++;
    
            i++;
    
            while(arr[neg] >= 0)neg++;
            res[i] = arr[neg];
            neg++;
    
            i++;
        }
        
    
        return res;
    }

    public static int[] rearrangeArrayM3(int[] arr) {
        //my solution V2 100% beat
        int n = arr.length, i = 0;
        int[] res = new int[n];
        int pos = 0, neg = 1;
    
        while(i < n){
            if(arr[i]>=0){  //if +ve 
                res[pos] = arr[i];
                pos += 2;
            }
            else if(arr[i]<0){  //if -ve 
                res[neg] = arr[i];
                neg += 2;
            }
            i++;
        }
        
    
        return res;
    }
    
}
