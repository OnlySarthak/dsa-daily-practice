public class findFirstLastOcc {
    public int countOcc(int[] nums, int target) {
        int firstOcc = engine(nums, target, 0);
        if (firstOcc == -1)
            return 0; // target not found

        int lastOcc = engine(nums, target, 1);
        return (lastOcc - firstOcc) + 1;
    }

    public int[] searchRange(int[] nums, int target) {
        int firstOcc = -1, lastOcc = -1;

        // flag tells what to find
        firstOcc = engine(nums, target, 0);

        // if firtsOcc not occured
        if (firstOcc == -1)
            return new int[] { -1, -1 };

        lastOcc = firstOcc;
        lastOcc = engine(nums, target, 1);

        return new int[] { firstOcc, lastOcc };
    }

    public int engine(int[] nums, int target, int flag) {
        int high = nums.length - 1, ans = -1, low = 0;

        while (low <= high) {
            int mid = (high + low) / 2;

            // if element occured, go to left
            if (nums[mid] == target) {
                ans = mid;
                // if searching first occ
                if (flag == 0)
                    high = mid - 1;
                else
                    low = mid + 1; // else
            } // if element greater, go to left
            else if (nums[mid] > target) {
                high = mid - 1;
            } // if element smaller, go to right
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
