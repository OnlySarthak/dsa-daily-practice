import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;

        char[][] charGroups = new char[digits.length()][];
        for (int k = 0; k < digits.length(); k++) {
            charGroups[k] = MAP[digits.charAt(k) - '0'].toCharArray();
        }

        StringBuilder current = new StringBuilder();
        generator(0, charGroups, current, ans);

        return ans;
    }

    private void generator(int i, char[][] charGroups, StringBuilder current, List<String> ans) {
        if (i == charGroups.length) {
            ans.add(current.toString()); // Only convert to String when adding to final result
            return;
        }

        for (char ch : charGroups[i]) {
            current.append(ch);                        // Choose
            generator(i + 1, charGroups, current, ans); // Explore
            current.deleteCharAt(current.length() - 1); // Backtrack (Undo)
        }
    }
}