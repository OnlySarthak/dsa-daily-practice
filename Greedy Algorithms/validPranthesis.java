public class validPranthesis {

     // Recursive function to check if the parenthesis string is valid
    public boolean isValid(String s, int index, int open) {

        // If the number of open parentheses becomes negative, return false
        if (open < 0) return false;

        // If we've reached the end of the string, return true if all open brackets are closed
        if (index == s.length()) return open == 0;

        // Get the current character
        char c = s.charAt(index);

        // If it's an opening bracket '(', increase the count of open
        if (c == '(') {
            return isValid(s, index + 1, open + 1);
        }

        // If it's a closing bracket ')', decrease the count of open
        else if (c == ')') {
            return isValid(s, index + 1, open - 1);
        }

        // If it's '*', we try all 3 possibilities:
        // 1. Treat '*' as empty string
        // 2. Treat '*' as '('
        // 3. Treat '*' as ')'
        else {
            return isValid(s, index + 1, open) ||
                   isValid(s, index + 1, open + 1) ||
                   isValid(s, index + 1, open - 1);
        }
    }
}