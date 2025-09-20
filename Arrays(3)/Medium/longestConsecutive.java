import java.util.HashSet;
import java.util.TreeSet;

public class longestConsecutive {
    public static void longestConsecutive0(int[] arr) {     //O(n*n)

        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int len = 1;

            while (linearSearch(arr, curr+1)) {
                len++;
                curr++;
            }
            maxLen = Math.max(maxLen, len);
        }
        System.out.println(maxLen);
        
    }
    
    public static void longestConsecutive1(int[] nums) {    //O(n * log n  + n)   -> O(n log n)
        TreeSet<Integer> set = new TreeSet<>();         //treeset sorts and avois duplicates
        
        for(int i:nums)set.add(i);      // n * log n
        
        int prev = 0;
        int cnt = 0;
        int ans = 0 ;
        for(int i: set){                        //n
            if(i == (prev+1)){
                cnt++;
                prev = i;
            }else{
                cnt = 1;
                prev = i;
            }    
            ans = Math.max(ans, cnt);
        }
        
        System.out.println(ans);
        
    }

    public static void longestConsecutive2(int[] nums) {    //O(N^2 + n) -> O(N*N)
        HashSet<Integer> set = new HashSet<>();         //it search element efficiently , mostly in O(1)
        for (int num : nums) {                      //n
            set.add(num);
        }
        
        int ans = 0 ;
        for(int i: set){                            //O(n*n)
            boolean flag = true;
            int cnt =1;
            
            do{
                i++;
                if(set.contains(i)){                //best o(1) worst o(n)
                    cnt++;
                }
                else{
                    flag = false;
                }
            }while(flag);
            
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
    
    public static void longestConsecutive3(int[] nums) {        //n
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;

        for (int num : nums) {
            if (!set.contains(num)) continue;

            int cnt = 1;
            set.remove(num);

            int next = num + 1;
            while (set.contains(next)) {
                set.remove(next);
                cnt++;
                next++;
            }

            int prev = num - 1;
            while (set.contains(prev)) {
                set.remove(prev);
                cnt++;
                prev--;
            }

            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
    
    public static void longestConsecutiveOptimal(int[] nums) {      //striver approach : O(n + 2n) - > O(3n) 
        //only search elemnt if there is no lessere element available in array
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);      //n
    
        int longest = 0;
    
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int cnt = 1;
    
                while (set.contains(currentNum + 1)) {              //2n
                    currentNum++;
                    cnt++;
                }
    
                longest = Math.max(longest, cnt);
            }
        }
    
        System.out.println(longest);
    }
    
    public static void main(String[] args) {
              longestConsecutive0(new int[]{100, 4, 200, 1, 3, 2});
              longestConsecutive1(new int[]{100, 4, 200, 1, 3, 2});
              longestConsecutive2(new int[]{100, 4, 200, 1, 3, 2});
              longestConsecutive3(new int[]{100, 4, 200, 1, 3, 2});
        longestConsecutiveOptimal(new int[]{100, 4, 200, 1, 3, 2});
    }

    public static boolean linearSearch(int[] arr, int key) {
        for (int num : arr) if (num == key) return true;
        return false;
    }
    
}
