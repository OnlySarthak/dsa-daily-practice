class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { // bill == 20
                // Greedy choice: prefer using 10 + 5 over 5 + 5 + 5
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}


public class lemonade {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] bills = {5,5,5,10,20};
        System.out.println(sol.lemonadeChange(bills));      //true
    }   
}
