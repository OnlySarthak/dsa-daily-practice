public class cntSubarrWithSumK {
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

