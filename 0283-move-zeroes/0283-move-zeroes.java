class Solution {
    public void moveZeroes(int[] nums) {
        
        int noOfZeros = 0;
        int index = 0;
        
        for(int i = 0; i < nums.length; i++){ 
            
            if(nums[i] != 0)
                nums[index++] = nums[i];   
        }
        
        for(int i = index; i < nums.length; i++ ){
            nums[i] = 0;
        }
        
    }
}


/* TC O(n) SC O(1) */
//Two Pointer Approach