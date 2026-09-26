import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =  new ArrayList<>();
        List<Integer> comb =  new ArrayList<>();

        generator(0, ans, comb, nums);

        return ans;
    }

    public void generator(int i, List<List<Integer>> ans, List<Integer> comb, int[] nums){
        //generate more combination without ith element
        if(i == nums.length){
            ans.add(new ArrayList<>(comb));
            return;
        }

        //generate more combination with ith element
        comb.add(nums[i]);
        generator((i+1), ans, comb , nums);
        comb.remove(comb.size() - 1);

        //generate more combination without ith element
        generator((i+1), ans, comb, nums);
    }
}

public class powerSet {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = s.subsets(nums);
        System.out.println(ans);
    }
}
