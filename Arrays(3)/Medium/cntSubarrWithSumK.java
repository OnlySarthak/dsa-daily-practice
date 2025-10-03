
import java.util.HashMap;

public class cntSubarrWithSumK {
    public static int subarraySum(int[] nums, int k) {
        // prefix aproach with hashmap of prefix:index

        // map to store prefixSum -> frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 

        int prefix = 0, count = 0;

        for (int i = 1; i<= nums.length ; i++) {
            prefix += nums[i];

            // check if there exists a prefix that makes current subarray sum = k
            if (map.containsKey(prefix - k)) {
                System.out.println("subarray found from index "+map.get(prefix - k) +" to " + i);
                count++;
            }

            // update current prefix in map
            map.put(prefix, i);
        }

        return count;
        //count of no. of substring with sum is k
    }

    public static int subarraySum2(int[] nums, int k) {
        // prefix aproach with hashmap of prefix:frequency

        // map to store prefixSum -> frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: prefix=0 occurs once

        int prefix = 0, count = 0;

        for (int num : nums) {
            prefix += num;

            // check if there exists a prefix that makes current subarray sum = k
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }

            // update current prefix in map
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }


    public static int longestSubarray(int[] arr, int target) {
        int n = arr.length;
        int l = 0, r = 0;
        int sum = 0;
        int maxLen = 0;

        while (r < n) {

            // shrink window if sum is greater
            while (sum > target && l <= r) {
                sum -= arr[l];
                l++;
            }

            // check if valid sum
            if (sum == target) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            // expand window
            r++;
            sum += arr[r];
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 1, 1, 1};
        int target = 5;

        System.out.println("Longest subarray length = " + longestSubarray(arr, target));
    }
}

