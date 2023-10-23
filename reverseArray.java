public class reverseArray {
    public static int[] reverseArray1(int n, int []nums) {
        // Write your code here.
        for (int i = 0; i < n/2; i++) {

            int temp = nums[i];
            nums[i]= nums[n-1-i];
            nums[n-1-i] = temp;
        }

        return nums;
        
    }
    public static int[] reverseArray2(int i,int n, int []nums) {
        // Write your code here.
        if(i>=n)
            return nums;

        
        int temp = nums[i];
        nums[i]= nums[n-1];
        nums[n-1] = temp;

        return reverseArray2(i+1,n-1,nums);
        
        
    } 
    public static int[] reverseArray3(int n, int []nums) {
        if(n==-1) return nums;

        reverseArray3(n-1, nums);

        if(n<=(nums.length/2)-1){
            int temp = nums[n];
            nums[n] = nums[(nums.length)-n-1];
            nums[(nums.length)-n-1] = temp;
        } 

        return nums;
    }
    public static int[] reverseArray3_2(int n, int []nums) {

        if(n < nums.length/2+1) return nums;

            int temp = nums[n-1];
            nums[n-1] = nums[(nums.length)-n];
            nums[(nums.length)-n] = temp; 

        return reverseArray3_2(n-1,nums);
    }
    public static int[] reverseArray4(int n, int []nums) {
        if(n > nums.length/2) return nums;

            int temp = nums[n];
            nums[n] = nums[(nums.length)-n-1];
            nums[(nums.length)-n-1] = temp;

        reverseArray3(n-1, nums);


        return nums;
    }
    public static void main(String[] args) {
        int[] arr = {5,7,8,9,0,1,7,6};
        // int n = 5;
        // int[] arr2 = reverseArray1(n, arr);
        // int[] arr3 = reverseArray2(0,arr.length, arr);
        // int[] arr3 = reverseArray3(arr.length, arr);
        // int[] arr4 = reverseArray4(0, arr);
        int[] arr4 = reverseArray3_2(arr.length, arr);
        for (int i : arr4) {
            System.out.println(i);
        }
    }
}
