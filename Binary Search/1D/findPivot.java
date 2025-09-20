public class findPivot {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;

        if (n == 2) {
            return (nums[0] < nums[1] ? nums[0] : nums[1]);
        }

        // find pivot (index of smallest element)
        while (l < h) {
            int mid = (l + h) / 2;

            // if nums[mid] > nums[h], it means the smallest element is in the right half
            if (nums[mid] > nums[h]) {
                l = mid + 1;
                // ✅ we skip mid because mid cannot be the smallest (right side is unsorted)
            } else {
                h = mid;
                // ✅ we keep mid because it might be the smallest or the smallest lies to the
                // left
            }
        }

        return nums[l];
    }
}
