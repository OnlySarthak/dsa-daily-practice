import java.util.ArrayList;
import java.util.HashSet;

public class setMatrixZeros {
    //soltions by me
     public void setZeroes(int[][] matrix) {        //brute force
        ArrayList<Integer> AL = new ArrayList<>();

        for(int i = 0;i < matrix.length ; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    AL.add(i);
                    AL.add(j);
                }
            }
        }
        
        int iter = 0;
        while(iter < AL.size()){
            //change in row 
            for(int r=0;r < matrix[AL.get(iter)].length; r++){
                matrix[AL.get(iter)][r] = 0;
            }
            iter++;
            
            //change in row 
            for(int r=0; r < matrix.length; r++){
                matrix[r][AL.get(iter)] = 0;
            }
            iter++;
        }
        
        //print 
        for(int i = 0;i < matrix.length ; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        
    }

    //optimezed
    public void setZeroes2(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();


        for(int i = 0;i < matrix.length ; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int r : rows){
             //change in row 
            for(int col=0; col < matrix[r].length ; col++){
                matrix[r][col] = 0;
            }
            
        }
        
         for(int c : cols){
             //change in col
            for(int row=0; row < matrix.length ; row++){
                matrix[row][c] = 0;
            }
        }
        
    }

    //strivers
    //optimal
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] rowFlag = new boolean[n]; // Marks if row i should be zeroed
        boolean[] colFlag = new boolean[m]; // Marks if column j should be zeroed

        // First pass: mark the rows and columns that contain zeroes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        // Second pass: zero out rows
        for (int i = 0; i < n; i++) {
            if (rowFlag[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Third pass: zero out columns
        for (int j = 0; j < m; j++) {
            if (colFlag[j]) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
