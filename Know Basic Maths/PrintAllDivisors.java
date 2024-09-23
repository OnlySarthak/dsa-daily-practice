public class PrintAllDivisors {
    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]);
        int n =36;

        //brute code
        System.out.println("part 1: ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
        
        //optimal
        System.out.println("part 2: ");
        // for (int i = 1; i*i <= n <= Math.sqrt(n); i++) {
        // eg 6*6 == 36     true
        // eg 6*8 == 48     false

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n%i == 0){
                System.out.println(i);
                
                if(i != n/i)             //ex: 6 != 6    |       if(Math.sqrt(n) != n/i)
                    System.out.println(n/i);
            }
        }



    }
}
