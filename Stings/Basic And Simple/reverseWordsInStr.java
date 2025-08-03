public class reverseWordsInStr {
    public static void main(String[] args){
        System.out.println(reverseWords("Hellow reels"));
    }
    public static String reverseWords(String str) {
        StringBuilder temp = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        boolean flag = false;
        str = str.trim();
        
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                flag = true;
            }else { //if char , append pending (temp)word to ans, and collect current char 
                if(flag){
                    ans.insert(0, (" "+temp));
                    flag = false;
                    temp.setLength(0);
                }
                temp.append(str.charAt(i));
            }
        }
        ans.insert(0, (temp));
        return ans.toString();
    }
}
