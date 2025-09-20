import java.util.ArrayList;
import java.util.List;

class countInversions {
    public long numberOfInversions(int[] nums) {
        int n = nums.length;
        long cnt = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i: nums){
            int An = list.size();
            
            if(An==0 || list.get(An-1)<i)
                list.add(i);
            else if(list.get(An-1)>i){
                int temp_cnt=0;
                for (int j = An-1; j >= 0; j--) {
                    if(list.get(j) <= i){
                        break;
                    }
                    temp_cnt++;
                }
                if(temp_cnt==An)list.add(0,i);
                else list.add((An-temp_cnt),i);
                
                cnt += temp_cnt;
            }
        }

        return cnt;
    }
    
    public static void main(String[] a){
        countInversions sol = new countInversions();
System.out.println(sol.numberOfInversions(new int[]{1, 2, 3, 4, 5})); // 0
System.out.println(sol.numberOfInversions(new int[]{5, 4, 3, 2, 1})); // 10
System.out.println(sol.numberOfInversions(new int[]{2, 4, 1, 3, 5})); // 3
System.out.println(sol.numberOfInversions(new int[]{3, 3, 3, 3}));    // 0
System.out.println(sol.numberOfInversions(new int[]{1, 3, 2, 4, 0})); // 4
System.out.println(sol.numberOfInversions(new int[]{1}));             // 0
System.out.println(sol.numberOfInversions(new int[]{1, 2}));          // 0
System.out.println(sol.numberOfInversions(new int[]{2, 1}));          // 1

    }
}
