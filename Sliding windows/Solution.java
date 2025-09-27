import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;  // left pointer
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
        String test = "abcabcbb";
        System.out.println(sol.lengthOfLongestSubstring(test)); // Output: 3
    }
}
