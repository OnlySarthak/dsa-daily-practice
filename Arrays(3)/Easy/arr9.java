class arr9 {
    //find sing no. where all no. are twice in array instead one...(Garanteed)
    //optimal solutions
    public int singleNumber(int[] nums) {
        int temp = 0;
            for(int i: nums){
                temp ^= i;
            }
            return temp;
    }
}
