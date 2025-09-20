// package sorting and rotation;
// class Solution {
//     public boolean check(int[] nums) {
//         int large = findMax(nums,nums.length);
        
//         if(both(nums,nums.length))return true;
//         else if(ascending(nums, large))return true;
//         else if(desending(nums, large))return true;
        
//         return false;
//     }

//     static boolean both(int[] arr,int n){
//         boolean asc = true, des = true;
//         for(int i = 0; i<n-1;i++){
//             if(arr[i] < arr[i+1])des = false;
//             if(arr[i] > arr[i+1])asc = false;
//         }
//         return asc||des;
//     }
    
//     static boolean ascending(int[] arr, int large){
//         boolean flag = true;
//         for(int i = 0; i<large; i++){
//             if(arr[i] <= arr[i+1]){}
//             else flag = false;
//         }
//         for(int i = large+1; i < arr.length-1; i++){
//             if(arr[i] <= arr[i+1]){}
//             else flag = false;
//         }
//         return flag;
//     }
//     static boolean desending(int[] arr, int large){
//         boolean flag = true;
//         for(int i = 0; i<large-1; i++){
//             if(arr[i] >= arr[i+1]){}
//             else flag = false;
//         }
//         for(int i = large; i < arr.length-1; i++){
//             if(arr[i] >= arr[i+1]){}
//             else flag = false;
//         }
//         return flag;
//     }
//     static int findMax(int[] arr,int n){
//         int large = arr[0],pos = 0;
//         for(int i=1 ; i<n ; i++){
//             if(arr[i] > large){
//                 large = arr[i];
//                 pos = i;
//             }
//         }
//         return pos;
//     }
// }
// public class old {
    
// }

//new sol
/*
 * Wrong Answer
105 / 108 testcases passed
Input
nums =
[10,1,4,5,10]

Use Testcase
Output
false
Expected
true
 */
class Solution {
    public boolean check(int[] nums) {
        int large = findMax(nums,nums.length);
        
        if(ascending0(nums,nums.length)){
          return true; 
        }else{
             if(ascending(nums, large))return true;
        }
        
        return false;
    }

    static boolean ascending0(int[] arr,int n){
        for(int i = 0; i<n-1;i++){
            if(arr[i] > arr[i+1])return false;
        }
        return true;
    }
    
    static boolean ascending(int[] arr, int large){
        for(int i = 0; i<large; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        for(int i = large+1; i < arr.length-1; i++){
            if(arr[i] > arr[i+1])
            {
                return false;
            }
        }
        if(arr[0] < arr[(arr.length)-1])return false;
        return true;
    }
    static int findMax(int[] arr,int n){
        int large = arr[0],pos = 0;
        for(int i=1 ; i<n ; i++){
            if(arr[i] >= large){
                large = arr[i];
                pos = i;
            }
        }
        return pos;
    }
}
