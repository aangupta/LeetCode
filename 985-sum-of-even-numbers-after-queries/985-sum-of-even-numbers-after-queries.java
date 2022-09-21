class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int[] answer = new int[queries.length];
        
        int evenSum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] %2 == 0)
                evenSum += nums[i];
        }
        
        for(int i = 0; i < queries.length; i++) {
            
            int index = queries[i][1];
            int value = queries[i][0];
            
            if(nums[index] % 2 == 0)
                evenSum -= nums[index];
            
            nums[index] += value;
            
            if(nums[index] %2 == 0)
                evenSum += nums[index];
            
            answer[i] = evenSum;
        }
        
        return answer;
        
    }
}