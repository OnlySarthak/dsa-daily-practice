package Arrays(3);

public class Arrays3_1 {
    //Second Largest Element in an Array …
    static int getSecondLarge(int[] arr){
        int large = arr[0], slarge = -1, n = arr.length
        for(int i = 0; i < n; i++){
            if(arr[i] > large){
                slarge = large;
                large = arr[i];
            }
            else if(arr[i]!=large && arr[i]>slarge){
                slarge=arr[i];
            }
        }
        return slarge;
    }
    static int getSecondSmall(int[] arr){
        int small = arr[0], sSmall = 2147483647, n = arr.length;
        for(int i = 0; i<n; i++){
            if(arr[i] < small){
                sSmall = small;
                small = arr[i];
            }
            else if(arr[i]!=small && arr[i]<sSmall){
                sSmall=arr[i];
            }
        }
        return sSmall;
    }

    //rotate right array by k times
    //previous (my) leetcode 37/38
    public void rotate2(int[] arr, int k) {
        int n = arr.length;
        for(int j = 0;j<k;j++){
            int temp = arr[n-1];
            for(int i=n-1;i > 0; i--)
                arr[i] = arr[i-1];
            arr[0] = temp;
        }
    }
    public void rotate(int[] arr, int k) {
        if(arr.length == 1){}
        else if(arr.length < 1000){
            rotate2(arr,k);
        }
        else{
            
        int n = arr.length ,t = (arr.length)-k;
        int[] temp = new int[k];
        for(int i=0;i<k;i++){
            temp[i] = arr[t++];
        }
        t= n-1-k;
        for(int i=n-1;i > k-1; i--){
            arr[i] = arr[t--];
        }
        for(int i = 0; i < k;i++){
            arr[i] = temp[i];
        }
        }
    }
    //after striver
    public void rotate(int[] arr, int k) {
        if(k==0)return;
        int n = arr.length;
        k = k%n;
        //main logic
        rotate2(arr,0,k-1);
        rotate2(arr,k,n-1);
        rotate2(arr,0,n-1);        
    }
    public void rotate2(int[] arr, int l, int r) {
        while(l<=r){
            int t = arr[r];
            arr[r] = arr[l];
            arr[l] = t;
            l++;
            r--;
        }
    }

    //place zeros to last
    //by me
    public void moveZeroes(int[] arr) {
        int n = (arr.length)-1;
        int l = 0,r =0;
        while(arr[l]!=0 && l!=n){
            l++;
        }
        if(l==n)return;
        // Write your code here
        r = l;
        while(r!=n || l!=n){
           while(arr[r]==0 && r!=n)r++;
           
           swap(arr,l,r);
           l++;
        }
    }
    //by striver
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int l = 0,r =0;

        //go to first 0 of array
        for(l = 0; l<n;l++){
            if(arr[l]==0)break;
        }
        
        // swap r to l if l found zerro
        for(r = l+1;r<n;r++){
            if(arr[r]!=0){
                swap(arr,l,r);
                l++;
            }
        }
    }

    static void swap(int[] arr,int A, int B){
            int t = arr[A];
            arr[A] = arr[B];
            arr[B] = t;
    }

    //merge two sorted array without dublicates
    //by me == striver
    public static List<Integer> sortedArray(int []a, int []b) {
        List<Integer> resultant = new ArrayList<Integer>();
        int ap=0, bp=0, an = a.length, bn = b.length;
        // Write your code here
        while(ap<an && bp<bn){
            if(a[ap] < b[bp]){
                if(ap == 0 ||a[ap]!=resultant.get(resultant.size()-1))
                    resultant.add(a[ap]);
                ap++;
            }
            else if(b[bp] < a[ap]){
                if(bp == 0 ||b[bp]!=resultant.get(resultant.size()-1))
                    resultant.add(b[bp]);
                bp++;
            }else if(a[ap]==b[bp]){
                resultant.add(a[ap]);
                ap++;bp++;
            }
        }

        while(ap<an){
            if(a[ap]!=resultant.get(resultant.size()-1))
                resultant.add(a[ap]);
            ap++;
        }
        while(bp<bn){
            if(b[bp]!=resultant.get(resultant.size()-1))
                resultant.add(b[bp]);
            bp++;
        }
        if (resultant.size() >= 2 && resultant.get(resultant.size() - 1).equals(resultant.get(resultant.size() - 2))) {
            resultant.remove(resultant.size() - 1);
        }

        return resultant;
    }
    


}
