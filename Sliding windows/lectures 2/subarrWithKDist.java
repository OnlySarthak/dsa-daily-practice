public class subarrWithKDist {
    public int subarraysWithKDistinct(int[] arr, int k) {
        int n = arr.length;
        int front = -1;
        int back = 0;
        int ans = 0;
        Map<Integer, Integer> hm = new HashMap<>();

        while (front < n - 1) { // front is initially -1

            if (hm.size() == k) {   
                ans++;
                // move back pointer and shrink
                hm.put(arr[back], hm.get(arr[back]) - 1);
                if (hm.get(arr[back]) == 0) {
                    hm.remove(arr[back]);
                }
                back++;
            } 
            else if (hm.size() > k) {       //if elements are more 
                hm.put(arr[back], hm.get(arr[back]) - 1);
                if (hm.get(arr[back]) == 0) {
                    hm.remove(arr[back]);
                }
                back++;
            } 
            else {                           // hm.size() < k
                front++;
                if (front < n) { // prevent out of bounds
                    hm.put(arr[front], hm.getOrDefault(arr[front], 0) + 1);
                }
            }
        }

        return ans;
    }
}