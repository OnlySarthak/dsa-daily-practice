public class SpiralRotateMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> Al = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        
        int top = 0, right = m-1, bottom = n-1, left = 0;
        
        while(left <= right && top <= bottom){
            // top side
            for(int i=left; i <= right ; i++){
                Al.add(matrix[top][i]);
            }
            top++;
            
            ////right side
            for(int i=top; i <= bottom ; i++){
                Al.add(matrix[i][right]);
            }
            right--;
            
            // bottom side (check boundary)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    Al.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // left side (check boundary)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    Al.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return Al;
    }
}
}
