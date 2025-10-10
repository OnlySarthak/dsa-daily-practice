package Greedy Algorithms.medium and hard problem;

public class jump {
    private boolean jumpFrom(int[] arr, int i) {    //extream brutforce | initialy i must 0
        if (i >= arr.length - 1) return true; // reached or passed last index

        for (int j = i + 1; j <= i + arr[i]; j++) {
            if (j < arr.length && jumpFrom(arr, j)) {
                return true;
            }
        }

        return false; // no path from this position
    }

    public boolean jumpfrom2(int[] arr) {       //from me, brute force
        int n = arr.length;
        if (n == 1) return true; // single element, already at the end

        int bigJmp = -1;
        int ind = -1;

        int iter = 0;
        int i = 0;
        int j = i + arr[iter];

        while (j < n - 1) { // while last index not reachable
            bigJmp = -1;
            ind = -1;

            // loop from i+1 to j (all reachable positions)
            for (int k = i + 1; k <= j; k++) {
                if (k >= n) break; // avoid out of bounds
                int reach = k + arr[k]; // how far we can reach from k
                if (reach > bigJmp) {
                    bigJmp = reach;
                    ind = k;
                }
            }

            if (ind == -1) return false; // stuck, can’t move further

            iter = ind;
            i = ind;
            j = i + arr[ind];
        }

        return true; // last index is reachable
    }
}
