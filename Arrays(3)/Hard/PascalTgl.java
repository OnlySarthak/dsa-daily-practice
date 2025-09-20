import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PascalTgl {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outerList = new ArrayList<>();
        int i = 2;

        outerList.add(Arrays.asList(1)); // first row: [1]
        outerList.add(Arrays.asList(1,1)); // Second row: [1]

        while(i < numRows){
            List<Integer> innerList = new ArrayList<>();
            innerList.add(1);

            for(int j = 0; j<i-1 ; j++){
                int temp = (outerList.get(i-1).get(j)) + (outerList.get(i-1).get(j+1));
                innerList.add(temp);
            }

            innerList.add(1);
                
            outerList.add(innerList);
            i++;
        }

        return outerList;
    }

    //efficient
    public static void main(String[] args) {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(findNth(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int fact(int n) {
        int ans = 1;
        while(n > 0) {
            ans *= n--;
        }
        return ans;
    }

    public static int findNth(int r, int c) {
        // Calculate binomial coefficient C(r, c)
        return fact(r) / (fact(c) * fact(r - c));
    }

}
