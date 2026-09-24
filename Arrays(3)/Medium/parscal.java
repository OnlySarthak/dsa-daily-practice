public class parscal{
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.findNThParscal(4, 2));
        // Output: 6
    }
}
class Solution1 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans = new ArrayList<Integer>();   
        for(int i = 0; i<=rowIndex; i++){
            ans.add(findNThParscal(rowIndex, i));
        }
        return ans;
    }

    public int findNThParscal(int row, int col){
        if(row==0  || row==1 || col==0 || col==row ) return 1;
        return findNThParscal(row-1, col-1) + findNThParscal(row-1, col);
    }
}

class Solution2 { //ncr 
    public int findNThParscal(int row, int col){
        if(row==0  || row==1 || col==0 || col==row ) return 1;
        int res = 1;
        for(int i=0; i<col; i++){
            res = res * (row-i);
            res = res / (i+1);
        }
        return res;
    }
}

