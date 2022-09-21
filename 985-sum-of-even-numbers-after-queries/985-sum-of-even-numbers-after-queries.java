class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int[] answer = new int[queries.length];
        
        int evenSum = 0;
        //calculate the sum of all even numbers
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] %2 == 0)
                evenSum += nums[i];
        }
        
        for(int i = 0; i < queries.length; i++) {
            
            int index = queries[i][1];
            int value = queries[i][0];
            //if the original nums[index] is even, we need to deduct it from evenSum
            if(nums[index] % 2 == 0)
                evenSum -= nums[index];
            //updating the nums[index] value
            nums[index] += value;
            //if the updated nums[index] is even, we add it the evenSum
            if(nums[index] %2 == 0)
                evenSum += nums[index];
            
            answer[i] = evenSum;
        }
        
        return answer;
        
    }
}
