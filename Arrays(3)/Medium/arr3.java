public class arr3 {
    //find majority element > (n/2)
    
    public int majorityElement(int[] nums) {
        //optimal solution
        
        //apply moores voting algo
        int count = 0;
        int element= 0;

        for(int num:nums){
            if(count == 0){
                element = num;
            }

            count += ( num == element) ? 1 : -1 ; 
        }
        //algo ended


        //cros-check
        count=0;
        for(int j:nums){
            if(j==element)count++;
        }

        if(count > (nums.length/2)){
            return element; 
        }

        return -1;
    }
}
