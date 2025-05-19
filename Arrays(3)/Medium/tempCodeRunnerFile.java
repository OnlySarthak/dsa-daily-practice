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