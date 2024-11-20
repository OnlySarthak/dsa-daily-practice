import java.util.ArrayList;

public class arr7 {
    //find intersection of two sorted array

    public static ArrayList<Integer> findIntersection(int[] a, int[] b) {
        // brute forse solution;//from gpt

        ArrayList<Integer> intersection = new ArrayList<>();
        boolean[] visited = new boolean[b.length]; // To mark used elements in `b`

        // Iterate through each element in array `a`
        for (int i = 0; i < a.length; i++) {
            // Check if the current element of `a` exists in `b`
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j] && !visited[j]) {
                    // Add to intersection and mark `b[j]` as visited
                    intersection.add(a[i]);
                    visited[j] = true;
                    break; // Break to avoid counting duplicates in `b`
                }
            }
        }

        return intersection;
    }

    public static ArrayList<Integer> findIntersection2(int[] a, int[] b) {
        //optimal
        ArrayList<Integer> intersection = new ArrayList<>();
        int an = a.length, bn = b.length;

        if(an>bn){
            int i = 0;
            int j = 0;
            while (i<an-1) {
                if(a[i]==b[j]){
                    intersection.add(a[i]);
                    i++;j++;
                    continue;
                }

                i++;
                if(j<an-1 && b[j] < a[i])j++;
            }
        }
        else {
            int i = 0; // Pointer for array `a`
            int j = 0; // Pointer for array `b`
        
            while (j < bn && i < an) {
                if (b[j] == a[i]) {
                    intersection.add(b[j]); // Add matching element
                    i++;
                    j++;
                    continue;
                }
        
                j++; // Move in `b`
        
                // Move in `a` only if `a[i]` is less than `b[j]` and still in bounds
                if (i < an - 1 && a[i] < b[j]) i++;
            }
        }
        
        return intersection;
    }

    public static void main(String[] args) {
        int[] b = {1, 2, 2, 3, 3, 4, 5, 6};
        int[] a = {2, 2, 3, 5, 6, 6, 7};

        ArrayList<Integer> result = findIntersection2(a, b);
        System.out.println("Intersection: " + result);
    }
}
