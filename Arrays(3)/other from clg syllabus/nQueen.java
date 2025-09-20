
public class nQueen {
    public static void main(String[] args) {
        int n = 5;
        int[][] board=new int[n][n];
        Engine(0, n, board);
    }

    public static void Engine(int row, int n,int[][] board){
        if(row==n){
            print(board,n);
            System.out.println();
            return;
        }

        for (int c = 0; c < n; c++) {
            if(isSafe(row, c, board)){
                board[row][c] = 1;
                Engine((row+1), n, board);
            }
            board[row][c] = 0;
        }
    }

    public static boolean isSafe(int r, int c, int[][] arr){
        int n = arr.length;
        
        //check top-bottom
        for (int i = 0; i <= r; i++) 
            if(arr[i][c] == 1)return false;

        //check diagorally
        for(int row=r, col=c; row>=0 && col>=0 ; row--, col-- )
            if(arr[row][col]==1)return  false;

        for(int row=r, col=c; row>=0 && col<n ; row--, col++ )
            if(arr[row][col]==1)return  false;

        return true;
    }

    public static void print(int[][] arr,int n){
        System.out.println("New Solution :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
