// package Striver;

public class Star_pattr {
    public static void main(String[] args) {
        // int n = 5;
        // pyramid(ODD)
        // for(int i = 0; i<n ; i++){                      //if i = 0
            
        //     for(int j =0 ; j < (n-1-i) ; j++ ){        //j = 0 to 3  (n-1-i = 4-1-0)
        //         System.out.print("  ");
        //     }
            
        //     for(int j = 0; j < 1+(i*2) ; j++){         //j = 0 to 1 (1+(i*2) = 1+(0*2))
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //invers(pyramid(ODD))
        // for(int i = n-1; i>=0 ; i--){               //if i = 3
            
        //     for(int j = 0 ; j < n-(i+1) ; j++ ){        // j = 0 to 0 (n-i = 3-3) 
        //         System.out.print("  ");
        //     }
            
        //     for(int j = 0; j < (i*2)+1 ; j++){     // j = 0 to 7 [(i*2)+1 = (3*2)+1]
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //invers(pyramid(ODD)) by striver
        // for(int i = 0; i<n ; i++){               //if i = 0
            
        //      for(int j =0 ; j < i ; j++ ){        // j = 0 to 0 
        //         System.out.print("  ");
        //     }
            
        //      for(int j = 0; j < 2*n - (2*i+1)  ; j++){     // j = 0 to 7 [(i*2)+1 = (3*2)+1]
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // //arrow shape by pattern
        // int limit = 0;
        // for (int i = 1; i <= (n*2)-1 ; i++) {
        // {
        //     limit = i;
        //     if(limit > n) limit = (n*2) - i;

        //         for (int j = 0; j < limit; j++) {
        //             System.out.print("*");
        //         }
        //         System.out.println();
        // }
    
        //bimary triangle
        // int start = 1;
        // for (int i = 0; i < n; i++) {
        //     if(i % 2 ==0) start = 1;
        //     else start = 0;

        //     for (int j = 0; j < i+1 ; j++) {
        //         System.out.print(start);

        //         start = 1- start;
        //     }
        //     System.out.println();
        // }

         //down side arrow in number
        //  int temp = 1;
        //  for (int i = 0; i < n; i++) {
        //     //1st triangle 
        //     for (int j = 0; j <= i; j++) {
        //         System.out.print(j+1);
        //     }

        //     //2nd triangle
        //     for (int j = 0; j < (n-(i+1))*2; j++) {             
        //         System.out.print(" ");
        //     }

        //     //3rd triangle
        //     for (int j = 0; j <= i ; j++) {
        //         System.out.print(temp-j);
        //     }

        //     //other
        //     temp++;
        //     System.out.println();
        //  }

        //simple triangle -13
        // int n2 = 1;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j <= i ; j++) {
        //         System.out.print(n2++ + " ");
        //     }
        //     System.out.println();
        // }

        //simple triangle of alphabet -14
        // char n2= 'F';
        // for (char i = n2 ; i > 'A'; i--) {
        //     for (char j = 'A'; j < i; j++ ) {
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }

        //tricky alphabet triangle -17
        // for (int i = 0 ; i < n; i++) {
        //     for (int j = 0; j < (n-1)-i ; j++) {
        //         System.out.print("  ");
        //     }
                
        //     char n2 = 'A';

        //     for (int j = 0; j < (i*2)+1 ; j++) {
        //         System.out.print(n2+" ");

        //         if( j < i ) n2++;
        //         else n2--;
        //     }


        //     System.out.println();
        // }

        //tricky alphabet part 2
        // final char n2 = 'E';
        // for (char i = 'E'; i >= 'A' ; i--) {
        //     for (char j = i ; j <= 'E' ; j++) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }

        //for loop kajukatali
        // for (int i = n; i > 0; i--) {
        //     //star
        //     for (int j = 0; j < i; j++) {
        //         System.out.print("* ");
        //     }
        //     //spaces
        //     for (int j = 0; j < (n-i)*2 ; j++) {
        //         System.out.print("  ");
        //     }
        //     //star
        //     for (int j = 0; j < i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // for (int i = 1; i <= n; i++) {
        //     //star
        //     for (int j = 0; j < i; j++) {
        //         System.out.print("* ");
        //     }
        //     //spaces
        //     for (int j = 0; j < (n-i)*2 ; j++) {
        //         System.out.print("  ");
        //     }
        //     //star
        //     for (int j = 0; j < i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // //star frame
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if(i==0 || i==n-1 || j==0 || j==n-1) System.out.print("* ");
        //         else System.out.print("  ");
        //     }
        //     System.out.println();
        // }

        
        

    }

}

