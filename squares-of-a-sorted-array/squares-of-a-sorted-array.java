class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int start = 0;
        int end = n-1;
        int index = n-1;
        
        while(start <= end){
            int leftSquare = nums[start] * nums[start];
            int rightSquare = nums[end] * nums[end];
            
            if(leftSquare >= rightSquare){
                result[index] = leftSquare;
                start++;
            } else {
                result[index] = rightSquare;
                end--;
            }
            index--;
            
        }
        
        return result;
        
    }
}