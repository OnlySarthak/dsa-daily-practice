import java.util.HashMap;

public class count_frequancy_elements {
    public static int[] cfe(int n, String str){
        //this function is used when all char in string is lowercase
        // 97-a to 122-z

        int[] st = new int[26];

        for(int i=0; i<n; i++) {
            st[str.charAt(i)-'a']++;
        }

        return st;

    }
    public static int[] cfe2(String str){
    // 97-a to 122-z

        int[] st = new int[26];

        for(int i=0; i<str.length(); i++) {
            st[str.charAt(i)-'a']++;
        }

        return st;

    }
    public static HashMap<Character,Integer> cfe3(String str){
    // Hashmap

        HashMap<Character,Integer> HM = new HashMap<>();

        for (char c : str.toCharArray()) {
            // HM.put(i,HM.getOrDefault(HM, 0)+1);
            // int count = HM.getOrDefault(c, 0);
            HM.put(c, HM.getOrDefault(c, 0) + 1);
        }

        return HM;

    }

    public static void main(String[] args) {
        String Str = "aabbcc";
        // char a = 'a';
        // int[] arr ={}

        // int[] arr= cfe(Str.length(), Str.toLowerCase());
        // int[] arr= cfe(Str.length(), Str.toLowerCase());
        HashMap<Character,Integer> HM2 = cfe3(Str.toLowerCase());
        System.out.println(HM2);

        // for(int i: HM2)
            // System.out.println(a++ + " = " + i);

    }
}
