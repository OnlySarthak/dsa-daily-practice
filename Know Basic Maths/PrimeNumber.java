public class PrimeNumber {
    public static void main(String[] args) {
        int n = 1;
        //Brute Forse
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if(n%i == 0)    counter++;
        }
        if(counter == 2)System.out.println("prime no.");
        else System.out.println("non Prime no.");

        //opt
        counter = 0;
        for (int i = 1; i*i <= n; i++) {
            if(n%i == 0){
                counter++;
                
                if(i != n/i)             //ex: 6 != 6    |       if(Math.sqrt(n) != n/i)
                    counter++;
            }
        }
        if(counter == 2)System.out.println("prime no.");
        else System.out.println("non Prime no.");
    }
}
