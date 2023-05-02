class Solution {
    public int arraySign(int[] nums) {
       int product = 1;
        for(int num : nums){
            if(num == 0)
                return 0;
            int val = num > 0 ? 1 :-1;
            product = product * val;
        }
        
        return (product > 0 ? 1 : -1);
        
    }
}