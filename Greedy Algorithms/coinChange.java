import java.util.ArrayList;

public class coinChange {
    public static void main(String[] args) {        //my and std soln
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int need = 121;
        ArrayList<Integer> ans = new ArrayList<>();

        while (need > 0) {
            // binary search for largest coin <= need
            int coin = coins[lowerBound(coins, need)];

            // calculate no. of that coin usefull
            int temp = need / coin;

            // add coins in ans array
            for (int j = 0; j < temp; j++) {
                ans.add(coin);
            }

            // update need
            need -= temp * coin;
        }

        System.out.println("Coins used: " + ans);
    }

    // finds largest index where coins[idx] <= value
    private static int lowerBound(int[] coins, int value) {
        int l = 0, r = coins.length - 1, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (coins[mid] <= value) {
                ans = mid; // candidate
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    static void findMin(int V) {        //striver soln
        ArrayList<Integer> ans = new ArrayList<>();
        int deno[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int n = deno.length;

        for (int i = n - 1; i >= 0; i--) {
            while (V >= deno[i]) {
                V -= deno[i];
                ans.add(deno[i]);
            }
        }

        System.out.println("Coins used: " + ans);
    }

}