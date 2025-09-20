public class biggestOdd {
    public static void main(String[] args){
        System.out.println(largestOddNumber("35742"));
    }
    public static String largestOddNumber(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if ((str.charAt(i) - '0') % 2 == 1) {
                return str.substring(0, i + 1);
            }
        }
        return ""; // No odd digit found
    }
}