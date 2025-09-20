class arr4{
       //shift array by d places 
       public void rotate(int[] arr, int k) {
            //brute force (right shift)         using temparary array

            int[] temp = new int[k];
            int tempInter =0, n = arr.length;

            //preporceesing
            for(int i = ( n - k) ; i < n ; i++ ){        
                temp[tempInter++] = arr[i];
            }
       
            //proccessing
            for(int i = (n-1) ; i > (k-1) ; i--) {
                arr[i] = arr[(i-k)];   
            }

           // postproccesing
           System.arraycopy(temp, 0, arr, 0, k);
 
       }

    public void rotate2(int[] arr, int k){
        //optimize
        k=k%arr.length;

        reverse(arr, 0, (arr.length-1));        //0to n-1
        reverse(arr, 0, (k-1));                 //0 to k-1
        reverse(arr, k, (arr.length -1));           // k t0 n-1
   }

   public void reverse(int[] arr,int start,int end){
        while(start<=end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
   }
}