class Solution {
    
    public void rotate(int[][] matrix) {
      transport(matrix);
      reverse(matrix);
    }

    public void transport(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverse(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++){
            int start = 0, end = n-1;
            while(start<end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}

public class rotateImage {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}