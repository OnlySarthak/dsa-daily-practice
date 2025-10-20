public class singleEle {
    public int singleNonDuplicate(int[] nums) {
        // bruteforce | O(n)

        int ans = 0;

        for (int i : nums) {
            ans ^= i;
        }

        return ans;
    }

    public int singleNonDuplicate2(int[] nums) {

        // >bruteforce | <O(n)

        for (int i = 0; i < nums.length - 2; i += 2) {
            if (nums[i] != nums[i + 1])
                return nums[i];
        }

        return nums[nums.length - 1];
    }

    public int singleNonDuplicate3(int[] nums) {
        // standard soln | O(log n) |
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (m % 2 == 1)
                m--; // make mid even

            if (nums[m] == nums[m + 1])
                l = m + 2; // go right
            else
                r = m; // go left
        }

        return nums[l];
    }

}
