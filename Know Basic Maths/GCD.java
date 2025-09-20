import java.util.Scanner;
public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input two numbers
        System.out.print("Enter first number (n1): ");
        int n1 = sc.nextInt();
        
        System.out.print("Enter second number (n2): ");
        int n2 = sc.nextInt();
        
        // Part 1: Brute force method (1 to min(n1, n2))
        int minVal = Math.min(n1, n2);
        int gcdBruteForce = 1; // Start with gcd = 1
        for (int i = 1; i <= minVal; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcdBruteForce = i; // Update gcd if i is a common divisor
            }
        }
        System.out.println("GCD using brute force (1 to min(n1, n2)): " + gcdBruteForce);
        
        // Part 2: Optimized brute force (min(n1, n2) to 1)
        int gcdOptimizedBruteForce = 1;
        for (int i = minVal; i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcdOptimizedBruteForce = i;
                break; // Stop as soon as we find the GCD
            }
        }
        System.out.println("GCD using optimized brute force (min(n1, n2) to 1): " + gcdOptimizedBruteForce);
        
        // Part 3: Euclidean algorithm using subtraction
        int a = n1;
        int b = n2;
        while (a>0 && b>0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        int gcdEuclidean = a; // Or b, since a == b at this point
        System.out.println("GCD using Euclidean algorithm (subtraction): " + gcdEuclidean);
        
        // Part 4: Improved Euclidean algorithm using modulus
        int gcdImproved = gcdUsingModulus(n1, n2);
        System.out.println("GCD using improved Euclidean algorithm (modulus): " + gcdImproved);
        
        sc.close();
    }
    
    // Helper function for Part 4 (Improved Euclidean algorithm)
    public static int gcdUsingModulus(int a, int b) {
        if (b == 0) {
            return a; // Base case
        }
        return gcdUsingModulus(b, a % b); // Recursive call
    }
}
