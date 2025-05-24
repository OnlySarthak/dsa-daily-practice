import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class threeSum {
    //brute forse 
    public List<List<Integer>> threesum(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        
        for(int i=0; i < n-2; i++){
            for(int j=i+1 ; j<n-1 ; j++){
                for(int k=j+1; k<n; k++){
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);  // Sort this triplet
                        ans.add(triplet);
                    }
                }
            }
        }

        List<List<Integer>> ansF= new ArrayList<List<Integer>>(ans);
        
        return ansF;
    }

    //optimal
    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        
        HashSet<List<Integer>> ans = new HashSet<>();
        
        for(int i = 0; i < n-2; i++ ){
            HashSet<Integer> temp = new HashSet<>();
            for(int j = i+1; j <n; j++){
                int need = -(nums[i] + nums[j]);
                if(temp.contains(need)){
                    int[] temp2 = {nums[i], nums[j], need};
                        Arrays.sort(temp2);
                        ans.add(Arrays.asList(temp2[0], temp2[1], temp2[2]));
                }
                temp.add(nums[j]);
            }
        }
        
         List<List<Integer>> ret = new  ArrayList<>(ans);
         
        return ret;
    }

    //efficient
    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new  ArrayList<>();
        Arrays.sort(nums);
        
       for(int i=0; i < n; i++){
            //loop till last same element
            if(i>0 && nums[i-1] == nums[i])continue;
            int j = i+1 , k = n-1;

            while(j < k){
                int temp = nums[i]+nums[j]+nums[k];

                if(temp == 0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    //dec k to unique element & inc j to uniq ele
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    k--;
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    j++;
                }
                else if(temp > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        
        return ans;
    }
}
