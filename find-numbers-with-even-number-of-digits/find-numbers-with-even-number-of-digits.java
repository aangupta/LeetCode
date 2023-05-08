class Solution {
    private int getDigitsCount(int num){
        int count = 0;
        if(num == 0)
            return 1;
        
        while(num > 0){
            count++;
            num = num/10;
        }
        return count;
    }
    public int findNumbers(int[] nums) {
        int evenNumberCount = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(getDigitsCount(nums[i]) % 2 == 0)
                evenNumberCount++;
        }
        return evenNumberCount;
        
        
    }
}