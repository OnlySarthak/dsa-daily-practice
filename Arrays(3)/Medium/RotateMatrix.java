public class RotateMatrix {
    //brute
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        
        for(int i=0; i < n; i++){
            for(int j = 0 ; j<n ; j++){
                ans[j][n-1-i] = matrix[i][j];
            }
        }
        
         for(int i=0; i < n; i++){
            for(int j = 0 ; j<n ; j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }

    //optimal: Transverse > flip horizontaly
    public void rotate1(int[][] matrix) {
       int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
         
        // flip the matrix horizontaly
         for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    //experimental - failed
    public static void rotate3(int[][] matrix) {
        int n = matrix.length;
        int k1= n;
        int[]buff1 = new int[n];
        int[]buff2 = new int[n];

        while(k1 != 0){
            //p1: copy main buffer
            for(int j = 0 ; j<n ; j++){
                buff1[j] = matrix[n-k1][j];
            }

            //p2: copy container buffer
            for(int j = 0 ; j<n ; j++){
                buff2[j] = matrix[j][k1-1];
                System.out.println("copying"+j+" "+buff2[j]);
            }
            
            //p3: past main buffer
            for(int j = 0 ; j<k1 ; j++){
                matrix[j][k1-1] = buff1[j];
            }
            
            //p4: paste container buffer
            for(int j = k1 ; j<n ; j++){
                matrix[j][k1-1] = buff2[j];
                System.out.println(j+" "+buff2[j]);
            }

            k1--;
        }


        //print
         for(int i=0; i < n; i++){
            for(int j = 0 ; j<n ; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }


    public static void rotate4(int[][] matrix, int n){
        if(n==0){
            return;
        }
        //copy
        int[] arr=new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            arr[i] = matrix[matrix.length-n][i];
        }
        
        rotate4(matrix, n-1);
        
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][n - 1] = arr[i];
        }

        
        //print
        if(n==matrix.length){

            for(int i=0; i < matrix.length; i++){
                for(int j = 0 ; j<matrix.length ; j++){
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotate4(matrix,matrix.length);
    }

}