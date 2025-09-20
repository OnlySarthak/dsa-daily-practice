public class IntegerAndBinary {
    public static void main(String[] args) {
        int a = BinaryToInt0(IntToBinary0(14));
        System.out.println("a = " + a);          // 14
    }

    private static String IntToBinary0(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % 2);
            n /= 2;
        }
        return sb.toString();
    }

    private static int BinaryToInt0(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            ans += ((c - '0') * Math.pow(2, str.length() - i - 1));
        }
        return ans;
    }
}
