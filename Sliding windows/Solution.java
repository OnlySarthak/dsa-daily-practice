import java.util.HashMap;

public class Solution {
    public static int twoCommonElesFrqSum(int[] fruits) {
        HashMap<Integer, Integer> hm = new HashMap<>(2);
        int iter = 0, bucketCurr = fruits[0], bucketLast = -1, n = fruits.length;
        
        //precomputation
        hm.put(bucketCurr, 0);
        hm.put(bucketLast, 0);

        while(iter<n){
            if(fruits[iter] == bucketCurr || hm.get(bucketCurr)==1){                    //if i is same fruit in Current bucket then inc
                hm.put(bucketCurr , hm.get(bucketCurr)+1);
            }else{      
                if(fruits[iter]==bucketLast){
                    int temp = bucketLast;
                    bucketLast = bucketCurr;
                    bucketCurr = temp;
                }else{
                        int temp = bucketLast;
                        bucketLast = bucketCurr;
                        bucketCurr = temp;
                    bucketCurr = fruits[iter];
                    hm.put(bucketCurr, 1);
                }
            }
           iter++;
        }

        return (hm.get(bucketCurr)+hm.get(bucketLast));
    }

    public int consecetiveOnes3(int[] nums, int k) {
        // smart sliding windows approach | n
        int n = nums.length;
        int left = 0, right = 0;
        int zeros = 0;
        int maxLen = 0;

        while (right < n) {
            if (nums[right] == 0) {
                zeros++;
            }

            // if window is invalid (too many zeros),
            // move left forward by one (not while loop!)
            if (zeros > k) {
                if (nums[left] == 0) {
                    zeros--; // reclaim a bridge
                }
                left++; // shrink window by exactly 1
            }

            // update maxlen ( curr vs old)
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }

    public int consecetiveOnes2(int[] nums, int k) {
        // sliding windows approach | 2n

        int n = nums.length;
        int left = 0, right = 0;
        int zeros = 0;
        int maxLen = 0;

        while (right < n) {
            if (nums[right] == 0) {
                zeros++;
            }

            // shrink from the left side if 0 is more than limit
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--; // reclaim a bridge
                }
                left++;
            }

            // update maxlen ( curr vs old)
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }

    public int consecetiveOnes(int[] nums, int k) {
        // bruteforce | n^2
        int maxlen = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0)
                    zeros++;

                if (zeros <= k) {
                    int tempLen = j - i + 1;
                    maxlen = Math.max(maxlen, tempLen);
                } else {
                    break;
                }
            }
        }

        return maxlen;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0; // left pointer
        int maxLen = 0; // max length of substring
        HashMap<Character, Integer> map = new HashMap<>(); // stores last index of character

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1; // move left pointer
            }

            maxLen = Math.max(maxLen, right - left + 1); // update max length
            map.put(c, right); // update last seen index
        }

        return maxLen;
    }

    // For quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,2,2};
        // int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        int ans = totalFruit(arr);
        System.out.println(ans); 
    }
}
