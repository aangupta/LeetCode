class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        
        int count = 0;
        long sum = 0;
        
        for(int i = happiness.length-1; i >= 0; i--) {
            if(k == 0)
                break;
            sum += (long)(happiness[i]-count <= 0 ? 0 : happiness[i]-count);
            count++;
            k--;
        }
        
        return sum;
    }
    
}