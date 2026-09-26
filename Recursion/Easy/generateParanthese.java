
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> comb = new ArrayList<>();
        generator("", 0, 0, n, comb);
        return comb;
    }

    // Pass 'comb' down to collect results instead of creating new lists at every step
    public void generator(String st, int i, int j, int n, List<String> comb) { // i = '(', j = ')'
        // Base case: length reached 2 * n
        if (st.length() == n * 2) {
            comb.add(st);
            return;
        }

        // Add '(' if counter is under n
        if (i < n) {
            generator(st + "(", i + 1, j, n, comb);
        }

        // Add ')' if counter j is less than i
        if (j < i) {
            generator(st + ")", i, j + 1, n, comb);
        }
    }
}

public class generateParanthese{

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(1));
    }
}

class SolutionOriginal{
    // Unnecessary List Allocations: Using new ArrayList<String>(){{add(st);}} 
    // and calling addAll() at every recursive branch creates excessive temporary 
    // ArrayList objects, which slows down execution and uses extra memory.
    public List<String> generateParenthesis(int n) {
        int i = 0, j = 0;
        String st = "";

        return generator(st, i , j , n);        
    }
    public List<String> generator(String st, int i,int j,int n){        //i is (  and j is ) counter 
        if(st.length() >= (n*2) ) return new ArrayList<String>(){{add(st);}};
        List<String> Comb = new ArrayList<>(); 
        
        //for adding ( check if their counter is under n
        if(i < n){
            Comb.addAll(generator((st+"("), (i+1), j ,n));   
        }
        //for adding ) , check is j < ( in current combination
        if(j < i){
            Comb.addAll(generator((st+")"), i, (j+1), n));
        }

        return Comb;
    }
}