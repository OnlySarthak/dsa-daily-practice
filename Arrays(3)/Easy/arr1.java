
//Second Largest Element in an Array without sorting

import java.util.ArrayList;

class arr1{

    // static int length;
    public static void largestArrElement(){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(15);
        numbers.add(7);
        numbers.add(89);
        numbers.add(23);
        numbers.add(89);
        // numbers.add(42);

        
            int largest = numbers.get(0); 
            int slargest = -1; 
            
            for (int number : numbers) {
                if (number > largest) {
                    slargest = largest;
                    largest = number;
                }
                else if(number > slargest   && number != largest)
                {
                    slargest = number;
                }
                
            }
            System.out.println("The largest number in the ArrayList is: " + largest+ "\n and second largest is  "+slargest);
    }

    public static void smallestArrElement(){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(15);
        numbers.add(42);
        numbers.add(7);
        numbers.add(89);
        numbers.add(23);

        // Check if the ArrayList has at least two elements
        if (numbers.size() < 2) {
            System.out.println("The ArrayList must have at least two elements.");
            return;
        }

        // Initialize smallest and second smallest
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        // Find the smallest and second smallest using a for loop
        for (int i = 0; i < numbers.size(); i++) {
            int current = numbers.get(i);

            if (current < smallest) {
                secondSmallest = smallest; // Update second smallest
                smallest = current;       // Update smallest
            } else if (current < secondSmallest && current != smallest) {
                secondSmallest = current; // Update second smallest
            }
        }

        // Check if a valid second smallest exists
        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("There is no distinct second smallest number.");
        } else {
            System.out.println("The smallest number is: " + smallest);
            System.out.println("The second smallest number is: " + secondSmallest);
        }
    }

    public static void main(String[] args) {
        //optimal soluions
        largestArrElement();
        smallestArrElement();
    }
}