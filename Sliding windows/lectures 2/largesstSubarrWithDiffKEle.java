import java.util.*;

public class largesstSubarrWithDiffKEle {
     public static int longestSubarrayAtMostKDistinct(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = 0;
        int ans = 0;

        Map<Integer, Integer> countMap = new HashMap<>();

        while (right < n) {
            //inc right pointer element one by one in map
            countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);

            // shrink window if more than k distinct
            while (countMap.size() > k) {
                countMap.put(arr[left], countMap.get(arr[left]) - 1);
                if (countMap.get(arr[left]) == 0) {
                    countMap.remove(arr[left]);
                }
                left++;
            }

            //else veify length at every right inceament 
            ans = Math.max(ans, right - left + 1);
            right++;        //inc right pointer one by one
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,2,2,4,4,5,5,1,1,3,3};
        int k = 3;

        System.out.println("input: " + Arrays.toString(arr));
        System.out.println("k = " + k);
        System.out.println("longest window length = " + engine(arr, k));
    }

    public static int engine(int[] arr, int k) {
        //this soln for exact k elements ..
        //but original is ask for at most k 
        //soln by me
        //tc is O(n)
        //efficient for clustered/repeated elements hacing array with must have k elements
        //as it expand and dec clusters(similar element blocks) by clusters

        int n = arr.length;
        int front = 0, back = 0;
        int ans = 0;

        Map<Integer, Integer> hm = new HashMap<>();

        while (front < n) {

            // grab contiguous block
            int curr = front;
            while (curr < n && arr[curr] == arr[front]) curr++;
            int blockSize = curr - front;
            hm.put(arr[front], hm.getOrDefault(arr[front], 0) + blockSize);
            front = curr;

            // check window size
            if (hm.size() == k) {
                ans = Math.max(ans, front - back);
            }

            // shrink when too many distincts
            while (hm.size() > k) {
                int iter = back;
                int val = arr[back];

                // remove the entire block of same element
                while (iter < front && arr[iter] == val) {
                    hm.put(val, hm.get(val) - 1);
                    iter++;
                }

                if (hm.get(val) <= 0) hm.remove(val);
                back = iter;
            }
        }

        return ans;
    }

    
}
