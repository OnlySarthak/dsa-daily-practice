import java.util.ArrayList;
import java.util.List;

public class rotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        int n = s.length();
        char ch = s.charAt(0);

        // store all indices where goal has the same char
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (goal.charAt(i) == ch) {
                indices.add(i);
            }
        }

        // try all possible starting positions
        for (int j : indices) {
            //flag of each try
            boolean match = true;

            // compare cyclically
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != goal.charAt((j + i) % n)) {
                    match = false;
                    break;
                }
            }

            if (match) return true; // found a valid rotation
        }

        return false; // no rotation matched

    }
}
