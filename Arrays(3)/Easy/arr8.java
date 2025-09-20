public class arr8 {
    //find missing no. 


    public static int findMissingNumber(int[] arr, int n) {
        //brute forse

        // Iterate through numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            // Check if the number exists in the array
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            // If the number is not found, it is the missing number
            if (!found) {
                return i;
            }
        }
        return -1; // Return -1 if no missing number is found (edge case)
    }

    public static int findMissingNumber2(int[] arr, int n){
        //better solution
         // Create a hash array to mark the presence of numbers
         boolean[] hash = new boolean[n + 1]; // Size n+1 to handle 1-based index
        
         // Mark numbers that are present in the input array
         for (int num : arr) {
             hash[num] = true;
         }
         
         // Find the first number in the range [1, n] that is not marked
         for (int i = 1; i <= n; i++) {
             if (!hash[i]) {
                 return i;
             }
         }
         
         return -1; 
    }

    public int findMissingNumber3(int[] nums) {
       //optimal
        int n = nums.length;
        int expSum = (n*(n+1)/2);
        int actuSum = 0;


        for(int i : nums) {
            actuSum += i;
        }

        return (expSum-actuSum);
    }

    public int findMissingNumber4(int[] nums, int n) {
        //optimal ++
        int xorArray = 0; // XOR of all array elements
        int xorFull = 0;  // XOR of all numbers from 1 to n

        // XOR all numbers from 1 to n
        for (int i = 0; i < n; i++) {
            xorArray ^= nums[i];
            xorFull ^= (i+1);
        }

        // XOR of the above two gives the missing number
        return xorArray ^ xorFull;
    }


    public static void main(String[] args) {
        int[] arr= {6,4,2,3,7,0,1};

        arr8 a = new arr8();
        System.out.println(a.findMissingNumber4(arr, arr.length));
    }


    //find consecutive one
    public int findMaxConsecutiveOnes(int[] nums) {     //optimal needed only
        int count = 0;
        int temp = 0;
        for(int i: nums){
            if(i==1){
                count++;
                if(count > temp)temp = count;
            }
            else{
                count = 0;
            }
        }

        return temp;
    }
}
