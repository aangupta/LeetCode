class Solution {
    
    private int subsetXORSumUtils(int[] nums, int index, int XOR) {
        
        if(index == nums.length)
            return XOR;
        
        int include = subsetXORSumUtils(nums, index + 1, nums[index] ^ XOR);
        int exclude = subsetXORSumUtils(nums, index + 1, XOR);
        
        return include + exclude;
    }
    public int subsetXORSum(int[] nums) {
        
        return subsetXORSumUtils(nums, 0, 0);
        
    }
}
//TC O(2^n)
//SC O(n) - recursive stack space
                                 