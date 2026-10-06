class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); // Sort intervals by end time

        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            //prev[ ,x] is not smaller or equal to start of the current interval [y,] then  ctnt++
            if (intervals[i-1][1] > intervals[i][0]) {
                count++; // Overlapping interval found, increment count
                intervals[i - 1] = intervals[i]; // Update the previous interval to the current one
            }
        }
        return count;
    }

    public void sort(int[][] intervals, Comparator<int[]> comparator) {
        Arrays.sort(intervals, comparator);
    }
}

public class nonOverlapingIntervals {
    
}
